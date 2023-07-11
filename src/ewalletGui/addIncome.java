package ewalletGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class addIncome extends JFrame {

	private JPanel contentPane;
	private JTextField amountField;
	
	Income tempIncome;
	double totalIncomes = 0.0;
	String src;
	String Mnth;
	double amt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addIncome frame = new addIncome();
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
	public addIncome() {
		setTitle("E-Wallet - Add Incomes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addILabel = new JLabel("Add An Income");
		addILabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		addILabel.setBounds(30, 25, 160, 25);
		contentPane.add(addILabel);
		
		JLabel srcLabel = new JLabel("Source:");
		srcLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		srcLabel.setBounds(40, 75, 60, 30);
		contentPane.add(srcLabel);
		
		String src[] = {"-", "Main Office", "Rentals", "Royalties", "Side Jobs"};
		JComboBox srcBox = new JComboBox(src);
		srcBox.setBounds(175, 80, 85, 20);
		contentPane.add(srcBox);
		
		JLabel amtLabel = new JLabel("Amount:");
		amtLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		amtLabel.setBounds(40, 115, 80, 25);
		contentPane.add(amtLabel);
		
		JLabel monthLabel = new JLabel("Month Paid In:");
		monthLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		monthLabel.setBounds(40, 170, 125, 25);
		contentPane.add(monthLabel);
		
		amountField = new JTextField();
		amountField.setBounds(175, 120, 85, 20);
		contentPane.add(amountField);
		amountField.setColumns(10);
		
		String months[] = {"-", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		JComboBox monthComboBox = new JComboBox(months);
		monthComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		monthComboBox.setMaximumRowCount(12);
		monthComboBox.setBounds(175, 172, 85, 20);
		contentPane.add(monthComboBox);
		
		
		// Add Button
		JButton addbtn = new JButton("Add");
		addbtn.setBounds(175, 220, 85, 21);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addbtn) {
					// access the curUser and add income/incomes
					User curUser = new User();
					String srcChoice = String.valueOf(srcBox.getSelectedItem());
					String Mnth = String.valueOf(monthComboBox.getSelectedItem());
					curUser.incomes.add(new Income(srcChoice, amt, Mnth));
					totalIncomes += amt;
				}
			}
		});
		contentPane.add(addbtn);
		
		// Clear Button
		JButton clearbtn = new JButton("Clear");
		clearbtn.setBounds(283, 220, 85, 21);
		clearbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == clearbtn) {
					srcBox.setSelectedIndex(0);
					amountField.setText("");
					monthComboBox.setSelectedIndex(0);
				}
				
			}
		});
		contentPane.add(clearbtn);
		
		
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
