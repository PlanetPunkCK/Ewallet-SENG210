
import java.util.ArrayList;
import java.util.Scanner;

public class DemoMain{

    public static ArrayList<Expense> monthly_expenses;
    public static ArrayList<Income> income_list;
    
    public static void print(String in){
        System.out.println(in);
    }

    private void addExpense(Expense xpense){
        monthly_expenses.add(xpense);
    }



    public static void main(String[] args) {
        
        
        monthly_expenses = new ArrayList<Expense>();
        income_list = new ArrayList<Income>();
        Scanner scn = new Scanner(System.in);
        
        String source;
        double amount;
        int frq;
        String Mnth;

        double totalExpenses = 0.0;
        double totalIncomes = 0.0;


        
        boolean latch = true;

        while (latch){
            print("choose an option: ");

            print("1: add expense");
            print("2: add income");
            print("3: print out expenses and incomes so far");
            print("4: view stats");


            switch (scn.nextInt()){
                case 1:
                    print("What's the expense source?");
                    source = scn.nextLine();


                    print("what's the amount");
                    amount = scn.nextDouble();

                    print("how many times will you pay it this year");
                    frq = scn.nextInt();

                    totalExpenses = amount * frq;

                    monthly_expenses.add(new Expense(source, amount, frq));



                case 2:
                    print("What's the income source?");
                    source = scn.nextLine();


                    print("what's the amount");
                    amount = scn.nextDouble();

                    print("what month is it paid in?");
                    Mnth = scn.nextLine();

                    totalIncomes += amount; 

                    income_list.add(new Income(source, amount, Mnth));

                case 3:
                    print("expenses:");
                    if (monthly_expenses.size() > 0){
                        for (int i = 0; i< monthly_expenses.size(); i++){
                            System.out.println(monthly_expenses.get(i));
                        }
                    }
                    
                    print("incomes:")
                    if (income_list.size() >0){
                        for (int i = 0; i< income_list.size(); i++){
                            System.out.println(income_list.get(i));
                        }
                    }
                case 4:
                    print("total incomes");
                    System.out.println(totalExpenses);
                    print("total expenses");
                    System.out.println(totalIncomes);

                case 5:

                default:
                print("invalid input");
            }
        }

    }
}