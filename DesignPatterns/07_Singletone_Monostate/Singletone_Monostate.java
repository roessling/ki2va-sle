//general
public class Singleton{

	private static Singleton uniqueInstance;
	//Other private fields ...

	private Singleton(){
	}

	public static Singleton instance(){
		return uniqueInstance == null ? new Singleton() : uniqueInstance; 
	}
	//Other static methods ...
}

public class Monostate{

	private static Object field1;
	//Other static fields
	private int foo(){
		//...
	}
	//Other non-static methods
}

//solution for task

//Singleton example
public class LoggedInUser {
	//Field for Singleton
	private static LoggedInUser user;
	//Example fields
	private String uuid;
	private Date last_login;
	private String token;
	//Constructor
	private LoggedInUser(){
		//...
	}
	public static LoggedInUser instance(){
		return user == null ? new LoggedInUser() : user;
	}
	public void login(String uuid, String passwort){
		//...
	}
}

//Monostate example
public class LoggedInUser {
	private static String uuid;
	private static Date last_login;
	private static String token;
	public LoggedInUser(){
		//...
	}
	public void login(String uuid, String passwort){
		//...
	}
}
