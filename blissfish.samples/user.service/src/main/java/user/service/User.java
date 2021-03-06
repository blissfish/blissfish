package user.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    private String uid;
    private String name;
    
    public User() {
	}
    
    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }
    
    public String getUid() {
        return uid;        
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "User[uid=%s, name='%s']",
                uid, name);
    }

}