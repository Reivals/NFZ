package interfaces;

import java.util.List;

import Model.Patient;

public interface IPatientDAO {
    List<Patient> findAll();
    Patient findById(int id);
    List<Patient> findByName(String name);
    List<Patient> findBySurname(String surname);
    void insertPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);

}
