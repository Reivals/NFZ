package Controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import JavaFXFunctionality.ContentOfPatientTableView;
import Model.ViewState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
	
		private final ViewState viewState ;

		public MainMenuController(ViewState viewState) {
			this.viewState = viewState ;
		}

		@FXML
		void internalMedicineButtonClicked(ActionEvent event) throws IOException {
			viewState.showListOfPatientsMainMedicineView();
		}
		
		MainMenuController mainMenuController;
	 	@FXML
	    private JFXButton internalMedicineButton;

	    @FXML
	    private JFXButton cardiologyButton;

	    @FXML
	    private JFXButton NeurologyButton;

	    @FXML
	    private JFXButton phisiotherpathyButton;

	    @FXML
	    private JFXButton databaseOfDoctorsButton;

	    @FXML
	    private JFXButton databaseOfPatientsButton;
	    

	    @FXML
	    void NeurologyButtonClicked(ActionEvent event) {

	    }

	    @FXML
	    void cardiologyButtonClicked(ActionEvent event) {

	    }

	    @FXML
	    void databaseOfDoctorsButtonClicked(ActionEvent event) {

	    }

	    @FXML
	    void databaseOfPatientsButtonClicked(ActionEvent event) {

	    }

/*	    @FXML
	    void internalMedicineButtonClicked(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ListOfPatientsInternalMedicineView.fxml"));
	    	Button button = (Button) event.getSource();
	    	Scene scene = button.getScene();
	    	Stage stage = (Stage) scene.getWindow();
	    	loader.setController(new ListOfPatientsInternalMedicineController(patientTableViewModel,mainMenuController));
	    	stage.setScene(new Scene(loader.load()));

	    }*/

	    @FXML
	    void phisiotherpathyButtonClicked(ActionEvent event) {

	    }

		public JFXButton getReferenceButton()
		{
			return internalMedicineButton;
		}
		@FXML
		public void initialize()
		{

		}
		

}
