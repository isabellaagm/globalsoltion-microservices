package br.com.fiap.ra_552327.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ra_552327.dto.VoluntarioRequestCreate;
import br.com.fiap.ra_552327.dto.VoluntarioRequestUpdate;
import br.com.fiap.ra_552327.model.Voluntario;
import br.com.fiap.ra_552327.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public Voluntario createVoluntario(VoluntarioRequestCreate dto) {
        return  voluntarioRepository.save(dto.toModel());
    }

    public Optional<Voluntario> getVoluntarioById(Long id) {
        return voluntarioRepository.findById(id);
    }

    public List<Voluntario> getAll() {
        return voluntarioRepository.findAll();
    }

    public Optional<Voluntario> updateVoluntario(VoluntarioRequestUpdate dto, Long id){
        return voluntarioRepository.findById(id)
        .map(v -> voluntarioRepository.save(dto.toModel(v)));
    }

    public boolean deleteVoluntario(Long id) {
        if(voluntarioRepository.existsById(id)){
            voluntarioRepository.deleteById(id);

            return true;
        }
        return false;
        
    }

}
