package uz.developer.service2.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.developer.service2.dto.CreditDto;

import uz.developer.service2.model.Credit1;
import uz.developer.service2.model.Passport;
import uz.developer.service2.model.Survey;
import uz.developer.service2.repository.CreditRepository;
import uz.developer.service2.repository.SurveyRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CreditService {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
    @Autowired
RestTemplate restTemplate;

    @Autowired
    SurveyRepository surveyRepository;


    @Autowired
    CreditRepository creditRepository;

    public Passport getPassportBySeriaAndNumber(String seria, String number) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url="http://localhost:8081/api/passport/getPassportBySeriaAndNumber?seria="+seria+"&number="+number;

        ResponseEntity<Passport> exchange = restTemplate.exchange
                (url, HttpMethod.GET,entity,
                        Passport.class);
        return exchange.getBody();

  }

    public ResponseEntity<?>  getCredit(CreditDto creditDto) {
        Passport passport = getPassportBySeriaAndNumber(creditDto.getSeria(), creditDto.getNumber());

        if (passport == null) {
            return ResponseEntity.ok("Bunday passpor seria va raqamli foydalanuvchi topilmadi");
        }


        int countCredit=0;

        Double monthlySalary = creditDto.getSalary();
        Double annualIncome = monthlySalary * (double) 12 - (monthlySalary * (double) 12 * 0.3);
        if (annualIncome < creditDto.getCreditAmount()) {
            List<Credit1> all = creditRepository.findAll();
            String msg = "  siz so'ragan summa yillik daromadingizdan ko'p!!! \n";
            if (all.size() > 0) {
                msg += "Siz quyidagi kridet turlaridan birini tanlashingiz mumkin\n";

                for (int i = 0; i < all.size(); i++) {
                    if (all.get(i).getFromAmount() <= annualIncome) {
                        msg += "Kridit turi: " + all.get(i).getName() + " miqdori: " + all.get(i).getFromAmount() + " dan "
                                + all.get(i).getToAmount() + " gacha " + " foizi: " +
                                all.get(i).getPercent() + "% \n";
                        countCredit++;
                    }
                }
            }
            if (countCredit==0){
                msg = " Bu miqdorga to'gri keladigan kreditimiz mavjud emas \n";

            }
            return ResponseEntity.ok(" Hurmatli " + passport.getFirstName() + " " + passport.getLastName() + msg);

        } else {

            Survey survey = new Survey();
            survey.setCreditAmount(creditDto.getCreditAmount());
            survey.setSalary(creditDto.getSalary());
            survey.setDateOfBirth(passport.getDateOfBirth());
            survey.setFirstName(passport.getFirstName());
            survey.setLastName(passport.getLastName());
            survey.setPassportSeria(passport.getPassportSeria());
            survey.setPassportNumber(passport.getPassportNumber());
            Date date=new Date();
            survey.setCreateSurvey(date);
            survey.setPinfl(passport.getPinfl());

                        surveyRepository.save(survey);
            surveyRepository.save(survey);
            return ResponseEntity.ok("Hurmatli " + passport.getFirstName() + " " + passport.getLastName() + " sizning arizangiz qabul qilindi tez orada xodimlarimiz siz bilan bog'lanishadi");
        }
    }

}
