package com.clinic.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinic.model.entities.MemberEntity;
import com.clinic.model.entities.MemberEntity.Role;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberModel {

	public void showView(String str) {
		try {
			Parent root = FXMLLoader.load(MemberModel.class.getResource(str));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection gettingConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/clinicdb?user=root&password=admin");
		System.out.println("connection success");
		return conn;
	}

	public MemberEntity loginFind(String loginName, String loginPass) {
		System.out.println("blah");
		String sql = "select * from member where memberName=? and password=?";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, loginName);
			pStatement.setString(2, loginPass);
			ResultSet rSet = pStatement.executeQuery();
			
			System.out.println("loginFind invoked");
			
			while (rSet.next()) {
				return getMember(rSet);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void create(MemberEntity member) {
		String str = "insert into member values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(str);
			pStatement.setString(1, member.getName());
			pStatement.setString(2, member.getIdentityCard());
			pStatement.setString(3, member.getRole().toString());
			pStatement.setString(4, member.getGender());
			pStatement.setString(5, member.getDateOfBirth());
			pStatement.setString(6, member.getAddress());
			pStatement.setString(7, member.getPhoneNumber());
			pStatement.setString(8, member.getEmail());
			pStatement.setString(9, member.getPassword());
			
			System.out.println("database successful");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public MemberEntity findByName(String name) {

		String str = "select * from member where memberName=?";
		try {
			Connection conn = gettingConnection();
			PreparedStatement pStatement = conn.prepareStatement(str);
			pStatement.setString(1, name);
			ResultSet rSet = pStatement.executeQuery();

			while (rSet.next()) {
				return getMember(rSet);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private MemberEntity getMember(ResultSet rSet) throws SQLException {
		MemberEntity member = new MemberEntity();
		member.setId(rSet.getInt("memberId"));
		member.setName(rSet.getString("memberName"));
		member.setIdentityCard(rSet.getString("identityCard"));
		member.setRole(Role.valueOf(rSet.getString("role")));
		member.setGender(rSet.getString("gender"));
		member.setDateOfBirth(rSet.getString("birthday"));
		member.setAddress(rSet.getString("address"));
		member.setPhoneNumber(rSet.getString("phoneNumber"));
		member.setEmail(rSet.getString("email"));
		member.setPassword(rSet.getString("password"));
		System.out.println("getMember invoked");
		return member;
	}

}
