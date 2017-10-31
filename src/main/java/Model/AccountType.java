package Model;

public enum AccountType {
	
	DOCTOR{
		@Override
		public String toString()
		{
			return "Doctor";
		}
		
	},
	NURSE{
		@Override
		public String toString()
		{
			return "Nurse";
		}
		
	},
	ADMINISTRATOR{
		@Override
		public String toString()
		{
			return "Administrator";
		}
		
	},
	IT{
		@Override
		public String toString()
		{
			return "IT";
		}
		
	}

}
