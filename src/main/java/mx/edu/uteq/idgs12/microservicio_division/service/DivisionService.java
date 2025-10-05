package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

   
}
