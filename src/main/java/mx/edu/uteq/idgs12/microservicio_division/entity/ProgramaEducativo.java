package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "programas_educativos")
public class ProgramaEducativo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String programa;
    private boolean activo;
}
