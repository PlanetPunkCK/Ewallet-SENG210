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
 * -write expense and income saveing 
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



private String lineBuilder(User buildData, int index){
//todo: 
//-enable functionality to allow for cvs to have blank spots where no values exist 
// such as in the case of more user has more expenses than incomes or vice versa
String returnable;
String blankline = ",,,";



if (index > buildData.Spending.size()){ //if index is larger than size of spending, ommit spending from returned string
    Income incIemp = buildData.incomes.get(index);
   

    returnable = incIemp.source + ","
                +incIemp.amount + ","
                +incIemp.Month + 
                blankline;

}else if(index > buildData.incomes.size()){ //if index is larger than size ofo incomes, omit incomes from returned string
    
    Expense exTemp = buildData.Spending.get(index);

    returnable = blankline
                +exTemp.amount + "," 
                +exTemp.source + ","
                +exTemp.yearlyfrequency;

}else{//else, it must be within range and all can be returned in formatted return string
    Income incIemp = buildData.incomes.get(index);
    Expense exTemp = buildData.Spending.get(index);

    returnable = incIemp.source + ","
                +incIemp.amount + ","
                +incIemp.Month + ","
                +exTemp.amount + "," 
                +exTemp.source + ","
                +exTemp.yearlyfrequency;
}


return returnable;
};


public boolean makeReport(User writeData, String filename){
    
    boolean success = false;
    int repeats;
    

    
    //automatically add header
    lines.add(headers);

    //determine how many rows will be in final report by the size of the larger of the incomes or spending lists
    if (writeData.incomes.size()> writeData.Spending.size()){
        repeats = writeData.Spending.size();
    }else{
        repeats = writeData.incomes.size();
    }

    //build lines with lineBuilder 
    for (int j = 0; j < repeats; j++){
        lines.add(lineBuilder(writeData, j));
    }

    //meat and potatoes, using printwriter to print lines built above to a file with header of .csv
    try {
        PrintWriter output = new PrintWriter(filename + ".csv");
        

        output.println(headers);
        for(int i = 0; i<repeats;i++){
        output.println(lines.get(i));
        }
        output.close();
        success = true;//should have output csv properly if you get here, success 
    }
    catch(Exception e) {
        e.getStackTrace();
        success = false;//if you're here, something's wrong
    }
    return success;
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
            writer.println("Number of source " + srcIn + ": " + );
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
