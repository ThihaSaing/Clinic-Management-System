package com.clinic.model.entities;

import java.util.Date;

public class RecordEntity {
	private int recordId;
	private int patientId;
	private int doctorId;
	private String disease;
	private String prescription;
	private Date date;
	private String consultingFees;
	private String medicineFees;

	public String getConsultingFees() {
		return consultingFees;
	}

	public void setConsultingFees(String consultingFees) {
		this.consultingFees = consultingFees;
	}

	public String getMedicineFees() {
		return medicineFees;
	}

	public void setMedicineFees(String medicineFees) {
		this.medicineFees = medicineFees;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
