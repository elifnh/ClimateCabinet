/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

public class Initialization extends javax.swing.JFrame {

	static HashMap<String, String> slots = new HashMap<String, String>();
	static String auftrag;
	static String isAdmin;

	public Initialization(HashMap<String, String> hm, String auftrag, String isAdmin) {
		this.slots = hm;
		this.auftrag = auftrag;
		this.isAdmin = isAdmin;
		System.out.println(slots);
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		pn_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_initialization = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		pn_body = new javax.swing.JPanel();
		btn_initialization = new javax.swing.JButton();
		Border white = BorderFactory.createLineBorder(Color.white);
		btn_initialization.setBounds(63, 82, 347, 82);
		btn_initialization.setBorder(white);
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBorder(white);
		btn_cancel.setBounds(28, 284, 122, 45);

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
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(Alignment.LEADING).addGroup(gl_pn_title
				.createSequentialGroup()
				.addGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_title.createSequentialGroup().addContainerGap().addComponent(lb_initialization,
								GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
				.addGap(102).addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_initialization)
								.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		pn_title.setLayout(gl_pn_title);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		btn_initialization.setBackground(new java.awt.Color(82, 170, 217));
		btn_initialization.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btn_initialization.setForeground(new java.awt.Color(255, 255, 255));
		btn_initialization.setText("Beginn Initialisierung");
		btn_initialization.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				begin_init_buttonMouseClicked(evt);
			}
		});
		btn_initialization.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				begin_init_buttonActionPerformed(evt);
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
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)));
		pn_body.setLayout(null);
		pn_body.add(btn_cancel);
		pn_body.add(btn_initialization);
		getContentPane().setLayout(layout);

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

	private void begin_init_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		InitializationWithTimer init2 = new InitializationWithTimer(slots, auftrag, isAdmin);
		init2.setVisible(true);
		init2.pack();
		init2.setLocationRelativeTo(null);
		init2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	private void begin_init_buttonMouseClicked(java.awt.event.MouseEvent evt) {

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
			java.util.logging.Logger.getLogger(Initialization.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Initialization.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Initialization.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Initialization.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Initialization(slots, auftrag, isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JButton btn_initialization;
	private javax.swing.JLabel lb_initialization;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
}
