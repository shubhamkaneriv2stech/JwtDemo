package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true,name = "Username" ,nullable =false,length = 200)
	private String username;
	
	@Column(name = "Password",nullable = false,length = 200)
	private String password;
	
	@Column(name = "Status")

    //@Column(columnDefinition = "boolean default false")
	private boolean enabled;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

	public User(long id, String username, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
//	
//	d long auto generated
//	Username varchar 200 not null unique
//	Password  varchar 200 not null stored in masked way
//	Status boolean default N

	
}
