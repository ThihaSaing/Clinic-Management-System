package com.clinic.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorController {

	@FXML
	private VBox doctor;

	@FXML
	private MenuItem viewPatient;

	@FXML
	private MenuItem addPrescription;

	@FXML
	private MenuItem changePassword;

	@FXML
	private MenuItem logout;

	@FXML
	private VBox doVbViewPatient;

	@FXML
	private TextField patientId;

	@FXML
	private TableView<?> patientTable;

	@FXML
	private VBox doVbAddPrescription;

	@FXML
	private TextField patientName;

	@FXML
	private TextField patientDisease;

	@FXML
	private TextArea patientPrescription;

	@FXML
	private VBox doVbChangePassword;

	@FXML
	private PasswordField oldPassword;

	@FXML
	private PasswordField newPassword;

	@FXML
	private PasswordField confirmPassword;

	@FXML
	void EditMenu(ActionEvent event) {

		changePassword.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				doVbChangePassword.visibleProperty().setValue(true);
				doVbViewPatient.visibleProperty().setValue(false);
				doVbAddPrescription.visibleProperty().setValue(false);
			}
		});

		logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("../view/Loginform.fxml"));
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.show();
					doctor.getScene().getWindow().hide();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@FXML
	void PatientMenu(ActionEvent event) {
		viewPatient.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				doVbChangePassword.visibleProperty().setValue(false);
				doVbViewPatient.visibleProperty().setValue(true);
				doVbAddPrescription.visibleProperty().setValue(false);
			}
		});

		addPrescription.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				doVbChangePassword.visibleProperty().setValue(false);
				doVbViewPatient.visibleProperty().setValue(false);
				doVbAddPrescription.visibleProperty().setValue(true);
			}
		});
	}

	@FXML
	void findPatient(ActionEvent event) {

	}

	@FXML
	void updatePassword(ActionEvent event) {

	}

	@FXML
	void updatePatient(ActionEvent event) {

	}
}
