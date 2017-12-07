package net.blissfish.samples.basic.mongodb.service;

import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class User {
    @Id
    private String id;
    
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String email;
    
    private Date createdAt = new Date();
    
    public User() {
        super();
    }
    
    public User(String email) {
        this.email = email;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s']",
                id, email);
    }
}