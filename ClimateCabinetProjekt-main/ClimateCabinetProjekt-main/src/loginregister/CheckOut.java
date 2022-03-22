/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CheckOut extends javax.swing.JFrame {
	static String isAdmin;

	public CheckOut(String isAdmin) {
		this.isAdmin = isAdmin;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		pn_body = new javax.swing.JPanel();
		lb_message = new javax.swing.JLabel();
		Border white = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_message.setBorder(white);
		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		btn_finish = new javax.swing.JButton();
		btn_finish.setBorder(whiteline);
		pn_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_checkOut = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		lb_message.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_message.setForeground(new java.awt.Color(255, 255, 255));
		lb_message.setText("                 Alle Bauteile ausgechekt");

		btn_finish.setBackground(new java.awt.Color(150, 40, 27));
		btn_finish.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
		btn_finish.setForeground(new java.awt.Color(255, 255, 255));
		btn_finish.setText("Ende");
		btn_finish.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				abbrechen_buttonMouseClicked(evt);
			}
		});

		img_test = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/test.png")).getImage();
		img_test.setIcon(new ImageIcon(img));

		javax.swing.GroupLayout gl_pn_body = new javax.swing.GroupLayout(pn_body);
		gl_pn_body.setHorizontalGroup(gl_pn_body.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pn_body.createSequentialGroup().addGroup(gl_pn_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_body.createSequentialGroup().addGap(54)
								.addComponent(img_test, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addGap(31)
								.addComponent(lb_message, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pn_body.createSequentialGroup().addGap(341).addComponent(btn_finish,
								GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(165, Short.MAX_VALUE)));
		gl_pn_body.setVerticalGroup(gl_pn_body.createParallelGroup(Alignment.TRAILING).addGroup(gl_pn_body
				.createSequentialGroup().addContainerGap(129, Short.MAX_VALUE)
				.addComponent(lb_message, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE).addGap(100)
				.addComponent(btn_finish, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE).addGap(91))
				.addGroup(Alignment.LEADING,
						gl_pn_body.createSequentialGroup().addGap(92)
								.addComponent(img_test, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(262, Short.MAX_VALUE)));
		pn_body.setLayout(gl_pn_body);

		pn_title.setBackground(new java.awt.Color(0, 153, 0));

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

		lb_checkOut.setBackground(new java.awt.Color(255, 255, 255));
		lb_checkOut.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_checkOut.setForeground(new java.awt.Color(255, 255, 255));
		lb_checkOut.setText("Checkout");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 295, Short.MAX_VALUE));

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

		javax.swing.GroupLayout gl_pn_title = new javax.swing.GroupLayout(pn_title);
		pn_title.setLayout(gl_pn_title);
		gl_pn_title
				.setHorizontalGroup(
						gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(gl_pn_title.createSequentialGroup().addContainerGap()
										.addComponent(lb_checkOut, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(86, 86, 86)
										.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_checkOut).addComponent(lb_close,
										javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pn_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pn_body,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void abbrechen_buttonMouseClicked(java.awt.event.MouseEvent evt) {
		MainMenu hm = new MainMenu(isAdmin);
		hm.setVisible(true);
		hm.pack();
		hm.setLocationRelativeTo(null);
		hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CheckOut(isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_finish;
	private javax.swing.JLabel lb_message;
	private javax.swing.JLabel lb_checkOut;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private JLabel img_test;

}