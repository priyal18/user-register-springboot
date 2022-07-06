package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User{
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
     
//    public User()
//    {
//    	super();
//    }
//    
//    //setters
//    public void setId(Long id)
//    {
//    	this.id = id;
//    }
//    public void setEmail(String email)
//    {
//    	this.email = email;
//    }
//    public void setPassword(String password)
//    {
//    	this.password = password;
//    }
//    public void setFirstName(String firstName)
//    {
//    	this.firstName = firstName;
//    }
//    public void setLastName(String lastName)
//    {
//    	this.lastName = lastName;
//    }
//    
//    //getters
//    public Long getId()
//    {
//    	return this.id;
//    }
//    
//    public String getEmail()
//    {
//    	return this.email;
//    }
//    
//    public String getPassword()
//    {
//    	return this.password;
//    }
//    
//    public String getFirstName()
//    {
//    	return this.firstName;
//    }
//    
//    public String getLastName()
//    {
//    	return this.lastName;
//    }
       
}
