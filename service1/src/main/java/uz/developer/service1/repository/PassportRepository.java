package uz.developer.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.developer.service1.model.Passport;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

Optional<Passport> findByPinfl(@NotNull(message = "pinfl kiritilmagan") Long pinfl);

    Optional<Passport> findByPassportNumberAndPassportSeria(@NotNull(message = "passport raqam bo'sh") String passportNumber, @NotNull(message = "passport seriya bo'sh") String passportSeria);

    boolean existsByPassportNumberAndPassportSeria(@NotNull(message = "passport raqam bo'sh") String passportNumber, @NotNull(message = "passport seriya bo'sh") String passportSeria);

}
