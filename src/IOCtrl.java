import java.io.*;
import java.util.ArrayList;

/*
 * TODO:
 * -Write all data in given User 
 *      -ARGUMENTS:
 *          -current user as User object
 *      -RETURNS:
 *          -success in writing as Boolean
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
 * 
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
    
//save all data to csv
String headers = "src,amnt,mnth,src,amnt,freq";
String Filepath ;
ArrayList<String> lines;
User tempUser;

private String lineBuilder(User buildData, int index){
//todo: 
//-enable functionality to allow for cvs to have blank spots where no values exist 
// such as in the case of more user has more expenses than incomes or vice versa
//String returnable;
//String blankline = ",,,";



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
    String line = "test";
    int repeats;
    int smaller;

    ArrayList<String> lines = new ArrayList<String>();
    
    //automatically add header
    lines.add(headers);

    //determine how many rows will be in final report by the size of the larger of the incomes or spending lists
    if (writeData.incomes.size()> writeData.Spending.size()){
        repeats = writeData.incomes.size();
        smaller = writeData.Spending.size();
    }else{
        repeats = writeData.Spending.size();
        smaller = writeData.incomes.size();
    }

    //build lines with lineBuilder 
    for (int j = 0; j < repeats; j++){
        lines.add(lineBuilder(writeData, j));
    }

    //meat and potatoes, using printwriter to print lines built above to a file with header of .csv
    try {
        PrintWriter output = new PrintWriter(filename + ".csv");
        

        output.println(headers)
        for(int i = 0; i<1;i++){
        output.println(line);
        }
        output.close();
    }
    catch(Exception e) {
        e.getStackTrace();
    }

    


    return success;
}


}
