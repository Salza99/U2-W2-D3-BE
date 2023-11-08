package Davide.U2W2D3BE.Controller;

import Davide.U2W2D3BE.Services.BlogPostService;
import Davide.U2W2D3BE.entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public long createNewBlogPost(@RequestBody BlogPost body) {
         return blogPostService.save(body);
    }
    @GetMapping("")
    public List<BlogPost> getAll(){
        return blogPostService.getAllBlogPost();
    }
    @GetMapping("/{id}")
    public BlogPost findBlogPostById(@PathVariable long id){
        return blogPostService.getSingleBlogPost(id);
    }
    @PutMapping("/{id}")
    public BlogPost findBlogPostByIdAndUpdate(@PathVariable long id, @RequestBody BlogPost body){
       return blogPostService.updateABlogPost(id, body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findBlogPostByIdAndDelete(@PathVariable long id){
        blogPostService.deleteABlogPost(id);
    }
}
