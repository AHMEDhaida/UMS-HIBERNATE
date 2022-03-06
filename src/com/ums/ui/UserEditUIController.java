package com.ums.ui;

import com.ums.model.Role;
import com.ums.model.User;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserEditUIController {
	@FXML
	private TextField nomField;
	@FXML
	private TextField prenomField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField telephoneField;
	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ComboBox<String> roleComboBox;
	private Stage dialogStage;
	private User user;
	private boolean validerClicked;

	@FXML
	private void initialize() {
		roleComboBox.getItems().clear();
		roleComboBox.getItems().addAll(Role.ADMINISTRATEUR.getValue(), Role.SIMPLE_USER.getValue());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setUser(User user) {
		this.user = user;
		nomField.setText(user.getNom());
		prenomField.setText(user.getPrenom());
		emailField.setText(user.getEmail());
		telephoneField.setText(user.getTelephone());
		loginField.setText(user.getLogin());
		passwordField.setText(user.getPassword());
		roleComboBox.getSelectionModel().select(user.getRole());
	}

	// Called when the user clicks Valider.
	@FXML
	private void handleValider() {
		if (isInputValid()) {
			user.setNom(nomField.getText());
			user.setPrenom(prenomField.getText());
			user.setEmail(emailField.getText());
			user.setTelephone(telephoneField.getText());
			user.setLogin(loginField.getText());
			user.setPassword(passwordField.getText());
			user.setRole(roleComboBox.getSelectionModel().getSelectedItem());

			validerClicked = true;
			dialogStage.close();
		}
	}

	

	// Validates the user input in the text fields.
	private boolean isInputValid() {
		String errorMessage = "";
		if (nomField.getText() == null || nomField.getText().length() == 0) {
			errorMessage += "Le Nom n'est pas renseigné !\n";
		}
		
		// Compléter les contrôles des autres champs ...
		
		if (prenomField.getText() == null || prenomField.getText().length() == 0) {
			errorMessage += "Le Prenom n'est pas renseigné !\n";
		}
		
		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "Le Email n'est pas renseigné !\n";
		}
		
		if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
			errorMessage += "Le Telephone n'est pas renseigné !\n";
		}
		
		if (loginField.getText() == null || loginField.getText().length() == 0) {
			errorMessage += "Le Togin n'est pas renseigné !\n";
		}
		
		
		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
			errorMessage += "Le Password n'est pas renseigné !\n";
		}
		
		if (errorMessage.length() == 0)
			return true;
		else { // Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs non renseignés et/ou invalides !");
			alert.setHeaderText("Veuillez remplir tous les champs svp !");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}

	// Called when the user clicks Annuler.
	@FXML
	private void handleAnnuler() {
		validerClicked = false;
		dialogStage.close();
	}

	public boolean isValiderClicked() {
		return validerClicked;
	}
}
