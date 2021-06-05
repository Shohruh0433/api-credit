package uz.developer.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import uz.developer.service2.dto.CreditDto;

import uz.developer.service2.service.CreditService;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/api/credit")
public class CreditController {






    private final CreditService creditService;


    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;

    }

    @RequestMapping(value = "/get-credit")
    public ResponseEntity getCredit(@Valid @RequestBody CreditDto creditDto) {
        return creditService.getCredit(creditDto);
    }

//    @RequestMapping(value = "/get-passport-with-pinfl", method = RequestMethod.POST)
//    public ResponseEntity getPassport(@RequestBody Credit1 credit){
//        Long pinfl =  credit.getPinfl();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Long> entity = new HttpEntity<Long>(pinfl, headers);
//        return ResponseEntity.ok(restTemplate.exchange("http://localhost:8081/api/passport/get-pinfl/" +pinfl, HttpMethod.GET,entity,String.class).getBody());
//
//    }



}
