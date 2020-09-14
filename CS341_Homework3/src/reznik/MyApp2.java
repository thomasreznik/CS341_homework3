package reznik;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyApp2 {

	public JFrame frame;
	public JTextField itemt;
	public JTextField costt;
	public JTextField quantityt;
	public JButton btnBuild;
	public JLabel total_sales;
	public JScrollPane scrollPane_1;
	public JTextField saleso;
	public JScrollPane scrollPane_2;
	public JTextArea catalog;
	public SaleSlip2 recipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyApp2 window = new MyApp2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public MyApp2() {
		initialize();
		createEvents();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		recipt = new SaleSlip2();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 6, 101, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel item_label = new JLabel("Item:");
		item_label.setBounds(26, 46, 41, 16);
		frame.getContentPane().add(item_label);

		JLabel cost_label = new JLabel("Cost ($): ");
		cost_label.setBounds(6, 74, 61, 16);
		frame.getContentPane().add(cost_label);

		JLabel quantity_label = new JLabel("Quantity: ");
		quantity_label.setBounds(6, 102, 73, 16);
		frame.getContentPane().add(quantity_label);

		itemt = new JTextField();
		itemt.setBounds(65, 41, 149, 26);
		frame.getContentPane().add(itemt);
		itemt.setColumns(10);

		costt = new JTextField();
		costt.setColumns(10);
		costt.setBounds(65, 69, 149, 26);
		frame.getContentPane().add(costt);

		quantityt = new JTextField();
		quantityt.setColumns(10);
		quantityt.setBounds(65, 97, 149, 26);
		frame.getContentPane().add(quantityt);

		btnBuild = new JButton("Add item to sales list");
		btnBuild.setBounds(6, 135, 438, 29);
		frame.getContentPane().add(btnBuild);

		total_sales = new JLabel("Total Sales:");
		total_sales.setBounds(306, 57, 81, 16);
		frame.getContentPane().add(total_sales);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(239, 86, 205, 32);
		frame.getContentPane().add(scrollPane_1);

		saleso = new JTextField();
		scrollPane_1.setViewportView(saleso);

		scrollPane_2 = new JScrollPane(catalog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(6, 170, 438, 102);
		frame.getContentPane().add(scrollPane_2);

		catalog = new JTextArea();
		scrollPane_2.setViewportView(catalog);

	}

	public void createEvents() {

		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				buildOutput();

			}
		});
	}

	public void buildOutput() {
		recipt.insert_slip(itemt.getText(), Double.valueOf(costt.getText()), Integer.parseInt(quantityt.getText()));

		catalog.setText(recipt.display());

		saleso.setText(recipt.Total());
	}
}
