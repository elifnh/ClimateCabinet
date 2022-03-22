/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.util.HashMap;

public class InitializationWithTimer extends javax.swing.JFrame {

	static HashMap<String, String> slots = new HashMap<String, String>();
	static String auftrag;
	static String isAdmin;

	Timer timer;
	int min;
	int sec;

	public InitializationWithTimer(HashMap<String, String> hm, String auftrag, String isAdmin) {
		this.auftrag = auftrag;
		this.slots = hm;
		this.isAdmin = isAdmin;
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
		lb_message = new javax.swing.JLabel();
		lb_message.setBounds(38, 42, 416, 65);
		Border wline = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_message.setBorder(wline);

		lb_minutes = new javax.swing.JLabel();
		lb_minutes.setBounds(218, 169, 70, 44);
		lb_seconds = new javax.swing.JLabel();
		lb_seconds.setBounds(322, 169, 92, 44);
		lb_time = new javax.swing.JLabel();
		lb_time.setBounds(294, 169, 34, 44);

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		btn_startInýt = new javax.swing.JButton();
		btn_startInýt.setBorder(whiteline);
		btn_startInýt.setBounds(184, 305, 123, 57);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_title.setBackground(new java.awt.Color(0, 153, 0));
		pn_title.setForeground(new java.awt.Color(255, 255, 255));

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
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pn_title.createSequentialGroup().addGap(36)
						.addComponent(lb_initialization, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE).addGap(60)
						.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_initialization))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		pn_title.setLayout(gl_pn_title);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));
		pn_body.setForeground(new java.awt.Color(255, 255, 255));

		lb_message.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_message.setForeground(Color.WHITE);
		lb_message.setText("   Countdown fuer Initialisierung");

		lb_minutes.setFont(new Font("Tahoma", Font.BOLD, 50)); // NOI18N
		lb_minutes.setForeground(new java.awt.Color(255, 255, 255));
		lb_minutes.setText("05");

		lb_seconds.setFont(new Font("Tahoma", Font.BOLD, 50)); // NOI18N
		lb_seconds.setForeground(new java.awt.Color(255, 255, 255));
		lb_seconds.setText("00");

		lb_time.setFont(new Font("Tahoma", Font.BOLD, 50)); // NOI18N
		lb_time.setForeground(new java.awt.Color(255, 255, 255));
		lb_time.setText(":");

		btn_startInýt.setBackground(new java.awt.Color(82, 179, 217));
		btn_startInýt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_startInýt.setForeground(new java.awt.Color(255, 255, 255));
		btn_startInýt.setText("Beginn");
		btn_startInýt.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				begin_initMouseClicked(evt);
			}
		});

		img_timer = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/clock.jpeg")).getImage();
		img_timer.setIcon(new ImageIcon(img));
		img_timer.setBounds(38, 131, 177, 121);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		pn_body.setLayout(null);
		pn_body.add(img_timer);
		pn_body.add(lb_message);
		pn_body.add(btn_startInýt);
		pn_body.add(lb_minutes);
		pn_body.add(lb_time);
		pn_body.add(lb_seconds);
		pack();
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void begin_initMouseClicked(java.awt.event.MouseEvent evt) {
		btn_startInýt.setVisible(false);
		min = Integer.parseInt(lb_minutes.getText());
		sec = Integer.parseInt(lb_seconds.getText());

		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sec == 0) {
					sec = 60;
					min--;
				}
				if (min < 0) {

					min = 0;
					sec = 0;
					timer.stop();
					JOptionPane.showMessageDialog(rootPane, "Die Zeit ist um", "Hat gestoppt", 0);
					InitializationFinish init = new InitializationFinish(slots, auftrag, isAdmin);
					init.setVisible(true);
					InitializationWithTimer.this.dispose();
				} else {
					sec--;
					lb_minutes.setText("" + min);
					lb_seconds.setText("" + sec);
				}
			}
		});
		timer.start();
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
			java.util.logging.Logger.getLogger(InitializationWithTimer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InitializationWithTimer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InitializationWithTimer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InitializationWithTimer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InitializationWithTimer(slots, auftrag, isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_startInýt;
	private javax.swing.JLabel lb_message;
	private javax.swing.JLabel lb_initialization;
	private javax.swing.JLabel lb_time;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private javax.swing.JLabel lb_minutes;
	private javax.swing.JLabel lb_seconds;
	private JLabel img_timer;

}
