package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Patient;
import interfaces.IPatientDAO;

public class PatientDAO implements IPatientDAO{
		EntityManagerFactory managerFacotry = Persistence.createEntityManagerFactory("manager");
		EntityManager manager = managerFacotry.createEntityManager();
	@Override
	public List<Patient> findAll() {

		manager.getTransaction().begin();
		TypedQuery<Patient> query = manager.createQuery("SELECT p FROM Patient p",Patient.class);
		manager.getTransaction().commit();
		ArrayList<Patient> result = (ArrayList<Patient>) query.getResultList();
		return result;
	}

	@Override
	public Patient findById(int id) {
		manager.getTransaction().begin();
		TypedQuery<Patient> query = manager.createNamedQuery("SELECT p FROM Patient WHERE p.id=:id",Patient.class).setParameter("id",id);
		manager.getTransaction().commit();
		return query.getSingleResult();
	}

	@Override
	public List<Patient> findByName(String name) {
		manager.getTransaction().begin();
		TypedQuery<Patient> query = manager.createNamedQuery("SELECT p FROM Patient WHERE p.name=:name",Patient.class).setParameter("name",name);
		manager.getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public void insertPatient(Patient patient) {
		manager.getTransaction().begin();
		manager.persist(patient);
		manager.getTransaction().commit();
	}

	@Override
	public void updatePatient(Patient patient) {
		manager.getTransaction().begin();
		manager.merge(patient);
		manager.getTransaction().commit();
	}

	@Override
	public void deletePatient(Patient patient) {
		manager.getTransaction().begin();
		manager.remove(manager.contains(patient) ? patient : manager.merge(patient));
		manager.getTransaction().commit();
	}

	@Override
	public List<Patient> findBySurname(String surname) {
		manager.getTransaction().begin();
		TypedQuery<Patient> query = manager.createNamedQuery("SELECT p FROM Patient WHERE p.surname=:surname",Patient.class).setParameter("surname",surname);
		manager.getTransaction().commit();
		return query.getResultList();
	}

}
