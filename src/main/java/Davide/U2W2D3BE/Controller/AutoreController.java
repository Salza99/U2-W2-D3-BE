package Davide.U2W2D3BE.Controller;

import Davide.U2W2D3BE.Services.AutoreService;
import Davide.U2W2D3BE.entities.Autore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public long crateNewAutore(@RequestBody Autore body){
        return autoreService.save(body);
    }
    @GetMapping("")
    public List<Autore> getAllAutori(){
        return autoreService.getAll();
    }
    @GetMapping("/{id}")
    public Autore findAutoreById(@PathVariable long id){
        return autoreService.getSingleAutore(id);
    }
    @PutMapping("/{id}")
    public Autore findAutoreByIdAndUpdate(@PathVariable long id, @RequestBody Autore body){
        return autoreService.updateAnAutore(id, body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAutoreByIdAndDelete(@PathVariable long id){
        autoreService.deleteAnAutore(id);
    }
}
