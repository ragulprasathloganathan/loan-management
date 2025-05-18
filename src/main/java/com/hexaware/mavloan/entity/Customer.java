package com.hexaware.mavloan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String 	address;
	@Column(nullable=false)
	private String status;
	@Column(nullable=false)
	private long contact;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String panProof;
	@Column(nullable=false)
	private String aadharProof;
	
	
	@OneToOne
	private User user; //findByUserUsername(String username)
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPanProof() {
		return panProof;
	}

	public void setPanProof(String panProof) {
		this.panProof = panProof;
	}

	public String getAadharProof() {
		return aadharProof;
	}

	public void setAadharProof(String aadharProof) {
		this.aadharProof = aadharProof;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
