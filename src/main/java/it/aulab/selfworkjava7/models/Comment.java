package it.aulab.selfworkjava7.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table (name= "comments")

public class Comment {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "email", nullable = false ,length =150)
    private String email;
    @Column (name= "body", nullable =  false ,length =500)
    private String body;
    @Column (name= "date", nullable =  false ,length =8)
    private String date;
    @ManyToOne                          
    @JoinColumn(name = "post_id")    
    private Post post;
    public Comment(){
        
    }
    public Comment(String email,String body,String date, Post post){
        this.email= email;
        this.body = body;
        this.date= date;
        this.post= post;
        
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}

