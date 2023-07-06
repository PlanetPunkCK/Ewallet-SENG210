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
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblNewLabel = new JLabel("Add An Income");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 25, 160, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Source:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(40, 75, 60, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(40, 115, 80, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Month Paid In:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(40, 170, 125, 25);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(175, 81, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 118, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String months[] = {"-", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		JComboBox comboBox = new JComboBox(months);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setMaximumRowCount(12);
		comboBox.setBounds(175, 172, 85, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(175, 220, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(283, 220, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton Mbtn = new JButton("Main Menu");
		Mbtn.setBounds(10, 232, 85, 21);
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
