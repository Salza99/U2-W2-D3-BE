package Davide.U2W2D3BE.Services;

import Davide.U2W2D3BE.entities.BlogPost;
import Davide.U2W2D3BE.exceptions.BadRequestException;
import Davide.U2W2D3BE.exceptions.NotFoundException;
import Davide.U2W2D3BE.repositories.AutoreRepository;
import Davide.U2W2D3BE.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepo;
    @Autowired
    private AutoreRepository autoreRepo;

    public long save(BlogPost body){
        body.setCover("https://picsum.photos/200/300");
        if (body.getAutore() == null) {
            throw new BadRequestException("Nessun Autore inserito");
        }else if (!autoreRepo.findById(body.getAutore().getId()).isPresent()) {
            throw new NotFoundException("blogpost",body.getAutore().getId());
        }else {
            blogPostRepo.save(body);
        }

        return body.getId();
    }
    public Page<BlogPost> getAllBlogPost(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogPostRepo.findAll(pageable);
    }
    public BlogPost getSingleBlogPost(long id){
        return blogPostRepo.findById(id).orElseThrow(() -> new NotFoundException("blogpost",id));
    }
    public BlogPost updateABlogPost(long id, BlogPost body){
        BlogPost found = blogPostRepo.findById(id).orElseThrow(()-> new NotFoundException("blogpost",id));
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
