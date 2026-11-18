CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,   
    firstname VARCHAR(100) NOT NULL,        
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE      
);
CREATE TABLE posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR (100) NOT NULL,
    body TEXT (500) NOT NULL,
    publish_date CHAR (8) NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
CREATE TABLE comments (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     email VARCHAR(150) NOT NULL,
     body TEXT (500) NOT NULL,
     date CHAR (8) NOT NULL,
     post_id BIGINT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES posts(id)

);