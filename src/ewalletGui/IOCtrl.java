package ewalletGui;
import java.io.*;
import java.util.ArrayList;

/*
 * TODO:
 * /d for done
 * /i for in progress
 * /a for aborted
 * -Write all data in given User /i
 *      -ARGUMENTS:
 *          -current user as User object/d
 *      -RETURNS:
 *          -success in writing as Boolean
 *              -true for success and vice versa
 *      -PRODUCES:
 *          -CSV file with userName + "Data.csv"
 * 
 *      -write line by line
 *          -Lines "built" and stored in array list by lineBuilder method
 *      -write string configured to write local to project with userName + "Data.csv"
 * 
 * -Write Line builder
 *      -will write no values to empty spaces (EG: ",,,src,amnt,freq")
 *      -stores Built line in ArrayList "lines" of type String 
 *      -RETURNS: lines 
 * 
 * -write expense and income saving 
 * 
 * 
 * -Write filter method for income and expense reports
 *      -accepts following arguments for filter- income
 *          -Src as string
 *          -amnt as double
 *          -Mnth as String
 *      -accepts following arguments for filter- expenses
 *          -src as string
 *          -amnt as Double
 *          -freq as int
 * 
 *      -returns temporary User object 
 *      
 */





public class IOCtrl {
    
//save all data to csvchad
String headers = "src,amnt,mnth,src,amnt,freq";
String Filepath ;
ArrayList<String> lines;
User tempUser;

public IOCtrl(){
    lines = new ArrayList<String>();
    tempUser = new User();
}





public boolean makeReport(User uIn, String filename){
    

    int incomeLen = uIn.incomes.size();
    int expenseLen = uIn.Spending.size();
    int longer;
    int shorter;
    Expense tmpExpense;
    Income tmpIncome;

   

    if (incomeLen > expenseLen){
        longer = incomeLen;
        shorter = expenseLen;
    }else if (expenseLen > incomeLen){
        longer = expenseLen;
        shorter = incomeLen;
    }else{
        shorter = expenseLen;
        longer = expenseLen;
    }


	try (PrintWriter writer = new PrintWriter(new FileWriter(filename +".csv"))) {
        
        writer.println(this.headers);
        
            for (int i = 0; i< longer; i++){

                if (i < shorter){
                    tmpIncome = uIn.incomes.get(i);
                    tmpExpense = uIn.Spending.get(i);
                    writer.println(tmpIncome.source + "," + tmpIncome.amount + "," + tmpIncome.Month + "," 
                                + tmpExpense.source + "," + tmpExpense.amount + "," + tmpExpense.yearlyfrequency);
                }else if (i > expenseLen && i < longer){
                    tmpIncome = uIn.incomes.get(i);
                 writer.println(tmpIncome.source + "," + tmpIncome.amount + "," + tmpIncome.Month + "," 
                                +  ","  + "," );
          
                }else if (i > incomeLen && i < longer){
                    tmpExpense = uIn.Spending.get(i);
                     writer.println("," + "," + "," 
                                + tmpExpense.source + "," + tmpExpense.amount + "," + tmpExpense.yearlyfrequency);
          

              }else{
                    writer.close();
                    return true;
             }
    
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
   
return true;
/*
 * goal: incomes and expenses written to csv with longer list
 *         outputting next to empty field values
 * 
 * index control vars:
 * get size of both lists
 * store into vars longer and shorter respectively
 * 
 * 
 * procedure
 * write headers
 * get size of both lists
 * store into vars longer and shorter respectively
 * 
 * 
 * possible write states and conditions for existance:
 *      -both lists
 *          -index is less than shortest var
 *      -income list write and right columns blank
            -index is more than incomelist size but less than longest list
 *      -left columns blank and expense list blank
 *          -index is less than expenselist size but less than longest list
 *      -finished
 *          -index has reached max value and writing ends, return true
 * 
 */
   
}


public static boolean writeObjectsToFile(User uIn) { //returns void, writes information from given user
    boolean a = false;
    boolean b = false;
	try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"Incomes.txt"))) {
        for (Income obj : uIn.incomes) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + "," + obj.amount + "," + obj.Month);
        }
        a = true;
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"Expenses.txt"))) {
        for (Expense obj : uIn.Spending) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + "," + obj.amount + "," + obj.yearlyfrequency);
        }
        b = true;
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    if(a && b) {
        return true;
    }else {
    	return false;
    }
} 


