package supershop;

import javax.swing.*;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class Shop extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4752374753932744185L;

	public Shop() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\SuperShopProject\\Icons\\shopping_bag.png"));
		setMinimumSize(new Dimension(800, 600));
		getContentPane().setBackground(new Color(102, 255, 51));
		setBackground(new Color(220, 20, 60));
	
		getContentPane().setLayout(null);
			
			JButton btnSell = new JButton("Sell");
			btnSell.setSelectedIcon(null);
			btnSell.setSelected(isVisible());
			
			btnSell.setBounds(317, 186, 118, 30);
			btnSell.addActionListener(new ActionListener() {
				private Catagory catagory;

				public void actionPerformed(ActionEvent arg0) {
		Catagory c= new Catagory();
		Catagory.main(null);
		setVisible(false);}
			});
			
			JButton btnItems = new JButton("Items");
			btnItems.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					manage m=new manage();
					manage.main(null);
					setVisible(false);
				}
			});
			btnItems.setBackground(new Color(144, 238, 144));
			btnItems.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			btnItems.setBounds(317, 270, 118, 26);
			getContentPane().add(btnItems);
			btnSell.setBackground(Color.ORANGE);
			btnSell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			getContentPane().add(btnSell);
		
			
			JButton btnBuy = new JButton("Buy");
			btnBuy.setBounds(317, 228, 118, 30);
			btnBuy.setBackground(new Color(102, 51, 204));
			btnBuy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			getContentPane().add(btnBuy);
			btnBuy.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Catagory2 catagory2=new Catagory2();
					Catagory2.main(null);
					setVisible(false);
					
				}
			});
		
		JLabel l1 = new JLabel("Welcome to Super Shop!");
		l1.setBounds(85, 30, 602, 65);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		l1.setForeground(Color.RED);
		l1.setBackground(new Color(0, 0, 255));
		getContentPane().add(l1);
		
		JTextField txtSupershop = new JTextField();
		txtSupershop.setBounds(0, 511, 794, 50);
		txtSupershop.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtSupershop.setBackground(Color.LIGHT_GRAY);
		txtSupershop.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupershop.setText("@ SuperShop");
		txtSupershop.setEditable(false);
		getContentPane().add(txtSupershop);
		txtSupershop.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\SuperShop.png"));
		lblNewLabel.setBounds(0, 0, 784, 549);
		getContentPane().add(lblNewLabel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
					frame.setVisible(true);
					frame.requestFocus();
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 
	}
}