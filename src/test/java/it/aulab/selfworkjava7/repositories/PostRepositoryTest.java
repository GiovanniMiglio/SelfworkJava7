package it.aulab.selfworkjava7.repositories;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import it.aulab.selfworkjava7.models.Author;
import it.aulab.selfworkjava7.models.Post;
@DataJpaTest   
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  

public class PostRepositoryTest {
    
    @Autowired                          
    AuthorRepository authorRepository;
    @Autowired 
    PostRepository postRepository;
    private Author mario;
    private Author luigi;
    @BeforeEach                         
    public void load() {
        
        mario = authorRepository.save(new Author("Mario", "Rossi", "mario@gmail.com"));
        luigi = authorRepository.save(new Author("Luigi", "Rossi", "luigi@gmail.com"));
        
        postRepository.save(new Post("Crollo ponte", "Crollo ponte di pietra nella mesopotamia", "11081201", mario));
        postRepository.save(new Post("Costruzione ponte", "Costruzione ponte di mattoni nella mesopotamia", "12091201", mario));
        postRepository.save(new Post("Inaugurazione ponte", "Inaugurazione ponte di pietra nella mesopotamia", "20061203", luigi));
        
    }
    
    @Test 
    void findByTitle(){
        List<Post> result = postRepository.findByTitle("Crollo ponte");
        assertThat(result)                              
        .hasSize(1)                                 
        .extracting("publishDate")                      
        .containsOnly("11081201");   
    }
    @Test 
    void findByPublishDate(){
        List<Post> result = postRepository.findByPublishDate("20061203");
        assertThat(result)                              
        .hasSize(1)                                 
        .extracting("title")                      
        .containsOnly("Inaugurazione ponte");   
    }
    @Test 
    void findByAuthor(){
        List<Post> result = postRepository.findByAuthor(mario);
        assertThat(result)                              
        .hasSize(2);                                 
        
    }
    @Test 
    void findByPostFromDate(){
        List<Post> result = postRepository.findByPostFromDate("12091201");
        assertThat(result)                              
        .hasSize(2)
        .extracting("title")
        .containsExactly(
           "Inaugurazione ponte",
            "Costruzione ponte"
        );  
        
        
    }
}