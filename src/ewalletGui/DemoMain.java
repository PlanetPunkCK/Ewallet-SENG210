package ewalletGui;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoMain{
    
    public static void print(String in){
        System.out.println(in);
    }


    public static void main(String[] args) {
        
        User curUser = new User();
        
        
        Scanner scn = new Scanner(System.in);
        IOCtrl CSVCtrl = new IOCtrl();
        
        String source;
        double amount;
        int frq;
        String Mnth;

        double totalExpenses = 0.0;
        double totalIncomes = 0.0;

        Income tempIncome;
        Expense tempExpense;

        
        boolean latch = true;


        print("what's your Username?:");
        curUser.username = scn.nextLine();



        while (latch){
            print("choose an option: ");

            print("1: add expense");
            print("2: add income");
            print("3: print out expenses and incomes so far");
            print("4: view stats");
            print("5: output CSV in local directory");
            print("7: quit");


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

                    curUser.Spending.add(new Expense(source, amount, frq));
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


                    curUser.incomes.add(new Income(source, amount, Mnth));
                    break;
                    
                case 3:
                    print("expenses:");
                    if (curUser.Spending.size() > 0){
                        for (int i = 0; i< curUser.Spending.size(); i++){
                            tempExpense = curUser.Spending.get(i);
                            System.out.println(tempExpense.source);
                            System.out.println(tempExpense.amount);
                            System.out.println(tempExpense.yearlyfrequency);
                            print("_______________");
                        }
                    }
                    
                    print("incomes:");
                    if (curUser.incomes.size() >0){
                        for (int i = 0; i< curUser.incomes.size(); i++){
                            tempIncome = curUser.incomes.get(i);
                            System.out.println(tempIncome.source);
                            System.out.println(tempIncome.amount);
                            System.out.println(tempIncome.Month);
                            print("_______________");
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
                    if (CSVCtrl.makeReport(curUser, curUser.username)){
                        print("success outputing CSV"); //When implementing into GUI, replace this with simple alert message
                    }else{
                        print("fail outputting CSV"); //this too
                    }
                    break;
                case 6:
                        //print("What's the price of the item you wanna save for?");
                        //int saving = scn.nextDouble();
                        //scn.nextLine();
                        //break;
                case 7:
                    print("goodbye");//get creative for this one, could be a goodbye alert or just an unceremonious close app
                    latch = false;
                    break;
                default:
                print("invalid input");
                
            }
        }
        scn.close();
    }
}