import java.util.ArrayList;

public class User {
	//private ArrayList <Currency>currencyRates;
	public ArrayList <Income>incomes;  // user income sources that user can record or view or search by type or month 
	public ArrayList <Expense>Spending; //user's expenses 
	String username;
	String pwd;
	//current total income - total 
	double balance;
	// possible monthly savings, calculated using monthly income (most recent) assuming the data we have is for one year, and monthly and biweekly expenses, here you can assume yearly expenses that are recorded have already been paid. 
	double monthlysavings;	
	//should add constructor(s)
	User(String uname,String password){
		incomes = new ArrayList<Income>();
		Spending = new ArrayList<Expense>();
		username = uname;
		pwd = password;

	}
	User(){
		incomes = new ArrayList<Income>();
		Spending = new ArrayList<Expense>();
		username = "unset";
		pwd = "unset";
	}
}
