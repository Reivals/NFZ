package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Account;
import Model.LoggedAccount;
import interfaces.ILogInDAO;

public class LogInDAO implements ILogInDAO{

	@Override
	public boolean checkIfLoginAndPasswordIsCorrect(String login, String password) {
		System.out.println(login + " , " + password);
		Account account = null;
		EntityManagerFactory managerFacotry = Persistence.createEntityManagerFactory("manager");
		EntityManager manager = managerFacotry.createEntityManager();
		manager.getTransaction().begin();
		Query query =  manager.createQuery("SELECT a from Account a WHERE a.login = :login AND a.password = :password")
				.setParameter("login", login).setParameter("password", password);
		manager.getTransaction().commit();
		try {
			 account = (Account) query.getSingleResult();
		}
		catch(NoResultException lackOfResult){	
			return false;
		}
		if(account != null)
		{
			LoggedAccount.setAccount(account);
			return true;
		}
		return false;
	}

}
