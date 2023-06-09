package com.codingdojo.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
	@Size(min = 5, max=200 ,message = "First name must be at least 5 characters")
    private String firstName;
    
    @NotNull
	@Size(min = 5, max=200 ,message = "Lastname must be at least 5 characters")
    private String lastName;
    
    private int age;
    
    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {}
    

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
	public Dojo getDojo() {
		return dojo;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}

    
}