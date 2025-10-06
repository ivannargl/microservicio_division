package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;
    
    public DivisionDTO agregarDivision(DivisionDTO divisionDTO) {
        Division division = new Division();
        division.setNombre(divisionDTO.getNombre());
        division.setActivo(true);

        Division guardada = divisionRepository.save(division);

        // Convertir la entidad guardada en DTO de respuesta
        DivisionDTO resultado = new DivisionDTO();
        resultado.setId(guardada.getId());
        resultado.setNombre(guardada.getNombre());
        resultado.setActivo(guardada.isActivo());

        return resultado;
    }
    
}
