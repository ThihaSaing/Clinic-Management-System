package com.clinic.controller;

import com.clinic.model.MemberModel;
import com.clinic.model.entities.MemberEntity;
import com.clinic.model.entities.MemberEntity.Role;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminController {

	@FXML
	private VBox admin;

	@FXML
	private MenuItem addMember;

	@FXML
	private MenuItem changePassword;

	@FXML
	private MenuItem logout;

	@FXML
	private MenuItem viewDoctor;
	
	 @FXML
	    private VBox viewDoctorImg;
	@FXML
	
	private MenuItem viewReception;

	@FXML
	private MenuItem viewPatient;

	@FXML
	private VBox adVbAddDoctor;

	@FXML
	private TextField memberId;

	@FXML
	private TextField memberName;

	@FXML
	private TextField idendityCard;

	@FXML
	private DatePicker dateOfBirth;

	@FXML
	private RadioButton doctorRbt;

	@FXML
	private RadioButton receptionistRbt;

	@FXML
	private RadioButton adminRbt;

	@FXML
	private TextField memberAddress;

	@FXML
	private TextField memberPhone;

	@FXML
	private TextField memberEmail;

	@FXML
	private PasswordField memberPassword;

	@FXML
	private RadioButton memberMale;

	@FXML
	private RadioButton memberFemale;

	@FXML
	private TableView<MemberEntity> memberTable;

	@FXML
	private VBox adVbViewDoctor;

	@FXML
	private TextField doctorName;

	@FXML
	private TableView<MemberEntity> doctorTable;

	@FXML
	private VBox adVbViewReceptionist;

	@FXML
	private TextField receptionistName;

	@FXML
	private VBox adVbViewPatient;

	@FXML
	private TextField patientName;

	@FXML
	private TableView<MemberEntity> patientTable;

	@FXML
	private VBox adChangePassword;

	@FXML
	private PasswordField oldPassword;

	@FXML
	private PasswordField newPassword;

	@FXML
	private PasswordField confirmPassword;

	private MemberEntity member;

	@FXML
	void EditMenu() {
		addMember.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				adVbAddDoctor.visibleProperty().set(true);
				adVbViewDoctor.visibleProperty().set(false);
				adVbViewPatient.visibleProperty().set(false);
				adVbViewReceptionist.visibleProperty().set(false);
				adChangePassword.visibleProperty().set(false);
			}
		});

		changePassword.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				adVbAddDoctor.visibleProperty().set(false);
				adVbViewDoctor.visibleProperty().set(false);
				adVbViewPatient.visibleProperty().set(false);
				adVbViewReceptionist.visibleProperty().set(false);
				adChangePassword.visibleProperty().set(true);
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
					admin.getScene().getWindow().hide();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@FXML
	void ViewMenu(ActionEvent event) {
		viewDoctor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				adVbAddDoctor.visibleProperty().set(false);
				adVbViewDoctor.visibleProperty().set(true);
				adVbViewPatient.visibleProperty().set(false);
				adVbViewReceptionist.visibleProperty().set(false);
				adChangePassword.visibleProperty().set(false);
			}
		});

		viewPatient.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				adVbAddDoctor.visibleProperty().set(false);
				adVbViewDoctor.visibleProperty().set(false);
				adVbViewPatient.visibleProperty().set(true);
				adVbViewReceptionist.visibleProperty().set(false);
				adChangePassword.visibleProperty().set(false);
			}
		});

		viewReception.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				adVbAddDoctor.visibleProperty().set(false);
				adVbViewDoctor.visibleProperty().set(false);
				adVbViewPatient.visibleProperty().set(false);
				adVbViewReceptionist.visibleProperty().set(true);
				adChangePassword.visibleProperty().set(false);
			}
		});
	}

	@FXML
	void findDoctor(ActionEvent event) {

	}

	@FXML
	void findPatient(ActionEvent event) {

	}

	@FXML
	void findReceptionist(ActionEvent event) {

	}

	@FXML
	void updatePassword(ActionEvent event) {

	}

	@FXML
	void clear(ActionEvent event) {

	}

	@FXML
	void createMember(ActionEvent event) {
		member = new MemberEntity();
		//member.setId(Integer.parseInt(memberId.getText()));
		member.setName(memberName.getText());
		member.setIdentityCard(idendityCard.getText());
		member.setDateOfBirth(dateOfBirth.getValue().toString());
		member.setAddress(memberAddress.getText());
		member.setPhoneNumber(memberPhone.getText());
		member.setEmail(memberEmail.getText());
		member.setPassword(memberPassword.getText());
		if (adminRbt.isSelected()) {
			member.setRole(Role.Admin);
		} else if (receptionistRbt.isSelected()) {
			member.setRole(Role.Receptionist);
		} else if (doctorRbt.isSelected()) {
			member.setRole(Role.Doctor);
		}
		if (memberMale.isSelected()){
			member.setGender("Male");
		}else if (memberFemale.isSelected()) {
			member.setGender("Female");
		}
		
		MemberModel model = new MemberModel();
		model.create(member);
		System.out.println("created success...");
	}
}