package Davide.U2W2D3BE.Services;

import Davide.U2W2D3BE.entities.BlogPost;
import Davide.U2W2D3BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts= new ArrayList<>();

    public long save(BlogPost body){
        Random random = new Random();
        body.setId(random.nextInt(1, 1000));
        this.blogPosts.add(body);
        return body.getId();
    }
    public List<BlogPost> getAllBlogPost(){
        return blogPosts;
    }
    public BlogPost getSingleBlogPost(long id){
        BlogPost found = null;
        for (BlogPost blogpost: this.blogPosts) {
            if (blogpost.getId() == id){
                 found = blogpost;
            }
        }
        if (found != null) {
            return found;
        }else {
            throw new NotFoundException(id);
        }
    }
    public BlogPost updateABlogPost(long id, BlogPost body){
        BlogPost found = null;
        for (BlogPost blogpost: this.blogPosts) {
            if (blogpost.getId() == id){
                found = blogpost;
                found.setCategoria(body.getCategoria());
                found.setContenuto(body.getContenuto());
                found.setTitolo(body.getTitolo());
                found.setCover(body.getCover());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }
    public void deleteABlogPost(long id) {
        BlogPost found = null;
        for (BlogPost blogpost: this.blogPosts) {
            if (blogpost.getId() == id){
                found = blogpost;
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        }else {
            this.blogPosts.remove(found);
        }
    }
}
