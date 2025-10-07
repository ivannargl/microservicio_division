package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.*;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    
    private String nombre;
    private boolean activo;
    @OneToMany (cascade =CascadeType.ALL, orphanRemoval= true)
    @JoinColumn( name = "division_id")
    private List<ProgramaEducativo> programasEducativos;

}
