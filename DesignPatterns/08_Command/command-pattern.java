//general
public class Invoker() {
  private List<Command> cmds;
  //implementation of the invoker
  //...
}

interface Command {
	public abstract void execute();
}

public class ConcreteCommand implements Command {
	private State state;
	private Receiver receiver;

	public void execute() {
		//...
		receiver.action();
		//...
	}

  public void setReceiver(Receiver r) {
    this.receiver = r;
  }
}

public class Receiver {
	public void action() {
		//perform some action
	}
}

public class Client {
  public static void main(String[] args) {
    ConcreteCommand cmd = new ConcreteCommand();
    cmd.setReceiver(new Receiver());
    //...
  }
}

//solution
public class HireButton extends Button {
  private HireCommand cmd;
  public HireButton(HireCommand _cmd) {
    this.cmd = _cmd;
  }
  public void onClick(View v) {
    cmd.execute(v.getEmployeeInformation());
  }
}
/*
similar for FireButton, RequestVacationButton,
ChangeSalaryButton, EditEmployeeButton, PromoteButton
*/

interface Command {
  public abstract void execute(Employee e);
}

public class HireCommand implements Command { 
  private Employee employee;
  private Database db;
  public void execute(Employee e) {
    employee = e;
    db.addEmployee(employee);
  }
  public void setDb(Database _db) {
    this.db = _db
  }
}
/*
similar for FireCommand, RequestVacationCommand,
ChangeSalaryCommand, EditEmployeeCommand, PromoteCommand
*/

public class Database {
  public void addEmployee(Employee e) {
    //add new employee
  }
  public void fireEmployee(Employee e, String reason) {
    //fire an employee and possible notify affected departments
  }
  public void addVacationRequest(Employee e, Date begin, Date end) {
    //request vacation for employee and request approval of supervisor
  }
  public void updateSalary(Employee e, double salary) {
    //update salary for given employee
  }
  public void editEmployee(Employee e, String field, String newValue) {
    //edit fields like address of an employee
  }
  public promoteEmployee(Employee e, Position p) {
    //promote employee to higher position
  }
}

public class Application {
  public static void main(String[] args) {
    private Database db = new Database();
    private HireCommand hireCmd = new HireCommand()
    hireCmd.setDb(db);
    private HireButton hireBtn = new HireButton(hireCmd);
    //similar for all other commands and buttons
    //...
  }
}