public static boolean writeIncomesToReport(User uIn) { //returns boolean, writes information from given user to report with a few stats and all incomes in a comma seperated list


    try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"Incomes.txt"))) {

            writer.println("Income report for: "  + uIn.getUsername());
            writer.println("# of incomes: " + uIn.incomes.size());
            

            double num = 0;
        for (Income tmp : uIn.incomes){
            num += tmp.amount;
        } 
            writer.println("total amount in balance: $"+ num);
            writer.println("_____individual expenses_____");
            writer.println("Sources,  Amounts,  Month");
        for (Income obj : uIn.incomes) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + ", " + obj.amount + ", " + obj.Month);
        }
        
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return true;
}


public static boolean writeExpensesToReport(User uIn){
    
    
    try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"Incomes.txt"))) {

            writer.println("Income report for: "  + uIn.getUsername());
            writer.println("# of Expenses: " + uIn.incomes.size());
            

            double num = 0;
        for (Expense tmp : uIn.Spending){
            num += tmp.amount;
        } 
            writer.println("total amount in balance: $"+ num);
            writer.println("_____individual expenses_____");
            writer.println("Sources,  Amounts,  YearlyFrequency");
        for (Expense obj : uIn.Spending) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + ", " + obj.amount + ", " + obj.yearlyfrequency);
        }
        
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return true;
}


public static boolean makeIncomeReportOfSrc(User uIn, String srcIn){ //returns boolean, use for filtered output mathing string srcIn
    
    User uNew = uIn;
    uNew.incomes.clear();


    for (Income tmp : uIn.incomes){
            if(tmp.source == srcIn){
                uNew.incomes.add(tmp);
            }
        } 

    try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"filteredIncomes.txt"))) {

            writer.println("Income report for: "  + uIn.getUsername());
            writer.println("# of incomes of type "+ srcIn+": " + uNew.incomes.size());
            

            double num = 0;
        for (Income tmp : uNew.incomes){
            num += tmp.amount;
        } 
            writer.println("total amount in balance: $"+ num);
            writer.println("_____individual Incomes_____");
            writer.println("Sources,  Amounts,  Month");
        for (Income obj : uIn.incomes) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + ", " + obj.amount + ", " + obj.Month);
        }
        
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    

    return true;

}


public static boolean makeExpenseReportOfSrc(User uIn, String srcIn){

    User uNew = uIn;
    uNew.Spending.clear();


    for (Expense tmp : uIn.Spending){
            if(tmp.source == srcIn){
                uNew.Spending.add(tmp);
            }
        } 

    try (PrintWriter writer = new PrintWriter(new FileWriter(uIn.getUsername() +"filteredIncomes.txt"))) {

            writer.println("Spending report for: "  + uIn.getUsername());
            writer.println("# of incomes: " + uNew.Spending.size());
            

            double num = 0;
        for (Expense tmp : uNew.Spending){
            num += tmp.amount;
        } 
            writer.println("total amount in balance: $"+ num);
            writer.println("Number of source " + srcIn + ": " + uNew.Spending.size());
            writer.println("_____Individual Expenses_____");
            writer.println("Sources,  Amounts,  Month");
        for (Expense obj : uIn.Spending) {
            // Assuming the object has three attributes: attr1, attr2, attr3
            writer.println(obj.source + ", " + obj.amount + ", " + obj.yearlyfrequency);
        }
        
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    

    return true;
}



public static  User readObjectsFromFile(String Username, User uIn) { //returns an object of type user, loads information from files for specified user
    ArrayList<Expense> expenseList = new ArrayList<>();
    ArrayList<Income> incomeList = new ArrayList<>();
    User returnable = new User();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(Username + "Expenses.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
            if (attributes.length == 3) {
                Expense obj = new Expense("default", 0, 0);
                obj.source = attributes[0];
                obj.amount = Double.parseDouble(attributes[1]);
                obj.yearlyfrequency = Integer.parseInt(attributes[2]);
                expenseList.add(obj);
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(Username + "Incomes.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
            if (attributes.length == 3) {
                Income obj = new Income();
                obj.source = attributes[0];
                obj.amount = Double.parseDouble(attributes[1]);
                obj.Month = attributes[2];
                incomeList.add(obj);
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    returnable.incomes.addAll(incomeList);
    returnable.Spending.addAll(expenseList);
    
    
    return returnable;
}


}
