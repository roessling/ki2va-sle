//general
public abstract class Product {
  //general definition of a product
  public abstract void doSomething();
}

public class ConcreteProduct extends Product {
  //concrete implementation for products
  public void doSomething() {
    //concrete implementation for doSomething
  }
}

public abstract class Creator {
  public abstract Product factoryMethod();
  public void operation() {
    //do an operation
    factoryMethod();
    //....
  }
}

public class ConcreteCreator extends Creator {
  public ConcreteProduct factoryMethod() {
    //concrete implementation
  }
}

//solution for task
//products
public abstract class Room {
  private String roomID;
  public Room(String roomID) {
    this.roomID = roomID;
  }
  public abstract String getPersonInCharge();
}

public class ConferenceRoom extends Room {
  public String getPersonInCharge() {
    //pseudo method call
    return getRoomDB().getRoomData(roomID).getEmployees().getContactPerson();
  }
}

public class CleanRoom extends Room {
  public String getPersonInCharge() {
    //pseudo method call
    return getProductionScheduleDB().getRoomData(roomID).getPersonInCharge();
  }
}

public class StorageRoom extends Room {
  public String getPersonInCharge() {
    //pseudo method call
    return getRoomDB().getRoomData(roomID).getBuilding().getFacilityManager();
  }
}

//creators
public abstract class Building {
  private List<Room> rooms;
  public abstract Room createRoom();
  public Building() {
    rooms = new ArrayList<Room>;
    Room room1 = createRoom();
    Room room2 = createRoom();
    Room room3 = createRoom();
    rooms.add(room1);
    rooms.add(room2);
    rooms.add(room3);
  }
} 

public class FactoryBuidling {
  public Room createRoom() {
    return new FactoryBuidling();
  }
}

public class OfficeBuilding {
  public Room createRoom() {
    return new OfficeBuilding();
  }
}

public class StorageBuilding {
  public Room createRoom() {
    return new StorageBuilding();
  }
}