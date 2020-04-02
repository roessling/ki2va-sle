//general
interface AbstractProductA {
  //general definition of product A
}

public class ProductA1 implements AbstractProductA {
  //variant 1 for product A
}

public class ProductA2 implements AbstractProductA {
  //variant 2 for product A
}

interface AbstractProductB {
  //general definition of product B
}

public class ProductB1 implements AbstractProductB {
  //variant 1 for product B
}

public class ProductB2 implements AbstractProductB {
  //variant 2 for product B
}

interface AbstractFactory {
  public abstract AbstractProductA createProdA();
  public abstract AbstractProductB createProdB();
}

public class ConcreteFactory1 implements AbstractFactory {
  public AbstractProductA createProdA() {
    return new ProductA1();
  }
  public AbstractProductB createProdB() {
    return new ProductB1(); 
  }
}

public class ConcreteFactory2 implements AbstractFactory {
  public AbstractProductA createProdA() {
    return new ProductA2();
  }
  public AbstractProductB createProdB() {
    return new ProductB2(); 
  }
}

//solution for task
interface Button {
  //general definition of a button
}
public class DarkButton implements Button {
  //dark variant of the button
}
public class LightButton implements Button {
  //light variant of the button
}
interface MenuBar {
  //general definition of a menu bar
}
public class DarkMenuBar implements MenuBar {
  //dark variant of the menu bar
}
public class LightMenuBar implements MenuBar {
  //light variant of the menu bar
}
interface Background {
  //general definition of the background
}
public class DarkBackground implements Background {
  //dark variant of the button
}
public class LightBackground implements Background {
  //light variant of the button
}

interface ThemeFactory {
  public abstract Button createButton();
  public abstract MenuBar createMenuBar();
  public abstract Background createBackground();
}
public class LightTheme implements ThemeFactory {
  public Button createButton() {
    return new LightButton();
  }
  public MenuBar createMenuBar() {
   return new LightMenuBar(); 
  }
  public Background createBackground() {
    return new LightBackground();
  }
}
public class DarkTheme implements ThemeFactory {
  public Button createButton() {
    return new DarkButton();
  }
  public MenuBar createMenuBar() {
   return new DarkMenuBar(); 
  }
  public Background createBackground() {
    return new DarkBackground();
  }
}




