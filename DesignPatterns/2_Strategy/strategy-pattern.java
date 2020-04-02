// general
interface Strategy<E> {
  public E algorithm(String arg0, ...);
}

public class ConcreteStrategyA<E> implements Strategy<E> {
  public E algorithm(String arg0, ...) {
    //concrete implementation A
  }
}

public class ConcreteStrategyB<E> implements Strategy<E> {
  public E algorithm(String arg0, ...) {
    //concrete implementation B
  }
}

public class ConcreteStrategyC<E> implements Strategy<E> {
  public E algorithm(String arg0, ...) {
    //concrete implementation C
  }
}

public class Context {
  Strategy<Integer> strategy;
  public Context() {
    strategy = new ConcreteStrategyB<Integer>();
  }
  public Integer foo(String arg0, ...) {
    return strategy.algorithm(arg0, ...)
  }
}


// solution for task
interface Sorter {
  public List<Employee> sort(List<Employee> list);
}

public class NameSorter implements Sorter {
  public List<Employee> sort(List<Employee> list) {
    return Collections.sort(list, (e1, e2) -> {
      return e1.getName().compareTo(e2.getName());
    });
  }
}

public class DepartmentSorter implements Sorter {
  public List<Employee> sort(List<Employee> list) {
    return Collections.sort(list, (e1, e2) -> {
      e1.getDepartment().toString().compareTo(e2.getDepartment().toString());
    });
  }
}

public class EmploymentDateSorter implements Sorter {
  public List<Employee> sort(List<Employee> list) {
    return Collections.sort(list, (e1, e2) -> {
      return e1.getEmploymentDate().compareTo(e2.getEmploymentDate());
    });
  }
}

public class SalarySorter implements Sorter {
  public List<Employee> sort(List<Employee> list) {
    return Collections.sort(list, (e1, e2) -> {
      return e1.getSalary() - e2.getSalary();
    });
  }
}

public class EmployeeOverview {
  private Sorter sorter;
  private List<Employee> employees;
  public EmployeeOverview(List<Employee> employees) {
    this.sorter = new NameSorter();
    this.employees = employees;
  }
  public void switch(String sortBy) {
    switch(sortBy) {
      case "name":
        sorter = new NameSorter();
        break;
      case "department":
        sorter = new DepartmentSorter();
        break;
      case "employmentDate":
        sorter = new EmploymentDate();
        break;
      case "salary":
        sorter = new SalarySorter();
        break;
    }
  }
  public void sort() {
    employees = sorter.sort(list);
  }
}


