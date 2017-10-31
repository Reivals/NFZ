package Controllers;
import java.time.LocalDate;

import DAO.PatientDAO;
import JavaFXFunctionality.ContentOfPatientTableView;
import Model.Gender;
import Model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//Singleton?
public class PatientTableViewController {
		
	
	    @FXML
	    private TableView<Patient> patientTableView;

	    @FXML
	    private TableColumn<Integer, Patient> idColumn;

	    @FXML
	    private TableColumn<String, Patient> nameColumn;

	    @FXML
	    private TableColumn<String, Patient> surnameColumn;

	    @FXML
	    private TableColumn<Gender, Patient> genderColumn;

	    @FXML
	    private TableColumn<LocalDate, Patient> dateOfBirthColumn;
	   
	    
	    public TableView<Patient> getTableView()
	    {
	    	return patientTableView;
	    }
	    public PatientTableViewController()
	    {
	    	
	    }
	    @FXML
	    public void initialize()
	    {
	    	PatientDAO patientDAO = new PatientDAO();
	    	idColumn.setCellValueFactory(new PropertyValueFactory<Integer, Patient>("id"));
	    	nameColumn.setCellValueFactory(new PropertyValueFactory<String, Patient>("name"));
	    	surnameColumn.setCellValueFactory(new PropertyValueFactory<String, Patient>("surname"));
	    	genderColumn.setCellValueFactory(new PropertyValueFactory<Gender, Patient>("gender"));
	    	dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<LocalDate, Patient>("dateOfBirth"));
	    	ContentOfPatientTableView.loadTableOfPatients();
	    	patientTableView.setItems(ContentOfPatientTableView.getObservableList());

	    }
	
}
