package supershop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;


public class Catagory2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtSupershop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catagory2 frame = new Catagory2();
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
	public Catagory2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Buy");
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(243, 11, 292, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblItemCatagories = new JLabel("Item Catagories");
		lblItemCatagories.setForeground(new Color(0, 100, 0));
		lblItemCatagories.setBounds(83, 94, 633, 36);
		lblItemCatagories.setBackground(Color.LIGHT_GRAY);
		lblItemCatagories.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblItemCatagories.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblItemCatagories);
		
		JButton btnFruits = new JButton("Fruits");
		btnFruits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fruits2 fruits2= new Fruits2();
			Fruits2.main(null);
			setVisible(false);
			}
			
		});
		btnFruits.setForeground(new Color(128, 0, 0));
		btnFruits.setBackground(new Color(222, 184, 135));
		btnFruits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFruits.setBounds(309, 228, 185, 43);
		contentPane.add(btnFruits);
		
		JButton btnCosmatics = new JButton("Cosmatics");
		btnCosmatics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cosmatics2 cosmatics2= new Cosmatics2();
				Cosmatics2.main(null);
				setVisible(false);
			}
		});
		btnCosmatics.setForeground(new Color(128, 0, 0));
		btnCosmatics.setBackground(new Color(222, 184, 135));
		btnCosmatics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCosmatics.setBounds(309, 300, 185, 43);
		contentPane.add(btnCosmatics);
		
		JButton btnDailyComo = new JButton("Daily Commodity");
		btnDailyComo.setForeground(new Color(128, 0, 0));
		btnDailyComo.setBackground(new Color(222, 184, 135));
		btnDailyComo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDailyComo.setBounds(309, 160, 185, 43);
		btnDailyComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Daily2 daily2= new Daily2();
				Daily2.main(null);
				setVisible(false);
			}
		});
		contentPane.add(btnDailyComo);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setForeground(new Color(0, 100, 0));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop shop=new Shop();
				Shop.main(null);
				setVisible(false);
			}
		});
		btnHome.setBackground(Color.ORANGE);
		btnHome.setBounds(353, 370, 107, 36);
		contentPane.add(btnHome);
		
		txtSupershop = new JTextField();
		txtSupershop.setBounds(0, 518, 856, 53);
		txtSupershop.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtSupershop.setBackground(Color.LIGHT_GRAY);
		txtSupershop.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupershop.setText("@ SuperShop");
		contentPane.add(txtSupershop);
		txtSupershop.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\SuperShopProject\\Icons\\6910256-red-background.jpg"));
		lblNewLabel.setBounds(0, 0, 886, 571);
		contentPane.add(lblNewLabel);
		
	}
}