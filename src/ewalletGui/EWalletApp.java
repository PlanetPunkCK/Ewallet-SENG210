package ewalletGui;

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

public class EWalletApp extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public EWalletApp() {
		setTitle("E-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to E-Wallet!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(255, 25, 130, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 146, 0, 0);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Your Money Management System");
		lblNewLabel_1.setBounds(227, 47, 192, 13);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(257, 146, 0, 0);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("Choose an option:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(267, 70, 113, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(340, 146, 0, 0);
		contentPane.add(label_2);
		
		JButton addEbtn = new JButton("Add Expense");
		addEbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== addEbtn) {
					addExpense addExpense = new addExpense();
					addExpense.setVisible(true);
				}
			}
		});
		addEbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		addEbtn.setBounds(200, 150, 115, 25);
		addEbtn.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(addEbtn);
		
		JButton addIbtn = new JButton("Add Income");
		addIbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addIbtn) {
					addIncome addIncome = new addIncome();
					addIncome.setVisible(true);
				}
			}
			
		});
		addIbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		addIbtn.setBounds(330, 150, 115, 25);
		contentPane.add(addIbtn);
		
		JButton btnNewButton_2 = new JButton("Income Report");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(200, 190, 115, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Expense Report");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBounds(330, 190, 115, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Other Stats");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBounds(200, 230, 115, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Save and Quit");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setBounds(330, 230, 115, 25);
		contentPane.add(btnNewButton_5);
		
	}
}
