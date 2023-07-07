package ewalletGui;

import java.util.ArrayList;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;


public class EWalletApp extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	
	IOCtrl CSVCtrl = new IOCtrl();
	String username;
	String pwd;
	User curUser = new User();
	
	String source;
    double amount;
    int frq;
    String Mnth;

    double totalExpenses = 0.0;
    double totalIncomes = 0.0;

    Income tempIncome;
    Expense tempExpense;
    private JTextField pwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EWalletApp frame = new EWalletApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	  
	}

	
	public EWalletApp() {
		// Labels 
		setTitle("E-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Sign-in
		JLabel signinLabel = new JLabel("Sign-In");
		signinLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		signinLabel.setBounds(524, 0, 41, 23);
		contentPane.add(signinLabel);
				
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		usernameLabel.setBounds(481, 25, 45, 13);
		contentPane.add(usernameLabel);
				
		usernameField = new JTextField();
		usernameField.setBounds(525, 22, 60, 20);
		usernameField.setColumns(10);
		contentPane.add(usernameField);
				
		JLabel pwdLabel = new JLabel("Password:");
		pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		pwdLabel.setBounds(481, 48, 45, 13);
		contentPane.add(pwdLabel);
				
		pwdField = new JTextField();
		pwdField.setBounds(525, 45, 60, 20);
		contentPane.add(pwdField);
		pwdField.setColumns(10);
				
		JButton signinbtn = new JButton("Enter");
		signinbtn.setFont(new Font("Tahoma", Font.PLAIN, 7));
		signinbtn.setBounds(525, 69, 55, 15);
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == signinbtn) {
					username = usernameField.getText();
					pwd = pwdField.getText();
					// for testing, delete later
					System.out.println(username);
					// for testing, delete later
					System.out.println(pwd);
					User curUser = new User(username, pwd);
				}				
			}
					
		});
		contentPane.add(signinbtn);
		
		// Title Labels
		JLabel titleLabel_1 = new JLabel("Welcome to E-Wallet!");
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setBounds(200, 80, 130, 15);
		contentPane.add(titleLabel_1);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 146, 0, 0);
		contentPane.add(label);
		
		JLabel titleLabel_2 = new JLabel("Your Money Management System");
		titleLabel_2.setBounds(166, 105, 192, 13);
		titleLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleLabel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(257, 146, 0, 0);
		contentPane.add(label_1);
		
		JLabel titleLabel_3 = new JLabel("Choose an option:");
		titleLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_3.setBounds(200, 168, 113, 13);
		contentPane.add(titleLabel_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(340, 146, 0, 0);
		contentPane.add(label_2);
		
		
		// App Option Buttons
		// Add Expenses
		JButton addEbtn = new JButton("Add Expense");
		addEbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== addEbtn) {
					// close previous window, open new
					dispose();
					addExpense addExpense = new addExpense();
					addExpense.setVisible(true);
				}
			}
		});
		addEbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		addEbtn.setBounds(136, 191, 115, 25);
		addEbtn.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(addEbtn);
		
		// Add Income
		JButton addIbtn = new JButton("Add Income");
		addIbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addIbtn) {
					dispose();
					addIncome addIncome = new addIncome();
					addIncome.setVisible(true);
				}
			}
			
		});
		addIbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		addIbtn.setBounds(261, 191, 115, 25);
		contentPane.add(addIbtn);
		
		// Income Report
		JButton iReportbtn = new JButton("Income Report");
		iReportbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		iReportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// need to do
				
			}
		});
		iReportbtn.setBounds(136, 226, 115, 25);
		contentPane.add(iReportbtn);
		
		// Expense Report
		JButton eReportbtn = new JButton("Expense Report");
		eReportbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		eReportbtn.setBounds(261, 226, 115, 25);
		contentPane.add(eReportbtn);
		
		// Other Stats
		JButton btnNewButton_4 = new JButton("Other Stats");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBounds(136, 261, 115, 25);
		contentPane.add(btnNewButton_4);
		
		// Save and Quit
		JButton quitbtn = new JButton("Save and Quit");
		quitbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		quitbtn.setBounds(261, 261, 115, 25);
		contentPane.add(quitbtn);
		
		
		
	}
}
