package ewalletGui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;

public class IncomeReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeReport frame = new IncomeReport();
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
	public IncomeReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Title labels
		JLabel titleLabel = new JLabel("INCOME REPORT");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(145, 25, 200, 30);
		contentPane.add(titleLabel);
		
		JLabel titleLabel2 = new JLabel("Export your Income information to a report!");
		titleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titleLabel2.setBounds(100, 50, 270, 15);
		contentPane.add(titleLabel2);
		
		JLabel titleLabel3 = new JLabel("(CSV File)");
		titleLabel3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titleLabel3.setBounds(190,75, 75, 15);
		
		contentPane.add(titleLabel3);
		
		
		
		// Buttons
		// Export
		JButton expbtn = new JButton("Export Now");
		expbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		expbtn.setBounds(168, 114, 104, 21);
		expbtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == expbtn) {
					
				}
			}
			
		});
		contentPane.add(expbtn);
		
		// Main menu
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
	}
}
