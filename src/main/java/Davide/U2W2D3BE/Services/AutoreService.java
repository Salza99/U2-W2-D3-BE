package Davide.U2W2D3BE.Services;

import Davide.U2W2D3BE.entities.Autore;
import Davide.U2W2D3BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autori= new ArrayList<>();

    public long save(Autore body){
        Random random = new Random();
        body.setId(random.nextInt(1001, 2000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.autori.add(body);
        return body.getId();
    }

    public List<Autore> getAll(){
        return this.autori;
    }
    public Autore getSingleAutore(long id){
        Autore found = null;
        for (Autore autore: this.autori) {
            if (autore.getId() == id){
                found = autore;
            }
        }
        if (found != null) {
            return found;
        }else {
            throw new NotFoundException(id);
        }
    }
    public Autore updateAnAutore(long id, Autore body){
        Autore updatedAutore= this.getSingleAutore(id);
        updatedAutore.setNome(body.getNome());
        updatedAutore.setCognome(body.getCognome());
        updatedAutore.setEmail(body.getEmail());
        updatedAutore.setDataDiNascita(body.getDataDiNascita());
        updatedAutore.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return updatedAutore;
    }
    public void deleteAnAutore(long id){
        Autore toRemove = this.getSingleAutore(id);
        this.autori.remove(toRemove);
    }
}
