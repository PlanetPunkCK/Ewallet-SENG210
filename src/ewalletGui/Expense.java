package ewalletGui;

public class Expense {
	String source;
	double amount;
	int yearlyfrequency; //1 for 1 time or once a year, 12 for monthly or or 24 for biweekly

	public Expense ( String src, double amnt, int frq){
		this.source = src;
		this.amount = amnt;
		this.yearlyfrequency = frq;
	}
}
