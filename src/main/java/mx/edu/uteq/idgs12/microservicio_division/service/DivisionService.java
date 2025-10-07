package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Lista todas
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    //Lista solo las habilitadas
    public List<Division> findHabilitadas() {
        return divisionRepository.findByHabilitadoTrue();
    }

    // Agregar
    public Division add(Division division) {
        division.setHabilitado(true);
        return divisionRepository.save(division);
    }

    public Division enable(Long id) {
        Optional<Division> divisionOpt = divisionRepository.findById(id);
        if (divisionOpt.isPresent()) {
            Division d = divisionOpt.get();
            d.setHabilitado(true);
            return divisionRepository.save(d);
        }
        return null;
    }
    

    //  Editar división
    public Division update(Long id, Division division) {
        Optional<Division> existing = divisionRepository.findById(id);
        if (existing.isPresent()) {
            Division d = existing.get();
            d.setNombre(division.getNombre());
            return divisionRepository.save(d);
        }
        return null;
    }

    // Eliminar
    public void delete(Long id) {
        divisionRepository.deleteById(id);
    }

    public Division disable(Long id) {
        Optional<Division> divisionOpt = divisionRepository.findById(id);
        if (divisionOpt.isPresent()) {
            Division d = divisionOpt.get();
            d.setHabilitado(false);
            return divisionRepository.save(d);
        }
        return null;
    }

   
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
