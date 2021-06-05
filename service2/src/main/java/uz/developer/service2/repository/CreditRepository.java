package uz.developer.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.developer.service2.model.Credit1;

@Repository
public interface CreditRepository extends JpaRepository<Credit1, Integer> {
}
