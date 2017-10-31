package Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Patient {

	private IntegerProperty id = new SimpleIntegerProperty();
	@Column(name="Name")
	private StringProperty name = new SimpleStringProperty();
	@Column(name="Surname")
	private StringProperty surname = new SimpleStringProperty();
	@Column(name="Gender")
	@Enumerated(EnumType.STRING)
	private ObjectProperty<Gender> gender = new SimpleObjectProperty<Gender>();
	@Column(name="Date_of_birth")
	private ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<LocalDate>();
	public Patient()
	{
		
	}
	public Patient(String name,String surname, Gender gender,LocalDate dateOfBirth)
	{
		this.name.setValue(name);
		this.surname.setValue(surname);
		this.gender .setValue(gender);
		this.dateOfBirth.setValue(dateOfBirth);
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id.getValue();
	}
	public void setId(int id) {
		this.id.setValue(id);
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
	public Gender getGender() {
		return gender.getValue();
	}
	public void setGender(Gender gender) {
		this.gender.setValue(gender);
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth.getValue();
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth.setValue(dateOfBirth);
	}
	
	

}
