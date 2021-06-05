package uz.developer.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.service2.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
