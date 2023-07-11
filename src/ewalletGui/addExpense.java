package ewalletGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class addExpense extends JFrame {

	private JPanel contentPane;
	private JTextField amountField;
	private JTextField freqField;
	
    Expense tempExpense;
    
	double totalExpenses = 0.0;
	
	String src[] = {"-", "Bills", "Business", "Clothing", "Groceries", "Tools"};
	double amt;
	int yrFreq;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addExpense frame = new addExpense();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addExpense() {
		setTitle("E-Wallet - Add Expenses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel expenseLabel = new JLabel("Add An Expense");
		expenseLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		expenseLabel.setBounds(30, 25, 160, 25);
		contentPane.add(expenseLabel);
		
		JLabel sourceLabel = new JLabel("Source:");
		sourceLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		sourceLabel.setBounds(40, 75, 60, 30);
		contentPane.add(sourceLabel);
		
		JLabel amountLabel = new JLabel("Amount:");
		amountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		amountLabel.setBounds(38, 120, 80, 25);
		contentPane.add(amountLabel);
		
		JLabel freqLabel = new JLabel("Times Paid Per Year:");
		freqLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		freqLabel.setBounds(40, 170, 125, 25);
		contentPane.add(freqLabel);
		
		JComboBox srcBox = new JComboBox(src);
		srcBox.setBounds(185, 80, 90, 20);
		contentPane.add(srcBox);
		
		amountField = new JTextField();
		amountField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		amountField.setBounds(185, 120, 90, 20);
		contentPane.add(amountField);
		amountField.setColumns(10);
		
		freqField = new JTextField();
		freqField.setBounds(185, 172, 30, 20);
		contentPane.add(freqField);
		freqField.setColumns(10);
		
		// Add Button
		JButton addbtn = new JButton("Add");
		addbtn.setBounds(170, 220, 85, 20);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addbtn) {
					// access the curUser and add expenses/spending
					User curUser = new User();
					curUser.Spending.add(new Expense(src[1], amt, yrFreq));
				}
			}
		});
		contentPane.add(addbtn);
		
		// Clear Button
		JButton clearbtn = new JButton("Clear");
		clearbtn.setBounds(265, 220, 85, 20);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == clearbtn) {
					srcBox.setSelectedIndex(0);
					amountField.setText("");
					freqField.setText("");
				}
			}
		});
		contentPane.add(clearbtn);
		
		// Main Menu Button
		JButton Mbtn = new JButton("Main Menu");
		Mbtn.setBounds(10, 230, 85, 20);
		Mbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== Mbtn) {
					// close previous window, open new
					dispose();
					EWalletApp main_menu = new EWalletApp();
					main_menu.setVisible(true);
				}
			}
		});
		contentPane.add(Mbtn);
	}
}
