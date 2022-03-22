/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.GroupLayout.Alignment;

import objects.Main;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

public class MainMenu extends javax.swing.JFrame {

	static String adminOrTester;

	public MainMenu(String adminOrTester) {
		this.adminOrTester = adminOrTester;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		pn_title = new javax.swing.JPanel();
		lb_mainMenu = new javax.swing.JLabel();
		lb_close = new javax.swing.JLabel();
		lb_min = new javax.swing.JLabel();
		pn_body = new javax.swing.JPanel();
		btn_test = new javax.swing.JButton();
		btn_test.setBorder(whiteline);
		btn_manualOperation = new javax.swing.JButton();
		if (adminOrTester == "Tester") {
			btn_manualOperation.setVisible(false);
		}
		btn_manualOperation.setBorder(whiteline);
		btn_manualOperation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManualOperations hb = new ManualOperations(adminOrTester);
				hb.setVisible(true);
				hb.pack();
				hb.setLocationRelativeTo(null);
				hb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MainMenu.this.dispose();
			}
		});
		btn_end = new javax.swing.JButton();
		btn_end.setBorder(whiteline);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_title.setBackground(new java.awt.Color(0, 153, 0));

		lb_mainMenu.setBackground(new java.awt.Color(255, 255, 255));
		lb_mainMenu.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_mainMenu.setForeground(new java.awt.Color(255, 255, 255));
		lb_mainMenu.setText("Hauptmenue");

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

		javax.swing.GroupLayout gl_pn_title = new javax.swing.GroupLayout(pn_title);
		pn_title.setLayout(gl_pn_title);
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup().addContainerGap()
						.addComponent(lb_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 193,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
						.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14).addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lb_mainMenu)))
						.addGap(0, 4, Short.MAX_VALUE)));

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		btn_test.setBackground(new java.awt.Color(82, 179, 217));
		btn_test.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_test.setForeground(new java.awt.Color(255, 255, 255));
		btn_test.setText("Testbetrieb");
		btn_test.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				testbetriebMouseClicked(evt);
			}
		});

		btn_manualOperation.setBackground(new java.awt.Color(82, 179, 217));
		btn_manualOperation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_manualOperation.setForeground(new java.awt.Color(255, 255, 255));
		btn_manualOperation.setText("Handbetrieb");

		btn_end.setBackground(new java.awt.Color(150, 40, 27));
		btn_end.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_end.setForeground(new java.awt.Color(255, 255, 255));
		btn_end.setText("Programm beenden");
		btn_end.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				program_beendenMouseClicked(evt);
			}
		});
		btn_end.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				program_beendenActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout gl_pn_body = new javax.swing.GroupLayout(pn_body);
		gl_pn_body.setHorizontalGroup(gl_pn_body.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pn_body.createSequentialGroup().addGap(142)
						.addGroup(gl_pn_body.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_manualOperation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 129,
										Short.MAX_VALUE)
								.addComponent(btn_test, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 129,
										Short.MAX_VALUE))
						.addGap(163))
				.addGroup(Alignment.LEADING,
						gl_pn_body.createSequentialGroup().addGap(115)
								.addComponent(btn_end, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(125, Short.MAX_VALUE)));
		gl_pn_body.setVerticalGroup(gl_pn_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_body.createSequentialGroup().addGap(61)
						.addComponent(btn_test, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(39)
						.addComponent(btn_manualOperation, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE).addGap(85)
						.addComponent(btn_end, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE).addGap(43)));
		pn_body.setLayout(gl_pn_body);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pn_body, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_JlClose2MouseClicked
		System.exit(0);
	}// GEN-LAST:event_JlClose2MouseClicked

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_JlMin2MouseClicked
		this.setState(JFrame.ICONIFIED);
	}// GEN-LAST:event_JlMin2MouseClicked

	private void program_beendenMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_program_beendenMouseClicked
		String message = "STOP|";
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
		System.exit(0);
	}

	private void testbetriebMouseClicked(java.awt.event.MouseEvent evt) {
		Setup setup = new Setup(adminOrTester);
		setup.setVisible(true);
		setup.pack();
		setup.setLocationRelativeTo(null);
		setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	private void program_beendenActionPerformed(java.awt.event.ActionEvent evt) {

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu(adminOrTester).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_manualOperation;
	private javax.swing.JLabel lb_mainMenu;
	private javax.swing.JPanel pn_body;
	private javax.swing.JPanel pn_title;
	private javax.swing.JButton btn_end;
	private javax.swing.JButton btn_test;
}
