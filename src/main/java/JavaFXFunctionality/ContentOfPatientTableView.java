package JavaFXFunctionality;

import DAO.PatientDAO;
import Model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContentOfPatientTableView {
	
	public static ObservableList<Patient> observableList = FXCollections.observableArrayList();
	

	public static ObservableList<Patient> getObservableList() {
		return observableList;
	}
	
	public static void loadTableOfPatients()
	{
		PatientDAO dao = new PatientDAO();
		observableList.addAll(dao.findAll());
	}

	
}
