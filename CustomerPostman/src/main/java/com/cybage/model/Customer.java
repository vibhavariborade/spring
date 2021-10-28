package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@Column(name="name")
	@Size(min=3 , max=7 , message="Name should be between 3 to 7")
	private String name;
	
	@Column(name="address")
	@NotEmpty(message="Address should not be  empty")
	private String address;
	
	@Column(name="emailId")
	@NotEmpty(message="email id should not be  empty")
	private String emailId;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String address, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId + "]";
	}
	
	

}
