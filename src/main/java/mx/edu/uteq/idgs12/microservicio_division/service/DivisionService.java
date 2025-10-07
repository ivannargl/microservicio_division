package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private ProgramaEducativoRepository programaEducativoRepository;


    public DivisionDTO agregarDivision(DivisionDTO divisionDTO) {
        Division division = new Division();
        division.setNombre(divisionDTO.getNombre());
        division.setActivo(true);

        Division guardada = divisionRepository.save(division);

        DivisionDTO resultado = new DivisionDTO();
        resultado.setId(guardada.getId());
        resultado.setNombre(guardada.getNombre());
        resultado.setActivo(guardada.isActivo());

        return resultado;
    }

    public DivisionDTO editarDivision(Long id, DivisionDTO divisionDTO) {
        Division divisionExistente = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada"));

        divisionExistente.setNombre(divisionDTO.getNombre());
        divisionExistente.setActivo(divisionDTO.isActivo());

        Division actualizada = divisionRepository.save(divisionExistente);

        DivisionDTO respuesta = new DivisionDTO();
        respuesta.setId(actualizada.getId());
        respuesta.setNombre(actualizada.getNombre());
        respuesta.setActivo(actualizada.isActivo());

        return respuesta;
    }

    public ProgramaEducativo editarProgramaEducativo(Long id, ProgramaEducativo detalles) {
        ProgramaEducativo existente = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa educativo no encontrado"));

        existente.setPrograma(detalles.getPrograma());
        existente.setActivo(detalles.isActivo());

        return programaEducativoRepository.save(existente);
    }


    //Esto lo voy a hacer yo

    public void eliminarProgramaEducativo(Long id) {
        ProgramaEducativo existente = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa educativo no encontrado"));
        programaEducativoRepository.delete(existente);
    }
}
