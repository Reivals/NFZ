package Model;
//SINGLETON
public class LoggedAccount {

	private static Account account;
	
	
	public static Account getAccount()
	{
		return account;
	}


	public static void setAccount(Account account2) {
		account = account2;
		
	}

	

}
