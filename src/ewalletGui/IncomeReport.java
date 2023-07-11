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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

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
		titleLabel.setBounds(145, 15, 200, 30);
		contentPane.add(titleLabel);
		
		JLabel titleLabel2 = new JLabel("Export your Income information to a report!");
		titleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titleLabel2.setBounds(100, 40, 270, 15);
		contentPane.add(titleLabel2);
		
		JLabel titleLabel3 = new JLabel("(CSV File)");
		titleLabel3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titleLabel3.setBounds(190,60, 75, 15);
		
		contentPane.add(titleLabel3);
		
		
		// Source Choice
		String src[] = {"ALL", "Main Office", "Rentals", "Royalties", "Side Jobs"};
		JComboBox srcBox = new JComboBox(src);
		srcBox.setBounds(170, 140, 100, 25);
		contentPane.add(srcBox);
		
		// Buttons
		// Export
		JButton expbtn = new JButton("Export Now");
		expbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		expbtn.setBounds(165, 195, 105, 20);
		expbtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == expbtn) {
					IOCtrl incReport = new IOCtrl();
					User uIn = new User();
					String srcChoice = String.valueOf(srcBox.getSelectedItem());
					incReport.makeReport(uIn, srcChoice);
					JOptionPane.showMessageDialog(contentPane, "Income Report for " + srcBox.getSelectedItem() + " sources were created successfully!");
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
		
		JLabel titleLabel4 = new JLabel("Choose Income Source");
		titleLabel4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titleLabel4.setBounds(155, 115, 140, 15);
		contentPane.add(titleLabel4);
		
		
	}
}
