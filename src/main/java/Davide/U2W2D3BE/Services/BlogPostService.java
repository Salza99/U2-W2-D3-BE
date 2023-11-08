package Davide.U2W2D3BE.Services;

import Davide.U2W2D3BE.entities.BlogPost;
import Davide.U2W2D3BE.exceptions.NotFoundException;
import Davide.U2W2D3BE.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepo;

    public long save(BlogPost body){
        body.setCover("https://picsum.photos/200/300");
        blogPostRepo.save(body);
        return body.getId();
    }
    public List<BlogPost> getAllBlogPost(){
        return blogPostRepo.findAll();
    }
    public BlogPost getSingleBlogPost(long id){
        return blogPostRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public BlogPost updateABlogPost(long id, BlogPost body){
        BlogPost found = blogPostRepo.findById(id).orElseThrow(()-> new NotFoundException(id));
        found.setCategoria(body.getCategoria());
        found.setContenuto(body.getContenuto());
        found.setTitolo(body.getTitolo());
        found.setTempoDiLettura(body.getTempoDiLettura());
        blogPostRepo.save(found);
        return found;
    }
    public void deleteABlogPost(long id) {
        blogPostRepo.deleteById(id);
    }
}
