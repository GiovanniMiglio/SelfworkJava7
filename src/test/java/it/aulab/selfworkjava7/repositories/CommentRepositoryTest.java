package it.aulab.selfworkjava7.repositories;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import it.aulab.selfworkjava7.models.Author;
import it.aulab.selfworkjava7.models.Comment;
import it.aulab.selfworkjava7.models.Post;
@DataJpaTest   
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  
public class CommentRepositoryTest {
    @Autowired                          
    AuthorRepository authorRepository;
    @Autowired 
    PostRepository postRepository;
    @Autowired 
    CommentRepository commentRepository;
    private Author mario;
    private Post post1;
    private Post post2;
    @BeforeEach                         
    public void load() {
        mario = authorRepository.save(
            new Author("Mario", "Rossi", "mario@gmail.com")
        );
        
        post1 = postRepository.save(
            new Post("Primo post", "Testo del primo post", "11081201", mario)
        );
        
        post2 = postRepository.save(
            new Post("Secondo post", "Testo del secondo post", "12091201", mario)
        );
        commentRepository.save(new Comment(
            "anna@example.com", "Bel post!", "13081201", post1
        ));
        commentRepository.save(new Comment(
            "luca@example.com", "Grazie per la condivisione.", "14081201", post1
        ));
        
        commentRepository.save(new Comment(
            "sara@example.com", "Molto interessante!", "13091201", post2
        ));
        commentRepository.save(new Comment(
            "paolo@example.com", "Aspetto il prossimo articolo.", "14091201", post2
        ));
    }
        @Test 
        void findByEmail(){
        List<Comment> result = commentRepository.findByEmail("anna@example.com");
        assertThat(result)                              
        .hasSize(1)                                 
        .extracting("date")                      
        .containsOnly("13081201");  
    }
     @Test
    void findByDate(){
        List<Comment> result = commentRepository.findByDate("13091201");
        assertThat(result)                              
        .hasSize(1)                                 
        .extracting("email")                      
        .containsOnly("sara@example.com");
}
@Test 
void findByPost(){
    List<Comment> result = commentRepository.findByPost(post1);
    assertThat(result)
    .hasSize(2)
    .extracting("email")
    .containsOnly("anna@example.com", "luca@example.com");
}
}
