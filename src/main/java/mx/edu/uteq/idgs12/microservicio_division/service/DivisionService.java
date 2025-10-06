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

    public Division editarDivision(Long id, DivisionDTO dto) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada"));
        division.setNombre(dto.getNombre());
        division.setActivo(dto.isActivo());
        return divisionRepository.save(division);
    }
    
}
