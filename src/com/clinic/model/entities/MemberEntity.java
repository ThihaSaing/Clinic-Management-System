package com.clinic.model.entities;

public class MemberEntity {
	private int memberId;
	private String memberName;
	private String memberIdCard;
	private Role role;
	private String memberGender;
	private String dateOfBirth;
	private String memberAddress;
	private String memberPhone;
	private String memberEmail;
	private String memberPassword;

	public enum Role {
		Admin, Doctor, Receptionist
	}

	public int getId() {
		return memberId;
	}

	public void setId(int id) {
		this.memberId = id;
	}

	public String getName() {
		return memberName;
	}

	public void setName(String name) {
		this.memberName = name;
	}

	public String getIdentityCard() {
		return memberIdCard;
	}

	public void setIdentityCard(String identityCard) {
		this.memberIdCard = identityCard;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		return memberGender;
	}

	public void setGender(String gender) {
		this.memberGender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return memberAddress;
	}

	public void setAddress(String address) {
		this.memberAddress = address;
	}

	public String getPhoneNumber() {
		return memberPhone;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.memberPhone = phoneNumber;
	}

	public String getEmail() {
		return memberEmail;
	}

	public void setEmail(String email) {
		this.memberEmail = email;
	}

	public String getPassword() {
		return memberPassword;
	}

	public void setPassword(String password) {
		this.memberPassword = password;
	}

}
