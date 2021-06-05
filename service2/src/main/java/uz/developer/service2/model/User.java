package uz.developer.service2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.developer.service2.model.enums.Gender;
import uz.developer.service2.model.templates.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_entity")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String userLastName;
    @Size(min = 6, max = 12)
    private String password;
    private String email;
    @Column(unique = true)
    @NotBlank
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
