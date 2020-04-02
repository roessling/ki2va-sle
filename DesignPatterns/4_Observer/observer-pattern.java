//general
public abstract class Subject {
  private List<Observer> observers = new ArrayList<Observer>();
  public void attach(Observer o) {
    observers.add(o);
  }
  public void detach(Observer o) {
    observers.remove(o);
  }
  public void notify() {
    for (Observer o : observers) {
      o.update(...);
    }
  }
}

public class ConcreteSubject extends Subject {
  private Object state;
  public Object getState() {
    return state;
  }
  public void modifyState() {
    //change state
    notify();
  }
}

interface Observer {
  public void update(...);
}

public class ConcreteObserver implements Observer {
  public void update(...) {
    //concrete implementation
  }
}


//solution for task
interface EmployeeObserver {
  public void update(List<Employee> update);
}

public class ListGUIObserver implements EmployeeObserver {
  public void update(List<Employee> update) {
    //update GUI, draw new list
  }
}

public class TilesGUIObserver implements EmployeeObserver {
  public void update(List<Employee> update) {
    //update GUI, draw new tiles
  }
}

public abstract class Subject {
  //see above
}

public class EmployeeDB extends Subject {
  private List<Employee> employees;
  public List<Employee> getState() {
    return employees;
  }
  public void sort() {
    //change order of employees
    employees.sort();
    notify(employees);
  }
  public void notify(List<Employee> update) {
    for (Observer o : observers) {
      //push mode
      o.update(update);
    }
  }
}

public class GUI {
  //....
  public static void main(String[] args) {
    EmployeeDB db = new EmployeeDB();
    db.attach(new ListGUIObserver());
    db.attach(new TilesGUIObserver());
    //...
    db.sort();
  }
  //...
}

