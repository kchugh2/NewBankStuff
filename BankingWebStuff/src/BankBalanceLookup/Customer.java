package BankBalanceLookup;

public class Customer {
	private String custID, custName, custJob;
	private double custBalance;

	public double getCustBalance() {
		return custBalance;
	}

	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustJob() {
		return custJob;
	}

	public void setCustJob(String custJob) {
		this.custJob = custJob;
	}

	public Customer(String a, String b, String c, double d) {
		setCustID(a);
		setCustName(b);
		setCustJob(c);
		setCustBalance(d);

	}
}
