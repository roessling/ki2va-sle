
public abstract class AbstractClass {
	public void templateMethod() {
		//...
		subOperation1();
		//...
		subOperation2();
		//...
	}
	public abstract void subOperation1();
	public abstract void subOperation2();
}

public class ConcreteClass extends AbstractClass {
	public void subOperation1() {
		//concrete implementation
	}
	public void subOperation2() {
		//concrete implementation
	}
}


public abstract class SalaryAccounting {
	public double calculateMonthlyWage(String workerID) {
		double payout = retrieveHours(workerID) * retrieveHourlyWage(workerID);
		notifyCostLocation(workerID, payout);
		return payout;
	}
	public abstract double retrieveHours(String workerID);
	public abstract double retrieveHourlyWage(String workerID);
	public abstract void notifyCostLocation(String workerID);
}

public class ShiftOperationContract extends SalaryAccounting {
	static double wagePerHour = 10;
	public double retrieveHours(String workerID) {
		return retrieveMonthlyHoursFromDB(workerID); //pseudo method call
	}

	public double retrieveHourlyWage(String workerID) {
		return wagePerHour;
	}

	public void notifyCostLocation(String workerID, double payout) {
		System.out.println("Worker " + workerID + " was paid "
			+ payout + " this month.");
		//department specific steps...
	}
}

public class LumpSumContract extends SalaryAccounting {
	public double retrieveHours(String workerID) {
		return retrieveMonthlyHoursFromContract(workerID);
	}

	public double retrieveHourlyWage(String workerID) {
		return retrieveWageFromContract(workerID);
	}

	public void notifyCostLocation(String workerID, double payout) {
		System.out.println("Worker " + workerID + " was paid "
			+ payout + " this month.");
		//department specific steps...
	}
}

public class ManagementContract extends {
	//....
}

