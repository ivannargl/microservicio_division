package mx.edu.uteq.idgs12.microservicio_division.repository;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
List<Division> findByHabilitadoTrue();
}
