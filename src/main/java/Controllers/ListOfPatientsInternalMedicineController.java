package Controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import DAO.PatientDAO;
import JavaFXFunctionality.ContentOfPatientTableView;
import Model.Gender;
import Model.Patient;
import Model.ViewState;
import interfaces.IPatientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListOfPatientsInternalMedicineController {
	IPatientDAO patientDAO = new PatientDAO();
	private ViewState viewState;
	@FXML
	private PatientTableViewController patientTableViewController;


	@FXML
	private JFXTextField searchTextField;

	@FXML
	private Hyperlink deleteAllHyperText;

	@FXML
	private JFXButton goBacktoMainMenuButton;

	@FXML
	private JFXButton insertButton;

	@FXML
	private JFXButton deleteButton;

	@FXML
	private JFXButton updateButton;

	@FXML
	private JFXTextField nameTextField;

	@FXML
	private JFXTextField surnameTextField;

	@FXML
	private JFXDatePicker dateOfBirth_DatePicker;

	@FXML
	private ChoiceBox<Gender> genderChoiceBox;



	public ListOfPatientsInternalMedicineController(ViewState viewState) {
		this.viewState = viewState;
	}

	@FXML
	public void deleteAllHyperTextClicked(ActionEvent event)
	{
		nameTextField.clear();
		surnameTextField.clear();
		genderChoiceBox.setValue(null);
		dateOfBirth_DatePicker.setValue(null);
	}

	@FXML
	public void goBacktoMainMenuButtonClicked(ActionEvent event) throws IOException
	{
		viewState.showMainMenu();
	}

	@FXML
	public void searchTextFieldChangedText(ActionEvent event)
	{
		
	}


	@FXML
	void updateButtonClicked(ActionEvent event) {
		patientTableViewController.getTableView().getSelectionModel().getSelectedItem().setName(nameTextField.getText());
		patientTableViewController.getTableView().getSelectionModel().getSelectedItem().setSurname(surnameTextField.getText());
		patientTableViewController.getTableView().getSelectionModel().getSelectedItem().setGender(genderChoiceBox.getValue());
		patientTableViewController.getTableView().getSelectionModel().getSelectedItem().setDateOfBirth(dateOfBirth_DatePicker.getValue());
		patientTableViewController.getTableView().refresh();
		patientDAO.updatePatient(patientTableViewController.getTableView().getSelectionModel().getSelectedItem());
	}

	@FXML
	void deleteButtonClicked(ActionEvent event) {
		patientDAO.deletePatient(patientTableViewController.getTableView().getSelectionModel().getSelectedItem());
		viewState.getPatientTableViewModel().getObservableList().remove(patientTableViewController.getTableView().getSelectionModel().getSelectedItem());
		patientTableViewController.getTableView().refresh();


	}

	@FXML
	void insertButtonClicked(ActionEvent event) {

			Patient newPatient = new Patient(nameTextField.getText(),surnameTextField.getText(),genderChoiceBox.getValue(),dateOfBirth_DatePicker.getValue());
			viewState.getPatientTableViewModel().getObservableList().add(newPatient);
			patientDAO.insertPatient(newPatient);

	}


	@FXML
	public void initialize()
	{
		EventHandler<MouseEvent> itemSelectedEventHandler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				nameTextField.setText(patientTableViewController.getTableView().getSelectionModel().getSelectedItem().getName());
				surnameTextField.setText(patientTableViewController.getTableView().getSelectionModel().getSelectedItem().getSurname());
				dateOfBirth_DatePicker.setValue(patientTableViewController.getTableView().getSelectionModel().getSelectedItem().getDateOfBirth());
				genderChoiceBox.setValue(patientTableViewController.getTableView().getSelectionModel().getSelectedItem().getGender());
			}

		};
		ObservableList<Gender> observableGenderList = FXCollections.observableArrayList(Gender.MALE,Gender.FEMALE);
		genderChoiceBox.setItems(observableGenderList);
		patientTableViewController.getTableView().addEventHandler(MouseEvent.MOUSE_CLICKED,itemSelectedEventHandler);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(patientTableViewController.getTableView().getSelectionModel().getSelectedItem()==null)
			{
				deleteAllHyperTextClicked(null);
			}
			ObservableList temporaryList = FXCollections.observableArrayList();
			String pattern = searchTextField.getText();
			viewState.getPatientTableViewModel().getObservableList().stream().
			filter(e -> e.getSurname().startsWith(pattern)).collect(Collectors.toCollection(() -> temporaryList));
			patientTableViewController.getTableView().setItems(temporaryList);
			if(searchTextField.getText().isEmpty())
			{
				patientTableViewController.getTableView().setItems(viewState.getPatientTableViewModel().getObservableList());
			}
		});


	}

}
