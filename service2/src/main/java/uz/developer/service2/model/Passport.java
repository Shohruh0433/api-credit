package uz.developer.service2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor

public class Passport {

    private Long id;
    private String firstName;
    private String lastName;
    private String givenByWhom;
    private String passportSeria;
    private String  passportNumber;
    private String dateOfBirth;
    private String dateOfIssue;
    private String dateOfExpire;
    private Long pinfl;
    private String placeOfPlace;

    public Passport() {
    }




}
