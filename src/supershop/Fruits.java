package supershop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import com.toedter.calendar.JCalendar;

public class Fruits extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3142646145601808076L;
	//variables
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel idl;
	private JTextField id;
	private JTextField name;
	private JTextField price;
	private JTextField unit;
	private JTextField stock;
	private JLabel lblNewLabel_3;
	
	float pp=0,bill=0	;
	private float preQuan=0;
	
	private int check=0, currID=0;
	private JLabel SellLbl;

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
	public ArrayList<Items>getItemList(){
		ArrayList<Items>itemList=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM fruits";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("id"),rs.getString("name"), rs.getString("price"), rs.getString("unit"), rs.getInt("stock"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	public void show_fruits() {
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Name", "Price", "Unit", "Stock"},
				},
				new String[] {
						"ID", "Name", "Price", "Unit", "Stock"
				}
			));
		ArrayList<Items> list= getItemList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[5];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getPrice();
			row[3]=list.get(i).getUnit();
			row[4]=list.get(i).getStock();
			
			model.addRow(row);
		}
		
	}
	
	public void executeSQLQuery(String query, String message) {
		Connection con= getConnection();
		Statement st;
		try {
			st=con.createStatement();
			if(st.executeUpdate(query)==1) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				show_fruits();
				JOptionPane.showMessageDialog(null, message+"Successfully");
				JOptionPane.showMessageDialog(null, "Total Price is: "+bill+" Taka");	
			}else {
				JOptionPane.showMessageDialog(null, "Not "+message);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fruits frame = new Fruits();
					frame.setVisible(true);
					frame.requestFocus();
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fruits() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setMinimumSize(new Dimension(1050, 710));
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setForeground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		table = new JTable();
		table.setBounds(419, 109, 605, 496);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				id.setText(model.getValueAt(i,0).toString());
				name.setText(model.getValueAt(i,1).toString());
				price.setText(model.getValueAt(i,2).toString());
				unit.setText(model.getValueAt(i,3).toString());
				
				currID=Integer.parseInt(model.getValueAt(i, 0).toString());
				pp=Float.parseFloat(model.getValueAt(i, 2).toString());
				preQuan=(float) model.getValueAt(i, 4);
			}
		});
		table.setDragEnabled(true);
		table.setGridColor(new Color(128, 0, 128));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(new Color(0, 100, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Name", "Price", "Unit", "Stock"},
			},
			new String[] {
				"ID", "Name", "Price", "Unit", "Stock"
			}
		));
		show_fruits();
		contentPane.setLayout(null);
		
		SellLbl = new JLabel("Sell Fruits");
		SellLbl.setForeground(Color.GREEN);
		SellLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SellLbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		SellLbl.setBounds(429, 34, 161, 39);
		contentPane.add(SellLbl);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setBounds(0, 20, 198, 133);
		calendar.getYearChooser().setBounds(98, 0, 100, 20);
		calendar.getMonthChooser().setBounds(0, 0, 98, 20);
		calendar.setBounds(100, 406, 198, 153);
		contentPane.add(calendar);
		calendar.setLayout(null);
		
		idl = new JLabel("ID : ");
		idl.setVerticalAlignment(SwingConstants.TOP);
		idl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idl.setHorizontalTextPosition(SwingConstants.CENTER);
		idl.setHorizontalAlignment(SwingConstants.LEFT);
		idl.setBounds(28, 46, 38, 27);
		contentPane.add(idl);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(255, 245, 238));
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.add(scrollPane, BorderLayout.SOUTH);
		
		id = new JTextField();
		id.setEditable(false);
		id.setToolTipText("Automatically Generated");
		id.setBounds(100, 46, 233, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(20, 75, 53, 27);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(100, 80, 233, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 103, 53, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unit : ");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 158, 46, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Quantity :");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 218, 193, 27);
		contentPane.add(lblNewLabel_2);
		
		price = new JTextField();
		price.setEditable(false);
		price.setBounds(100, 111, 233, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		unit = new JTextField();
		unit.setEditable(false);
		unit.setBounds(100, 166, 233, 20);
		contentPane.add(unit);
		unit.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(100, 261, 233, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JLabel lblperUnit = new JLabel("(per unit)");
		lblperUnit.setBounds(17, 133, 46, 14);
		contentPane.add(lblperUnit);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String quan=stock.getText();
				float q=Float.parseFloat(quan);
				float newQuan=preQuan-q;
				if(newQuan<0) {
					JOptionPane.showMessageDialog(null, "Stock not enough!");			
				}
				else {
				bill= q*pp;
				String query="UPDATE  fruits SET stock= '"+newQuan+"' WHERE id='"+currID+"'";
				executeSQLQuery(query, "Sold");
				id.setText("");
				name.setText("");
				unit.setText("");
				price.setText("");
				stock.setText("");
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\plus.png"));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setSelectedIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\plus.png"));
		btnNewButton.setBounds(154, 323, 119, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Catagory catagory=new Catagory();
				Catagory.main(null);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(67, 588, 89, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop shop=new Shop();
				Shop.main(null);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(184, 588, 89, 31);
		contentPane.add(btnNewButton_4);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\1503_fruit_main.jpg"));
		lblNewLabel_3.setBounds(-11, 0, 1011, 660);
		contentPane.add(lblNewLabel_3);
	}
}
