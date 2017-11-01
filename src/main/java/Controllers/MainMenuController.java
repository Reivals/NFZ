package Controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import Model.ViewState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainMenuController {
	
		private final ViewState viewState ;

		public MainMenuController(ViewState viewState) {
			this.viewState = viewState ;
		}


		
		MainMenuController mainMenuController;
	 	@FXML
	    private JFXButton internalMedicineButton;

	    @FXML
	    private JFXButton cardiologyButton;

	    @FXML
	    private JFXButton neurologyButton;

	    @FXML
	    private JFXButton phisiotherpathyButton;

	    @FXML
	    private JFXButton listOfDoctorsButton;

	    @FXML
	    private JFXButton listOfPatientsButton;
	    
		@FXML
		void internalMedicineButtonClicked() throws IOException {
			
		}
	    

	    @FXML
	    void neurologyButtonClicked() throws IOException{

	    }

	    @FXML
	    void cardiologyButtonClicked() throws IOException{

	    }

	    @FXML
	    void listOfDoctorsButtonClicked() throws IOException{

	    }

	    @FXML
	    void listOfPatientsButtonClicked() throws IOException{
	    	viewState.showListOfPatientsMainMedicineView();
	    }

	    @FXML
	    void phisiotherpathyButtonClicked() throws IOException{

	    }

		public JFXButton getReferenceButton()
		{
			return internalMedicineButton;
		}
		@FXML
		public void initialize()
		{
			EventHandler<KeyEvent> keyEventHandlerENTERForAnyButtonInMainMenu = e ->
			{
				if(e.getCode() == KeyCode.ENTER && e.getSource() == internalMedicineButton )
				{
					try {
						internalMedicineButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
				else if(e.getCode() == KeyCode.ENTER && e.getSource() == cardiologyButton )
				{
					try {
						cardiologyButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
				else if(e.getCode() == KeyCode.ENTER && e.getSource() == neurologyButton )
				{
					try {
						neurologyButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
				else if(e.getCode() == KeyCode.ENTER && e.getSource() == phisiotherpathyButton )
				{
					try {
						phisiotherpathyButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
				else if(e.getCode() == KeyCode.ENTER && e.getSource() == listOfDoctorsButton )
				{
					try {
						listOfDoctorsButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
				else if(e.getCode() == KeyCode.ENTER && e.getSource() == listOfPatientsButton )
				{
					try {
						listOfPatientsButtonClicked();
					} catch (IOException fatal) {
						fatal.printStackTrace();
					}
				}
					
			};
			internalMedicineButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
			cardiologyButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
			neurologyButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
			phisiotherpathyButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
			listOfDoctorsButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
			listOfPatientsButton.setOnKeyPressed(keyEventHandlerENTERForAnyButtonInMainMenu);
		}
		

}
