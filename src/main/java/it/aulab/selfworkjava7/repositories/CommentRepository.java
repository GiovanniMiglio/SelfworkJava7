package it.aulab.selfworkjava7.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.aulab.selfworkjava7.models.Post;
import it.aulab.selfworkjava7.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByEmail(String email);                         
    List<Comment> findByDate(String date);                     
    List<Comment> findByPost(Post post);
    
}
