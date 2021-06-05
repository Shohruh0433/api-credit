package uz.developer.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.developer.service1.repository.PassportRepository;
import uz.developer.service1.model.Passport;

import java.util.Optional;

@Service
public class PassportService {


    private final PassportRepository passportRepository;

    @Autowired
    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<?> create(Passport passport) {
        Optional<Passport> byPinfl = passportRepository.findByPinfl(passport.getPinfl());
        boolean b = passportRepository.existsByPassportNumberAndPassportSeria(passport.getPassportNumber(), passport.getPassportSeria());
        if (!byPinfl.isPresent()) {
            return ResponseEntity.status(200).body("Bunday PINFL tizimda mavjud!");
        } else if (b) {
            return ResponseEntity.status(200).body("Bunday seriyali va raqamli  passport tizimda  mavjud!");
        } else passportRepository.save(passport);
        return ResponseEntity.status(200).body("Passport malumotlari saqlandi!");

    }

    public ResponseEntity<Passport> getPassport(String seria, String number){
        Optional<Passport> optionalPassport = passportRepository.findByPassportNumberAndPassportSeria(number, seria);
          if (!optionalPassport.isPresent())
              return null;
        return ResponseEntity.ok(optionalPassport.get());
    }

    public ResponseEntity<?> getPasspostByPinfl(Long pinfl){

        Optional<Passport> optionalPassport = passportRepository.findByPinfl(pinfl);
        if (!optionalPassport.isPresent()) return ResponseEntity.ok("Bunday PNFL mavjud emas!");
        return ResponseEntity.ok(optionalPassport.get());

    }

}
