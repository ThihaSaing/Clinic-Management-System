package com.clinic.model.entities;

public class PatientEntity {
	private int patientId;
	private String patientName;
	private String patientGender;
	private int patientAge;
	private String patientPhone;
	private String patientAddress;
	private String patientEmail;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return patientName;
	}

	public void setName(String name) {
		this.patientName = name;
	}

	public String getGender() {
		return patientGender;
	}

	public void setGender(String gender) {
		this.patientGender = gender;
	}

	public int getAge() {
		return patientAge;
	}

	public void setAge(int age) {
		this.patientAge = age;
	}

	public String getPhoneNumber() {
		return patientPhone;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.patientPhone = phoneNumber;
	}

	public String getAddress() {
		return patientAddress;
	}

	public void setAddress(String address) {
		this.patientAddress = address;
	}

	public String getEmail() {
		return patientEmail;
	}

	public void setEmail(String email) {
		this.patientEmail = email;
	}

}
