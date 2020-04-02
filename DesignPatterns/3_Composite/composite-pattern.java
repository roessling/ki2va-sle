
//general
public abstract class Component {
  public abstract void operation();
  public abstract void add(Component o);
  public abstract void remove(Component o);
  public abstract Component get(int i);
}

public class Leaf extends Component {
  public void operation() {
    //implementation...
  }
  public void add(Component o) {
    throw new UnsupportedOperationException();
  }
  public void remove(Component o) {
    throw new UnsupportedOperationException();
  }
  public Component get(int i) {
    throw new UnsupportedOperationException();
  }
}

public class Composite extends Component {
  private List<Component> children;
  public void operation() {
    for (Component c : children) {
      c.operation();
    }
  }
  public void add(Component o) {
    children.add(o);
  }
  public void remove(Component o) {
    children.remove(o);
  }
  public Component get(int i) {
    return children.get(i);
  }
}


//solution for task
public abstract class Employee {
  private String name;
  private String email;
  public void print() {
    System.out.println(name + " (contact: " + email + ")");
  }
  public abstract void grantPermission(String permission);
  public abstract void removePermission(String permission);
  public abstract void add(Employee o);
  public abstract void remove(Employee o);
  public abstract Employee get(int i);
}

public class SimpleEmployee extends Employee {
  private List<String> permissions;
  public void grantPermission(String permission) {
    permissions.add(permission);
  }
  public void removePermission(String permission) {
    permissions.remove(permission);
  }
  public void add(Employee e) {
    throw new NotSupportedException();
  }
  public void remove(Employee e) {
    throw new NotSupportedException();
  }
  public Employee get(int i) {
    throw new NotSupportedException();
  }
}

public class Manager extends Employee {
  private List<Employee> employees;
  private String department;
  public void print() {
    for (Employee e : employees) {
      e.print();
    }
    print();
  }
  public void grantPermission(String permission) {
    for (Employee e : employees) {
      e.grantPermission(permission);
    }
  }
  public void removePermission(String permission) {
    for (Employee e : employees) {
      e.removePermission(permission);
    }
  }
  public void add(Employee e) {
    employees.add(e);
  }
  public void remove(Employee e) {
    employees.remove(e);
  }
  public Employee get(int i) {
    return employees.get(i);
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
}

