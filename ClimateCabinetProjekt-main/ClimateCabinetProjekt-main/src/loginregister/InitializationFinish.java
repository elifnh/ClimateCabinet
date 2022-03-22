/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class InitializationFinish extends javax.swing.JFrame {

	static HashMap<String, String> slots = new HashMap<String, String>();
	static String auftrag;
	static String isAdmin;

	public InitializationFinish(HashMap<String, String> hm, String auftrag, String isAdmin) {
		this.auftrag = auftrag;
		this.slots = hm;
		this.isAdmin = isAdmin;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		pn_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_initialization = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		pn_body = new javax.swing.JPanel();
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBounds(198, 285, 141, 51);
		lb_message = new javax.swing.JLabel();
		lb_message.setBounds(50, 165, 449, 72);
		Border wline = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_message.setBorder(wline);
		btn_checkIn = new javax.swing.JButton();
		Border white = BorderFactory.createLineBorder(Color.white);
		btn_checkIn.setBorder(white);
		btn_cancel.setBorder(white);
		btn_checkIn.setBounds(198, 47, 193, 81);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

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

		lb_initialization.setBackground(new java.awt.Color(255, 255, 255));
		lb_initialization.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_initialization.setForeground(new java.awt.Color(255, 255, 255));
		lb_initialization.setText("Initialisierung");

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
										.addComponent(lb_initialization, javax.swing.GroupLayout.DEFAULT_SIZE,
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
								.addComponent(lb_initialization).addComponent(lb_close,
										javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		btn_cancel.setBackground(new java.awt.Color(150, 40, 27));
		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Abbrechen");
		btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				abbrechen_buttonMouseClicked(evt);
			}
		});

		lb_message.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_message.setForeground(Color.WHITE);
		lb_message.setText("   Initialisierungsvorgang beendet !");

		btn_checkIn.setBackground(new java.awt.Color(82, 170, 217));
		btn_checkIn.setFont(new Font("Tahoma", Font.BOLD, 17)); // NOI18N
		btn_checkIn.setForeground(new java.awt.Color(255, 255, 255));
		btn_checkIn.setText("Check in");
		btn_checkIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				check_in_buttonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		pn_body.setLayout(null);
		pn_body.add(btn_cancel);
		pn_body.add(btn_checkIn);
		pn_body.add(lb_message);

		img_testing = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/test.png")).getImage();
		img_testing.setIcon(new ImageIcon(img));
		img_testing.setBounds(32, 10, 292, 133);
		pn_body.add(img_testing);

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

	private void check_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {

		CheckIn checkin = new CheckIn(slots, auftrag, isAdmin);
		checkin.setVisible(true);
		checkin.pack();
		checkin.setLocationRelativeTo(null);
		checkin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InitializationFinish(slots, auftrag, isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JButton btn_checkIn;
	private javax.swing.JLabel lb_message;
	private javax.swing.JLabel lb_initialization;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private javax.swing.JScrollPane jScrollPane1;
	private JLabel img_testing;
}
