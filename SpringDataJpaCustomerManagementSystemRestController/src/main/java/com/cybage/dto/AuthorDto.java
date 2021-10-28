package com.cybage.dto;

public class AuthorDto {
	private String email;
	private String name;
	private String contactNumber;
	private int bookId;
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "AuthorDto [email=" + email + ", name=" + name + ", contactNumber=" + contactNumber + ", bookId="
				+ bookId + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	

}
