package it.aulab.selfworkjava7.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import it.aulab.selfworkjava7.models.Author;

@DataJpaTest   
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  
public class AuthorRepositoryTest {

    @Autowired                          
    AuthorRepository authorRepository;

    @BeforeEach                         
    public void load() {
        authorRepository.save(new Author("Mario", "Rossi", "mario@gmail.com"));
        authorRepository.save(new Author("Luigi", "Verdi", "luigi@libero.it"));
        authorRepository.save(new Author("Mario", "Bianchi", "mbianchi@gmail.com"));
    }

    @Test                               
    void findByName() {
        
        List<Author> result = authorRepository.findByName("Mario");

        
        assertThat(result)                              
            .hasSize(2)                                 
            .extracting("surname")                      
            .containsOnly("Rossi", "Bianchi");          
    }
    @Test                               
    void findBySurname() {
        
        List<Author> result = authorRepository.findBySurname("Verdi");

        
        assertThat(result)                              
            .hasSize(1)                                 
            .extracting("name")                      
            .containsOnly("Luigi");          
    }
    @Test                               
    void findByEmailDomain() {
        
        List<Author> result = authorRepository.findByEmailDomain("@gmail.com");

        
        assertThat(result)                              
            .hasSize(2)                                 
            .extracting("surname")                      
            .containsOnly("Rossi", "Bianchi");          
    }
}
