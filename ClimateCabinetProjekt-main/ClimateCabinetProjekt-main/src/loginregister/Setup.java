/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import objects.ClimateCabinet;
import objects.Controll;
import objects.Main;
import objects.Slot;

import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import database.DbConnection;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class Setup extends javax.swing.JFrame {

	String message;
	String prufling;
	String auftrag;
	DbConnection dConnection = new DbConnection();

	static String isAdmin;

	public Setup(String isAdmin) {
		this.isAdmin = isAdmin;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		pn_title = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		lb_min = new javax.swing.JLabel();
		lb_setup = new javax.swing.JLabel();
		pn_body = new javax.swing.JPanel();
		lb_examineeNumber = new javax.swing.JLabel();
		lb_examineeNumber.setBounds(28, 65, 161, 20);
		lb_trackingNumber = new javax.swing.JLabel();
		lb_trackingNumber.setBounds(28, 132, 148, 20);
		tf_examineeNumber = new javax.swing.JTextField();
		tf_examineeNumber.setBounds(236, 64, 179, 27);
		tf_trackingNumber = new javax.swing.JTextField();
		tf_trackingNumber.setBounds(236, 131, 179, 27);
		btn_continue = new javax.swing.JButton();
		btn_continue.setBorder(whiteline);
		btn_continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_continue.setBounds(80, 262, 129, 54);
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBorder(whiteline);
		btn_cancel.setBounds(260, 263, 129, 54);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_title.setBackground(new java.awt.Color(0, 153, 0));

		lb_close.setBackground(new java.awt.Color(255, 255, 255));
		lb_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_close.setForeground(new java.awt.Color(255, 255, 255));
		lb_close.setText("X");
		lb_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lb_close.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JlClose2MouseClicked(evt);
			}
		});

		lb_min.setBackground(new java.awt.Color(255, 255, 255));
		lb_min.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_min.setForeground(new java.awt.Color(255, 255, 255));
		lb_min.setText("-");
		lb_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lb_min.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JlMin2MouseClicked(evt);
			}
		});

		lb_setup.setBackground(new java.awt.Color(255, 255, 255));
		lb_setup.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_setup.setForeground(new java.awt.Color(255, 255, 255));
		lb_setup.setText("Setup");

		javax.swing.GroupLayout gl_pn_title = new javax.swing.GroupLayout(pn_title);
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pn_title.createSequentialGroup().addGap(20)
						.addComponent(lb_setup, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
						.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(14)
						.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
								.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pn_title.createSequentialGroup().addGap(24).addComponent(lb_setup)))
						.addContainerGap(72, Short.MAX_VALUE)));
		pn_title.setLayout(gl_pn_title);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		lb_examineeNumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_examineeNumber.setForeground(new java.awt.Color(255, 255, 255));
		lb_examineeNumber.setText("Prueflingsnummer: ");

		lb_trackingNumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_trackingNumber.setForeground(new java.awt.Color(255, 255, 255));
		lb_trackingNumber.setText("Auftragsnummer: ");

		btn_continue.setBackground(new java.awt.Color(82, 170, 217));
		btn_continue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_continue.setForeground(new java.awt.Color(255, 255, 255));
		btn_continue.setText("Weiter");
		btn_continue.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				weiter1_buttonMouseClicked(evt);
			}
		});

		btn_cancel.setBackground(new java.awt.Color(150, 40, 27));
		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Abbrechen");
		btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				abbrechen_buttonMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		pn_body.setLayout(null);
		pn_body.add(lb_examineeNumber);
		pn_body.add(lb_trackingNumber);
		pn_body.add(tf_trackingNumber);
		pn_body.add(tf_examineeNumber);
		pn_body.add(btn_continue);
		pn_body.add(btn_cancel);

		pack();
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void abbrechen_buttonMouseClicked(java.awt.event.MouseEvent evt) {
		MainMenu hm = new MainMenu(isAdmin);
		hm.setVisible(true);
		hm.pack();
		hm.setLocationRelativeTo(null);
		hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	Controll ctrl = new Controll();

	private void weiter1_buttonMouseClicked(java.awt.event.MouseEvent evt) {
		String slot = "Slot_001";
		Controll c = new Controll();
		DbConnection db = new DbConnection();
		ClimateCabinet cc = new ClimateCabinet();
		Slot slotClass = new Slot();
		prufling = tf_examineeNumber.getText();
		auftrag = tf_trackingNumber.getText();
		try {
			if (c.dutLengthControl(prufling) && c.auftragControl(auftrag)) {
				if (!db.controlSetup(prufling, auftrag)) {
					db.addDutToDb(prufling);
					db.addOrderToDb(auftrag);
				}
				cc.setSlots(prufling, slot);
				slotClass.setOrderOfSlots(slot, auftrag);
				message = "INIT|1|" + prufling;
				System.out.println("===>> " + message);
				try {
					Main.toCabinet.println(message);
					System.out.println("<<=== " + Main.fromCabinet.readLine());
				} catch (UnknownHostException ex) {
					System.out.println("Unknown Host...");
					ex.printStackTrace();
				} catch (IOException ex) {
					System.out.println("IOProbleme...");
					ex.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "falsche Eingabe");
			}
		} catch (InstantiationException | IllegalAccessException | SQLException e1) {

			e1.printStackTrace();
		}
		Initialization init = new Initialization(cc.getSlots(), auftrag, isAdmin);
		init.setVisible(true);
		init.pack();
		init.setLocationRelativeTo(null);
		init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();

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
			java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Setup(isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JLabel lb_examineeNumber;
	private javax.swing.JLabel lb_trackingNumber;
	private javax.swing.JLabel lb_setup;
	private javax.swing.JPanel pn_body;
	private javax.swing.JPanel pn_title;
	private javax.swing.JTextField tf_trackingNumber;
	private javax.swing.JTextField tf_examineeNumber;
	private javax.swing.JButton btn_continue;
}
