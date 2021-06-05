package uz.developer.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.service1.service.PassportService;
import uz.developer.service1.model.Passport;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/passport")
public class PassportController {


    private final PassportService passprtService;

    @Autowired
    public PassportController(PassportService passprtService) {
        this.passprtService = passprtService;
    }


    @PostMapping("/create-passport")
    public ResponseEntity<?> create(@Valid @RequestBody Passport passport) {
        return passprtService.create(passport);
    }

    @GetMapping("/getPassportBySeriaAndNumber")
    public ResponseEntity<Passport> getPassport( @RequestParam(value = "seria") String seria, @RequestParam("number") String number) {
        ResponseEntity<Passport> passport = passprtService.getPassport(seria, number);

        return passport;
    }

    @GetMapping("/get-pinfl/{pinfl}")
    public ResponseEntity<?> getPassportWithPinfl(@PathVariable("pinfl") Long pinfl) {
        return passprtService.getPasspostByPinfl(pinfl);
    }
}

