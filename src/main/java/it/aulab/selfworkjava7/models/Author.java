package it.aulab.selfworkjava7.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table (name= "authors")
public class Author {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "firstname", nullable = false ,length =100)
    private String name;
    @Column (name= "lastname", nullable =  false ,length =100)
    private String surname;
    @OneToMany(mappedBy = "author")   
    private List<Post> posts;
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @Column (nullable = false ,length =150, unique = true)
    private String email;
    public Author(){
        
    }
    public Author (String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email= email;
        
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
