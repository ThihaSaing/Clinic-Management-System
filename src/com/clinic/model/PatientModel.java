package com.clinic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinic.model.entities.PatientEntity;

public class PatientModel {

		private Connection gettingConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/clinicDB?user=root&password=admin");
		return conn;
	}
	
	public PatientEntity showAll() {
		String sql = "select * from patient";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(sql);
		
			ResultSet rSet = pStatement.executeQuery();

			while (rSet.next()) {
				return getPatient(rSet);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void create(PatientEntity patient) {
		String str = "insert into patient values (default, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(str);
			pStatement.setString(1, patient.getName());
			pStatement.setString(2, patient.getGender());
			pStatement.setInt(3, patient.getAge());
			pStatement.setString(4, patient.getPhoneNumber());
			pStatement.setString(5, patient.getAddress());
			pStatement.setString(6, patient.getEmail());
			

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public PatientEntity findByName(String name) {

		String str = "select * from patient where patientName=?";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(str);
			pStatement.setString(1, name);
			ResultSet rSet = pStatement.executeQuery();

			while (rSet.next()) {
				return getPatient(rSet);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ThihaSaing
	// create
	// findAll
	// findById

	private PatientEntity getPatient(ResultSet rSet) throws SQLException {
		PatientEntity patient = new PatientEntity();
		patient.setPatientId(rSet.getInt("patientId"));
		patient.setName(rSet.getString("patientName"));
		patient.setGender(rSet.getString("gender"));
		patient.setAge(rSet.getInt("age"));
		patient.setPhoneNumber(rSet.getString("phoneNumber"));
		patient.setAddress(rSet.getString("address"));
		patient.setEmail(rSet.getString("email"));
		
		return null;
	}

}
