package uz.developer.service1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Data
@AllArgsConstructor
@Table(name = "passport_entity",uniqueConstraints =
@UniqueConstraint(columnNames = {"passportSeria","passportNumber"}))
public class Passport  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "ism kiritilmagan")
    private String firstName;
    @NotNull(message = "familiya kiritilmagan")
    private String lastName;
    private String givenByWhom;
    @Column(length = 9, unique = true)
    @NotNull(message = "passport seriya bo'sh")
    private String passportSeria;
    @NotNull(message = "passport raqam bo'sh")
    @Column(length = 7)
    private String  passportNumber;
    @NotNull(message = "Tugilgan vaqt kiritilmagan")
    private String dateOfBirth;
    @NotNull(message = "passport berilgan vaqt kiritilmagan")
    private String dateOfIssue;
    @NotNull(message = "passport amal qilish muddati kiritilmagan")
    private String dateOfExpire;
    @Column(length = 14, unique = true)
    @NotNull(message = "pinfl kiritilmagan")
    private Long pinfl;
    @NotNull(message = "passport berilgan joy kiritilmagan")
    private String placeOfPlace;

    public Passport() {
    }




}
