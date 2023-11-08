package Davide.U2W2D3BE.repositories;

import Davide.U2W2D3BE.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
