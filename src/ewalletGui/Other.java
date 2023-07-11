package ewalletGui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Other extends JFrame {

	private JPanel contentPane;
	private JTextField incField;
	private JTextField expField;
	// double totalIncomes =  ;
	// double totalExpenses = ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Other frame = new Other();
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
	public Other() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton Mbtn = new JButton("Main Menu");
		Mbtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		
		JLabel lblNewLabel = new JLabel("TOTALS SUMMARY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(159, 22, 160, 25);
		contentPane.add(lblNewLabel);
		
		JLabel totalIncomesLabel = new JLabel("Total Incomes: ");
		totalIncomesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalIncomesLabel.setBounds(70, 70, 120, 35);
		contentPane.add(totalIncomesLabel);
		
		JLabel totalExpenseLabel = new JLabel("Total Expenses: ");
		totalExpenseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalExpenseLabel.setBounds(70, 120, 120, 35);
		contentPane.add(totalExpenseLabel);
		
				
		incField = new JTextField();
		incField.setBounds(195, 80, 96, 19);
		contentPane.add(incField);
		incField.setColumns(10);
		
		expField = new JTextField();
		expField.setBounds(195, 130, 96, 19);
		contentPane.add(expField);
		expField.setColumns(10);
	}
}
