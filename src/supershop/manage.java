package supershop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

public class manage extends JFrame {

	private JPanel contentPane;
	private JTable daily;
	private JTable fruits;
	private JLabel lblCostamtic;
	private JTable cos;
	private JTextField id;
	private JTextField name;
	private JTextField price;
	private JTextField unit;
	private JTextField stock;
	private JLabel idl;
	private int tblck=0,fid=0;

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
			if(st.executeUpdate(query)==1) {
				
				DefaultTableModel model1=(DefaultTableModel) fruits.getModel();
				model1.setRowCount(0);
				show_fruits();
				
				DefaultTableModel model2=(DefaultTableModel) daily.getModel();
				model2.setRowCount(0);
				show_daily();
				
				DefaultTableModel model3=(DefaultTableModel) cos.getModel();
				model3.setRowCount(0);
				show_cos();;
				
				JOptionPane.showMessageDialog(null, "Data "+message+"Successfully");
			}else {
				JOptionPane.showMessageDialog(null, "Data Not "+message);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public ArrayList<Items>getItemList1(){
		ArrayList<Items>itemList1=new ArrayList<Items>();
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
				itemList1.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList1;
	}
	
	
	public void show_fruits() {
		ArrayList<Items> list= getItemList1();
		fruits.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Name", "Price", "Unit", "Stock"},
				},
				new String[] {
						"ID", "Name", "Price", "Unit", "Stock"
				}
			));
		DefaultTableModel model=(DefaultTableModel)fruits.getModel();
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
	public ArrayList<Items>getItemList2(){
		ArrayList<Items>itemList2=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM daily";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("id"),rs.getString("name"), rs.getString("price"), rs.getString("unit"), rs.getInt("stock"));
				itemList2.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList2;
	}
	public void show_daily() {
		ArrayList<Items> list= getItemList2();
		daily.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Name", "Price", "Unit", "Stock"},
				},
				new String[] {
						"ID", "Name", "Price", "Unit", "Stock"
				}
			));
		DefaultTableModel model=(DefaultTableModel)daily.getModel();
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
	public ArrayList<Items>getItemList3(){
		ArrayList<Items>itemList3=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM cosmatics";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("id"),rs.getString("name"), rs.getString("price"), rs.getString("unit"), rs.getInt("stock"));
				itemList3.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList3;
	}
	public void show_cos() {
		ArrayList<Items> list= getItemList3();
		cos.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Name", "Price", "Unit", "Stock"},
				},
				new String[] {
						"ID", "Name", "Price", "Unit", "Stock"
				}
			));
		DefaultTableModel model=(DefaultTableModel)cos.getModel();
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage frame = new manage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param scrollPane 
	 */
	public manage() {
		setMinimumSize(new Dimension(1200, 750));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFruits = new JLabel("Fruits : ");
		lblFruits.setHorizontalAlignment(SwingConstants.CENTER);
		lblFruits.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFruits.setBounds(55, 45, 69, 25);
		contentPane.add(lblFruits);
		
		JLabel lblDaily = new JLabel("Daily : ");
		lblDaily.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily.setBounds(55, 274, 69, 25);
		contentPane.add(lblDaily);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(821, 75, 53, 27);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(921, 80, 233, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(833, 125, 53, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unit : ");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(840, 207, 46, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock : ");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(828, 294, 58, 27);
		contentPane.add(lblNewLabel_2);
		
		price = new JTextField();
		price.setBounds(921, 130, 233, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		unit = new JTextField();
		unit.setBounds(921, 212, 233, 20);
		contentPane.add(unit);
		unit.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(921, 294, 233, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JLabel lblperUnit = new JLabel("(per unit)");
		lblperUnit.setBounds(828, 166, 46, 14);
		contentPane.add(lblperUnit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 56, 629, 199);
		contentPane.add(scrollPane);
		
		
		fruits = new JTable();
		scrollPane.setViewportView(fruits);
		fruits.setFocusable(true);
		fruits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cos.clearSelection();
				daily.clearSelection();
				int i=fruits.getSelectedRow();
				TableModel model1=fruits.getModel();
				fid=(int) model1.getValueAt(i,0);
				name.setText(model1.getValueAt(i,1).toString());
				price.setText(model1.getValueAt(i,2).toString());
				unit.setText(model1.getValueAt(i,3).toString());
				stock.setText(model1.getValueAt(i,4).toString());
				tblck=1;
			}
		});
		
		show_fruits();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(165, 276, 629, 199);
		contentPane.add(scrollPane_1);
		
		daily = new JTable();
		scrollPane_1.setViewportView(daily);
		
		daily.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fruits.clearSelection();
				cos.clearSelection();
				int i=daily.getSelectedRow();
				TableModel model2=daily.getModel();
				fid=(int) model2.getValueAt(i,0);
				name.setText(model2.getValueAt(i,1).toString());
				price.setText(model2.getValueAt(i,2).toString());
				unit.setText(model2.getValueAt(i,3).toString());
				stock.setText(model2.getValueAt(i,4).toString());
				tblck=2;
			}
		});
		show_daily();
		
		lblCostamtic = new JLabel("Costamtics : ");
		lblCostamtic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCostamtic.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostamtic.setBounds(40, 498, 109, 32);
		contentPane.add(lblCostamtic);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(166, 503, 629, 208);
		contentPane.add(scrollPane_2);
		
		cos = new JTable();
		scrollPane_2.setViewportView(cos);
		
		cos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				daily.clearSelection();
				fruits.clearSelection();
				int i=cos.getSelectedRow();
				TableModel model3=cos.getModel();
				fid=(int) model3.getValueAt(i,0);
				name.setText(model3.getValueAt(i,1).toString());
				price.setText(model3.getValueAt(i,2).toString());
				unit.setText(model3.getValueAt(i,3).toString());
				stock.setText(model3.getValueAt(i,4).toString());
				tblck=3;
			}
		});
		show_cos();
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblck==1) {
				String query="UPDATE `fruits` SET `name`='"+name.getText()+"',`price`='"+price.getText()+"',`unit`='"+unit.getText()+"',`stock`='"+stock.getText()+"' WHERE id='"+fid+"'";
				executeSQLQuery(query, "Updated");
				tblck=0;
				}
				else if(tblck==2) {
					String query="UPDATE `daily` SET `name`='"+name.getText()+"',`price`='"+price.getText()+"',`unit`='"+unit.getText()+"',`stock`='"+stock.getText()+"' WHERE id='"+fid+"'";
					executeSQLQuery(query, "Updated");
					tblck=0;
				}
				else if (tblck==3){
					String query="UPDATE `cosmatics` SET `name`='"+name.getText()+"',`price`='"+price.getText()+"',`unit`='"+unit.getText()+"',`stock`='"+stock.getText()+"' WHERE id='"+fid+"'";
					executeSQLQuery(query, "Updated");
					tblck=0;
				}
				name.setText("");
				price.setText("");
				unit.setText("");
				stock.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(184, 134, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\edit.png"));
		btnNewButton_1.setSelectedIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\edit.png"));
		btnNewButton_1.setBounds(856, 442, 119, 46);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblck==1) {
					String query="DELETE FROM `fruits` WHERE id='"+fid+"'";
					executeSQLQuery(query, "Deleted");
					tblck=0;}
					else if(tblck==2) {
						String query="DELETE FROM `daily` WHERE id='"+fid+"'";
						executeSQLQuery(query, "Deleted");
						tblck=0;
					}
					else if (tblck==3){
						String query="DELETE FROM `cosmatics` WHERE id='"+fid+"'";
						executeSQLQuery(query, "Deleted");
						tblck=0;
					}
				name.setText("");
				price.setText("");
				unit.setText("");
				stock.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\bt_remove.png"));
		btnNewButton_2.setSelectedIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\bt_remove.png"));
		btnNewButton_2.setBounds(1010, 442, 131, 46);
		contentPane.add(btnNewButton_2);
		
		JButton addNew = new JButton("Add New");
		addNew.setHorizontalTextPosition(SwingConstants.RIGHT);
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddNew addNew= new AddNew();
				AddNew.main(null);
				setVisible(false);
			
			}
		});
		addNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		addNew.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\plus.png"));
		addNew.setBackground(Color.MAGENTA);
		addNew.setSelectedIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\plus.png"));
		addNew.setBounds(856, 533, 284, 46);
		contentPane.add(addNew);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop s= new Shop();
				Shop.main(null);
				setVisible(false);
			}
			
		});
		btnBack.setBounds(955, 619, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblManageItems = new JLabel("Manage Items");
		lblManageItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageItems.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblManageItems.setBounds(500, 0, 246, 46);
		contentPane.add(lblManageItems);
	}
}
