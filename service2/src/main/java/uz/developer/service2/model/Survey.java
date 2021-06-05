package uz.developer.service2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data

public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
    private String passportSeria;
    private String  passportNumber;
    private String dateOfBirth;
    private Long pinfl;
    private double salary;
    private double creditAmount;
    private Date createSurvey;


}
