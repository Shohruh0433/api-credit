package uz.developer.service2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor

public class CreditDto {
    @NotNull(message = "seria kiritilmagan")
private String seria;
    @NotNull(message = "passport nomer kiritilmagan")
private String  number;
    @NotNull(message = "oylik kiritilmagan")
private Double salary;
    @NotNull(message = "kiredit miqdori kiritilmagan")
private Double creditAmount;

}
