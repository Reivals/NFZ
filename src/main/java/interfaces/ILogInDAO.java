package interfaces;

import Model.Account;

public interface ILogInDAO {
	
	boolean checkIfLoginAndPasswordIsCorrect(String login,String password);

}
