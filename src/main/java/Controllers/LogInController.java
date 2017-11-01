package Controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import DAO.LogInDAO;
import Model.ViewState;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LogInController {

	private ViewState viewState;
	@FXML
	private JFXTextField logInTextField;

	@FXML
	private JFXButton logInButton;

	@FXML
	private JFXPasswordField passwordTextField;

	public LogInController(ViewState viewState) {
		this.viewState = viewState;
	}


	@FXML
	void logInButtonClicked() throws IOException {
		LogInDAO logInDAO = new LogInDAO();
		if(logInDAO.checkIfLoginAndPasswordIsCorrect(logInTextField.getText(),passwordTextField.getText()))
		{
			viewState.showMainMenu();
		}
		else
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("There is no user with such login or password. Please check if you didn't make a TYPO");
			alert.setTitle("Wrong login/password");
			alert.show();
		}
	}

	@FXML
	public void initialize()
	{

		EventHandler<KeyEvent> enterPressedOnButtonEventHandler = (e) ->{
			if(e.getCode() == KeyCode.ENTER)
			{
				try {
					logInButtonClicked();
				} catch (IOException fatal) {
					fatal.printStackTrace();
				}
			}
		};
		
		logInButton.setOnKeyPressed(enterPressedOnButtonEventHandler);
	}
}
