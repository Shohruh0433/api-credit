package uz.developer.service2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.developer.service2.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
