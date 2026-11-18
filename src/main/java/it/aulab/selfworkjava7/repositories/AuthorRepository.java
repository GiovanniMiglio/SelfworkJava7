package it.aulab.selfworkjava7.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.aulab.selfworkjava7.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByName(String name);                         
    List<Author> findBySurname(String surname);                     
    List<Author> findByNameAndSurname(String name, String surname);
    @Query(value = "SELECT * FROM authors WHERE email LIKE %:domain", nativeQuery = true)
    List<Author> findByEmailDomain(@Param("domain") String domain);
}
