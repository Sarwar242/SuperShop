package supershop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddNew extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField unit;
	private JTextField stock;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");
			return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	public void executeSQLQuery(String query, String message) {
		Connection con= getConnection();
		Statement st;
		try {
			st=con.createStatement();
			st.executeUpdate(query);
			
			manage m=new manage();
			manage.main(null);
			dispose();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			dispose();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew frame = new AddNew();
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
	public AddNew() {
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(720, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] catagory={"Fruits","Daily","Cosmatics"};   
		comboBox = new JComboBox(catagory);
		comboBox.setBounds(291, 24, 233, 45);
		
		contentPane.add(comboBox);
		
		lblNewLabel_3 = new JLabel("Choose Catagory : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_3.setBounds(28, 11, 292, 53);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(150, 107, 73, 37);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(304, 109, 233, 37);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(165, 179, 53, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unit : ");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(165, 237, 46, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock : ");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(165, 296, 58, 27);
		contentPane.add(lblNewLabel_2);
		
		price = new JTextField();
		price.setBounds(304, 176, 233, 37);
		contentPane.add(price);
		price.setColumns(10);
		
		unit = new JTextField();
		unit.setBounds(304, 239, 233, 27);
		contentPane.add(unit);
		unit.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(304, 298, 233, 27);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JLabel lblperUnit = new JLabel("(per unit)");
		lblperUnit.setBounds(175, 199, 53, 27);
		contentPane.add(lblperUnit);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(); 
				if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Fruits")) {
					String query="INSERT INTO fruits(name,price,unit,stock) VALUES('"+name.getText()+"','"+price.getText()+"','"+unit.getText()+"','"+price.getText()+"')";
					executeSQLQuery(query, "Inserted");
					}
					else if(comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Daily")) {
							String query="INSERT INTO daily(name,price,unit,stock) VALUES('"+name.getText()+"','"+price.getText()+"','"+unit.getText()+"','"+price.getText()+"')";
								executeSQLQuery(query, "Inserted");
					}
					else if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Cosmatics")){
						String query="INSERT INTO cosmatics(name,price,unit,stock) VALUES('"+name.getText()+"','"+price.getText()+"','"+unit.getText()+"','"+price.getText()+"')";
						executeSQLQuery(query, "Inserted");
					}
			}
		});
		btnAdd.setBounds(165, 364, 89, 23);
		contentPane.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manage m=new manage();
				manage.main(null);
				setVisible(false);
			}
		});
		btnCancel.setBounds(498, 364, 89, 23);
		contentPane.add(btnCancel);
		
	
		
	}

}
