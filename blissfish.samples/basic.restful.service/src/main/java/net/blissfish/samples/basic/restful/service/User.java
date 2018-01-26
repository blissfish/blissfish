package net.blissfish.samples.basic.restful.service;

public class User {

    private final String id;
    private final String userName;
    private final String email;
    
	public User(String id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}    
}
