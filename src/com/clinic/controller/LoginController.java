package com.clinic.controller;

import com.clinic.model.MemberModel;
import com.clinic.model.entities.MemberEntity;
import com.clinic.model.entities.MemberEntity.Role;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private VBox home;

	@FXML
	private VBox login;

	@FXML
	private TextField userName;

	@FXML
	private PasswordField password;

	@FXML
	private RadioButton adminRole;

	@FXML
	private RadioButton doctorRole;

	@FXML
	private RadioButton receptionRole;

	@FXML
	void close(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void toLoginForm(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Loginform.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			home.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void login(ActionEvent event) {
		try {
			String str = null;
			MemberModel memberModel = new MemberModel();
			MemberEntity member = memberModel.loginFind(userName.getText(), password.getText());
			if (member.getRole() == Role.Admin) {
				str = "../view/Admin.fxml";
			} else if (member.getRole() == Role.Doctor) {
				str = "../view/Doctor.fxml";
			} else {
				str = "../view/Reception.fxml";
			}
			memberModel.showView(str);
			login.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
