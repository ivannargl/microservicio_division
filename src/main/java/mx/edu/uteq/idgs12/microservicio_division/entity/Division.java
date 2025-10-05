package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "divisiones")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private boolean activo;
    private boolean habilitado = true;
    
    @OneToMany (cascade =CascadeType.ALL, orphanRemoval= true)
    @JoinColumn( name = "division_id")
    private List<ProgramaEducativo> programasEducativos;

}