package Davide.U2W2D3BE.Services;

import Davide.U2W2D3BE.entities.Autore;
import Davide.U2W2D3BE.exceptions.NotFoundException;
import Davide.U2W2D3BE.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepo;

    public long save(Autore body){
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        autoreRepo.save(body);
        return body.getId();
    }

    public List<Autore> getAll(){
        return autoreRepo.findAll();
    }
    public Autore getSingleAutore(long id){
        return autoreRepo.findById(id).orElseThrow(()-> new NotFoundException(id) );
    }
    public Autore updateAnAutore(long id, Autore body){
        Autore found = autoreRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        found.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        autoreRepo.save(found);
        return found;
    }
    public void deleteAnAutore(long id){
        autoreRepo.deleteById(id);
    }
}
