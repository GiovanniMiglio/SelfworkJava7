package it.aulab.selfworkjava7.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.aulab.selfworkjava7.models.Author;
import it.aulab.selfworkjava7.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByTitle(String title);                         
    List<Post> findByPublishDate(String publishDate);                     
    List<Post> findByAuthor(Author author);
    @Query(value = "SELECT * FROM posts WHERE publish_date >= :date ORDER BY publish_date DESC", nativeQuery = true)
    List<Post> findByPostFromDate(@Param("date") String date);
}
