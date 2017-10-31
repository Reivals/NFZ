package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
@Entity
public class Doctor {

	@Column(name = "System_id")
	private IntegerProperty system_id = new SimpleIntegerProperty();
	@Column(name = "Name")
	private StringProperty name = new SimpleStringProperty();
	@Column(name = "Surame")
	private StringProperty surname = new SimpleStringProperty();
	@Column(name = "Licence_Number")
	private IntegerProperty licence_number= new SimpleIntegerProperty();
	
	public Doctor(int system_id, String name, String surname, int licence_number) {
		this.system_id.setValue(system_id);
		this.name.setValue(name);
		this.surname.setValue(surname);
		this.licence_number.setValue(licence_number);
	}
	public Doctor()
	{
		
	}
	@Id
	@GeneratedValue
	public int getSystem_id() {
		return system_id.getValue();
	}
	public void setSystem_id(int system_id) {
		this.system_id.setValue(system_id);
	}
	public String getName() {
		return name.getValue();
	}
	public void setName(String name) {
		this.name.setValue(name);
	}
	public String getSurname() {
		return surname.getValue();
	}
	public void setSurname(String surname) {
		this.surname.setValue(surname);
	}
	public int getLicence_number() {
		return licence_number.getValue();
	}
	public void setLicence_number(int licence_number) {
		this.licence_number.setValue(licence_number);
	}
	
	
}
