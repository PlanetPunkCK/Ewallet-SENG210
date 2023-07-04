
import java.util.ArrayList;
import java.util.Scanner;

public class DemoMain{

    public static ArrayList<Expense> monthly_expenses;
    public static ArrayList<Income> income_list;
    
    public static void print(String in){
        System.out.println(in);
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

        Income tempIncome;
        Expense tempExpense;

        
        boolean latch = true;

        while (latch){
            print("choose an option: ");

            print("1: add expense");
            print("2: add income");
            print("3: print out expenses and incomes so far");
            print("4: view stats");
            print("5: quit");


            switch (scn.nextInt()){
                case 1:
                    scn.nextLine();

                    print("What's the expense source?");
                    source = scn.nextLine();


                    print("what's the amount");
                    amount = scn.nextDouble();

                    print("how many times will you pay it this year");
                    frq = scn.nextInt();

                    totalExpenses = amount * frq;

                    monthly_expenses.add(new Expense(source, amount, frq));
                    break;


                case 2:
                    scn.nextLine();

                    print("What's the income source?");
                    source = scn.nextLine();


                    print("what's the amount");
                    amount = scn.nextDouble();
                    scn.nextLine();

                    print("what month is it paid in?");
                    Mnth = scn.nextLine();

                    totalIncomes += amount; 


                    income_list.add(new Income(source, amount, Mnth));
                    break;
                    
                case 3:
                    print("expenses:");
                    if (monthly_expenses.size() > 0){
                        for (int i = 0; i< monthly_expenses.size(); i++){
                            tempExpense = monthly_expenses.get(i);
                            System.out.println(tempExpense.source);
                            System.out.println(tempExpense.amount);
                            System.out.println(tempExpense.yearlyfrequency);
                        }
                    }
                    
                    print("incomes:");
                    if (income_list.size() >0){
                        for (int i = 0; i< income_list.size(); i++){
                            tempIncome = income_list.get(i);
                            System.out.println(tempIncome.source);
                            System.out.println(tempIncome.amount);
                            System.out.println(tempIncome.Month);
                        }
                    }
                    break;
                case 4:
                    print("total incomes");
                    System.out.println(totalIncomes);
                    print("total expenses");
                    System.out.println(totalExpenses);
                    break;
                case 5:
                    print("goodbye");
                    latch = false;
                    break;
                default:
                print("invalid input");
                
            }
        }

    }
}