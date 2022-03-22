/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

import database.DbConnection;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CabinetSelection extends javax.swing.JFrame {
	DbConnection connection = new DbConnection();
	ArrayList<Integer> clima = new ArrayList<Integer>();

	public CabinetSelection() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	public void Auswahl() throws InstantiationException, IllegalAccessException, SQLException {

		clima = connection.schrankAuswahl();
		for (int i = 0; i < clima.size(); i++) {
			cmbx_selectCabinet.addItem(String.valueOf(clima.get(i)));
		}
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		pn_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_selectCabinet = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		pn_body = new javax.swing.JPanel();
		cmbx_selectCabinet = new javax.swing.JComboBox<>();

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

		lb_selectCabinet.setBackground(new java.awt.Color(255, 255, 255));
		lb_selectCabinet.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_selectCabinet.setForeground(new java.awt.Color(255, 255, 255));
		lb_selectCabinet.setText("Schrank Auswahl");

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
		gl_pn_title.setHorizontalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup().addContainerGap()
						.addComponent(lb_selectCabinet, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addGap(86, 86, 86)
						.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		gl_pn_title.setVerticalGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pn_title.createSequentialGroup()
						.addGroup(gl_pn_title.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_selectCabinet).addComponent(lb_close,
										javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		cmbx_selectCabinet.setBackground(new java.awt.Color(102, 102, 102));
		cmbx_selectCabinet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		btn_continue = new JButton("Weiter");
		btn_continue.setBackground(new Color(82, 179, 217));
		btn_continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login();
				l.setVisible(true);
				CabinetSelection.this.dispose();
			}
		});
		btn_continue.setForeground(Color.WHITE);
		btn_continue.setFont(new Font("Tahoma", Font.BOLD, 14));

		javax.swing.GroupLayout gl_pn_body = new javax.swing.GroupLayout(pn_body);
		gl_pn_body
				.setHorizontalGroup(gl_pn_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_body.createSequentialGroup().addGap(113)
								.addComponent(cmbx_selectCabinet, GroupLayout.PREFERRED_SIZE, 183,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(25, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING, gl_pn_body.createSequentialGroup()
										.addContainerGap(261, Short.MAX_VALUE).addComponent(btn_continue,
												GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addGap(57)));
		gl_pn_body.setVerticalGroup(gl_pn_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_body.createSequentialGroup().addGap(75)
						.addComponent(cmbx_selectCabinet, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(59)
						.addComponent(btn_continue, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(28, Short.MAX_VALUE)));
		pn_body.setLayout(gl_pn_body);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(pn_body, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
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
			java.util.logging.Logger.getLogger(CabinetSelection.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CabinetSelection.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CabinetSelection.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CabinetSelection.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CabinetSelection().setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JComboBox<String> cmbx_selectCabinet;
	private javax.swing.JLabel lb_selectCabinet;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private JButton btn_continue;

}
