/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;

import objects.Controll;
import objects.Main;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import database.DbConnection;

import javax.swing.JLabel;

public class Login extends javax.swing.JFrame {

	String message;
	public boolean isAdminOkey = false;

	public Login() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	Controll controll = new Controll();

	@SuppressWarnings("unchecked")

	private void initComponents() {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		pn_body = new javax.swing.JPanel();
		lb_login_personelnumber = new javax.swing.JLabel();
		lb_login_personelnumber.setBounds(105, 175, 143, 20);
		lb_login_password = new javax.swing.JLabel();
		lb_login_password.setBounds(105, 227, 144, 20);
		tf_login_personelnumber = new javax.swing.JTextField();
		tf_login_personelnumber.setBounds(289, 174, 157, 29);
		tf_login_password = new javax.swing.JPasswordField();
		tf_login_password.setBounds(289, 226, 157, 29);
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBorder(whiteline);
		btn_cancel.setBounds(105, 320, 143, 54);
		btn_login = new javax.swing.JButton();
		btn_login.setBorder(whiteline);
		btn_login.setBounds(315, 320, 143, 54);
		pn_title = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		lb_loginForm = new javax.swing.JLabel();
		lb_min = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 153, 0));
		setUndecorated(true);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		lb_login_personelnumber.setBackground(new java.awt.Color(255, 255, 255));
		lb_login_personelnumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_login_personelnumber.setForeground(new java.awt.Color(255, 255, 255));
		lb_login_personelnumber.setText("Personalnummer:");

		lb_login_password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_login_password.setForeground(new java.awt.Color(240, 240, 240));
		lb_login_password.setText("Passwort:");

		tf_login_personelnumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		tf_login_personelnumber.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tf_login_personelnumberActionPerformed(evt);
			}
		});

		tf_login_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		tf_login_password.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tf_login_passwordActionPerformed(evt);
			}
		});

		btn_cancel.setBackground(new java.awt.Color(150, 40, 27));
		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Stornieren");
		btn_cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button_cancelActionPerformed(evt);
			}
		});

		btn_login.setBackground(new java.awt.Color(82, 179, 217));
		btn_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_login.setForeground(new java.awt.Color(255, 255, 255));
		btn_login.setText("Einloggen");
		btn_login.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					button_loginActionPerformed(evt);
				} catch (InstantiationException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

		pn_title.setBackground(new java.awt.Color(0, 153, 0));

		lb_close.setBackground(new java.awt.Color(255, 255, 255));
		lb_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_close.setForeground(new java.awt.Color(255, 255, 255));
		lb_close.setText("X");
		lb_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lb_close.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JlCloseMouseClicked(evt);
			}
		});

		lb_loginForm.setBackground(new java.awt.Color(255, 255, 255));
		lb_loginForm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_loginForm.setForeground(new java.awt.Color(255, 255, 255));
		lb_loginForm.setText("Login Form");

		lb_min.setBackground(new java.awt.Color(255, 255, 255));
		lb_min.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_min.setForeground(new java.awt.Color(255, 255, 255));
		lb_min.setText("-");
		lb_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lb_min.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JlMinMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout gl_pn_title = new javax.swing.GroupLayout(pn_title);
		pn_title.setLayout(gl_pn_title);
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						gl_pn_title.createSequentialGroup().addGap(22, 22, 22)
								.addComponent(lb_loginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lb_min).addGap(18, 18, 18).addComponent(lb_close).addGap(30, 30, 30)));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lb_close, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lb_min, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(lb_loginForm, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
				.addComponent(pn_body, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pn_body, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)));
		pn_body.setLayout(null);
		pn_body.add(lb_login_personelnumber);
		pn_body.add(tf_login_personelnumber);
		pn_body.add(btn_cancel);
		pn_body.add(btn_login);
		pn_body.add(lb_login_password);
		pn_body.add(tf_login_password);

		img_login = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.jpeg")).getImage();
		img_login.setIcon(new ImageIcon(img));
		img_login.setBounds(175, 34, 183, 87);
		pn_body.add(img_login);

		getContentPane().setLayout(layout);

		pack();
	}

	private void JlCloseMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void JlMinMouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void button_loginActionPerformed(java.awt.event.ActionEvent evt)
			throws InstantiationException, IllegalAccessException, SQLException, IOException {

		DbConnection control = new DbConnection();
		char[] login_password = tf_login_password.getPassword();
		if (control.controlInformation(tf_login_personelnumber.getText(), String.valueOf(login_password)) == true) {
			JOptionPane.showMessageDialog(null, "erfolgreicher Login", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
			message = "STRT|Kabinett 1|" + tf_login_personelnumber.getText() + "|";

			if (control.isAdmin(tf_login_personelnumber.getText(), String.valueOf(login_password)) == true) {

				message += "Admin|10|3";
				System.out.println("===>> " + message);
				try {
					Main.toCabinet.println(message);
					System.out.println("<<=== " + Main.fromCabinet.readLine());

				} catch (UnknownHostException e) {
					System.out.println("Unknown Host...");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("IOProbleme...");
					e.printStackTrace();
				}
				isAdminOkey = true;
				MainMenu hm = new MainMenu("Admin");
				hm.setVisible(true);
				hm.pack();
				hm.setLocationRelativeTo(null);
				hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
			} else {
				message += "Tester|10|3";
				System.out.println("===>> " + message);
				try {
					Main.toCabinet.println(message);
					System.out.println("<<=== " + Main.fromCabinet.readLine());

				} catch (UnknownHostException e) {
					System.out.println("Unknown Host...");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("IOProbleme...");
					e.printStackTrace();
				}
				Setup su = new Setup("Tester");
				su.setVisible(true);
				su.pack();
				su.setLocationRelativeTo(null);
				su.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(null, "falsche Eingabe", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {

		System.exit(0);
	}

	private void tf_login_passwordActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void tf_login_personelnumberActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JButton btn_login;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private javax.swing.JLabel lb_loginForm;
	private javax.swing.JLabel lb_login_password;
	private javax.swing.JLabel lb_login_personelnumber;
	private javax.swing.JPasswordField tf_login_password;
	private javax.swing.JTextField tf_login_personelnumber;
	private JLabel img_login;
}
