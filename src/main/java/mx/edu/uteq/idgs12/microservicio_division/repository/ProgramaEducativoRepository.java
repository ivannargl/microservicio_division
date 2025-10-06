package mx.edu.uteq.idgs12.microservicio_division.repository;

import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaEducativoRepository extends JpaRepository<ProgramaEducativo, Long> {
}
