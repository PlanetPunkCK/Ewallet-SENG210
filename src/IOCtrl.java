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
String headers = "src,amnt,mnth,src,amnt,freq\n";
String Filepath ;
ArrayList<String> lines;
User tempUser;

private String lineBuilder(User buildData, int index){
//todo: 
//-enable functionality to allow for cvs to have blank spots where no values exist such as in the case of more user has more expenses than 
String returnable;
String blankline = ",,,";

returnable+=





return "dodo";
};


public boolean makeReport(User writeData, String filename){
    
    boolean success = false;
    String line = "test";
    int repeats;

    ArrayList<String> lines = new ArrayList<String>();
    
    //automatically add header
    lines.add(headers);

    //determine how many rows will be in final report by the size of the larger of the incomes or spending lists
    if (writeData.incomes.size()> writeData.Spending.size()){
        repeats = writeData.incomes.size();
    }else{
        repeats = writeData.Spending.size();
    }

    //
    for (int j = 0; j < repeats; j++){
        lines.add(lineBuilder(writeData, j));
    }

    try {
        PrintWriter output = new PrintWriter(filename + ".txt");
        


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
