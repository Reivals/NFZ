package Model;


import java.io.IOException;
import java.io.UncheckedIOException;

import Controllers.ListOfPatientsInternalMedicineController;
import Controllers.LogInController;
import Controllers.MainMenuController;
import JavaFXFunctionality.ContentOfPatientTableView;
import JavaFXFunctionality.StageFunctionality;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ViewState {

	private final ContentOfPatientTableView patientTableViewModel ;

	private final ReadOnlyObjectWrapper<Parent> currentView = new ReadOnlyObjectWrapper<>();
	private Stage stage;
	private Parent logInView ;
	private Parent mainMenuView ;
	private Parent listOfPatientsMainMedicineView ;

	public ViewState(ContentOfPatientTableView patientTableViewModel, Stage stage) {
		this.patientTableViewModel = patientTableViewModel ;
		this.stage = stage;
	}

	public ReadOnlyObjectProperty<Parent> currentViewProperty() {
		return currentView.getReadOnlyProperty();
	}
	public ContentOfPatientTableView getPatientTableViewModel()
	{
		return patientTableViewModel;
	}

	public void showLogIn() {
		if (logInView == null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LogInView.fxml"));
				loader.setController(new LogInController(this));
				logInView = loader.load();
			} catch (IOException exc) {
				// fatal...
				throw new UncheckedIOException(exc);
			}
		}
		currentView.set(logInView);
		StageFunctionality.setStageProperties(stage);
	}

	public void showMainMenu() {
		if (mainMenuView == null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
				loader.setController(new MainMenuController(this));
				mainMenuView = loader.load();
			} catch (IOException exc) {
				// fatal...
				throw new UncheckedIOException(exc);
			}
		}
		currentView.set(mainMenuView);
		StageFunctionality.setStageProperties(stage);
	}

	public void showListOfPatientsMainMedicineView() {
		if(listOfPatientsMainMedicineView == null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ListOfPatientsInternalMedicineView.fxml"));
				loader.setController(new ListOfPatientsInternalMedicineController(this));
				listOfPatientsMainMedicineView=loader.load();
			} catch (IOException exc) {
				// fatal...
				throw new UncheckedIOException(exc);
			}
		}
		currentView.set(listOfPatientsMainMedicineView);
		StageFunctionality.setStageProperties(stage);

	}

}
