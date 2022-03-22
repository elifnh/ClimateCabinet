/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import database.DbConnection;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManualOperations extends javax.swing.JFrame {

	static String isAdmin;

	public ManualOperations(String isAdmin) {
		this.isAdmin = isAdmin;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		pn_title = new javax.swing.JPanel();
		lb_manual = new javax.swing.JLabel();
		lb_manual.setBounds(24, 26, 325, 27);
		lb_close = new javax.swing.JLabel();
		lb_close.setBounds(408, 0, 31, 76);
		lb_min = new javax.swing.JLabel();
		lb_min.setBounds(378, 0, 20, 76);
		pn_body = new javax.swing.JPanel();
		tf_surname = new javax.swing.JTextField();
		tf_surname.setBounds(194, 155, 207, 23);
		tf_password = new javax.swing.JPasswordField();
		tf_password.setBounds(194, 240, 207, 23);
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBorder(whiteline);
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu haupt = new MainMenu("");
				haupt.setVisible(true);
				haupt.pack();
				haupt.setLocationRelativeTo(null);
				haupt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ManualOperations.this.dispose();
			}
		});

		final JComboBox<String> cmbx_status = new JComboBox<String>();
		cmbx_status.setBounds(194, 322, 207, 19);
		cmbx_status.setModel(new DefaultComboBoxModel(new String[] { "active", "inactive" }));

		btn_cancel.setBounds(157, 489, 136, 41);
		btn_register = new javax.swing.JButton();
		btn_register.setBorder(whiteline);
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String vorname = tf_name.getText();
				String nachname = tf_surname.getText();
				int personelnum = Integer.parseInt(tf_personalNumber.getText());
				char[] pass = tf_password.getPassword();
				String str = String.valueOf(pass);
				String rolles = cmbx_role.getSelectedItem().toString();
				String statuses = cmbx_status.getSelectedItem().toString();

				DbConnection db = new DbConnection();
				try {

					String result = db.addUser(vorname, nachname, str, personelnum, rolles, statuses);

					JOptionPane.showMessageDialog(null, result);

				} catch (InstantiationException | IllegalAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_register.setBounds(10, 416, 125, 41);
		lb_password = new javax.swing.JLabel();
		lb_password.setBounds(23, 241, 144, 20);
		lb_surname = new javax.swing.JLabel();
		lb_surname.setBounds(23, 156, 144, 20);
		lb_personalNumber = new javax.swing.JLabel();
		lb_personalNumber.setBounds(23, 197, 163, 20);
		lb_name = new javax.swing.JLabel();
		lb_name.setBounds(23, 115, 144, 20);
		tf_personalNumber = new javax.swing.JTextField();

		tf_personalNumber.setBounds(194, 196, 207, 23);
		tf_name = new javax.swing.JTextField();
		tf_name.setBounds(194, 114, 207, 23);
		cmbx_role = new javax.swing.JComboBox<>();
		cmbx_role.setBounds(194, 284, 207, 19);
		lb_role = new javax.swing.JLabel();
		lb_role.setBounds(23, 281, 144, 20);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_title.setBackground(new java.awt.Color(0, 153, 0));

		lb_manual.setBackground(new java.awt.Color(255, 255, 255));
		lb_manual.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_manual.setForeground(new java.awt.Color(255, 255, 255));
		lb_manual.setText("Handbetrieb");

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

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		tf_surname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		tf_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		btn_cancel.setBackground(new java.awt.Color(150, 40, 27));
		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Stornieren");

		btn_register.setBackground(new java.awt.Color(82, 179, 217));
		btn_register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_register.setForeground(new java.awt.Color(255, 255, 255));
		btn_register.setText("Hinzufuegen");
		btn_register.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ButtonRegisterActionPerformed(evt);
			}
		});

		lb_password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_password.setForeground(new java.awt.Color(240, 240, 240));
		lb_password.setText("Passwort:");

		lb_surname.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_surname.setForeground(new java.awt.Color(240, 240, 240));
		lb_surname.setText("Nachname:");

		lb_personalNumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_personalNumber.setForeground(new java.awt.Color(240, 240, 240));
		lb_personalNumber.setText("Personalnummer *:");

		lb_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_name.setForeground(new java.awt.Color(240, 240, 240));
		lb_name.setText("Vorname:");

		tf_personalNumber.setFont(new java.awt.Font("Tahoma", 0, 14));

		tf_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		cmbx_role.setModel(new DefaultComboBoxModel(new String[] { "admin", "tester" }));

		lb_role.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		lb_role.setForeground(new java.awt.Color(240, 240, 240));
		lb_role.setText("Rolle:");

		lb_status = new JLabel("Status :");
		lb_status.setBounds(23, 321, 62, 17);
		lb_status.setForeground(Color.WHITE);
		lb_status.setFont(new Font("Tahoma", Font.BOLD, 16));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pn_title, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
				.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)));
		pn_body.setLayout(null);
		pn_body.add(lb_status);
		pn_body.add(cmbx_status);
		pn_body.add(lb_surname);
		pn_body.add(lb_password);
		pn_body.add(lb_name);
		pn_body.add(lb_personalNumber);
		pn_body.add(tf_name);
		pn_body.add(tf_surname);
		pn_body.add(tf_personalNumber);
		pn_body.add(tf_password);
		pn_body.add(lb_role);
		pn_body.add(cmbx_role);
		pn_body.add(btn_cancel);
		pn_body.add(btn_register);
		getContentPane().setLayout(layout);
		pn_title.setLayout(null);
		pn_title.add(lb_manual);
		pn_title.add(lb_min);
		pn_title.add(lb_close);

		lb_message = new JLabel("* Transaktionen ohne Personalnummer werden nicht akzeptiert !");
		lb_message.setForeground(new Color(255, 255, 255));
		lb_message.setFont(new Font("Tahoma", Font.BOLD, 10));
		lb_message.setBounds(6, 612, 395, 13);
		pn_body.add(lb_message);

		btn_edit = new JButton("Verarbeiten");
		btn_edit.setBorder(whiteline);
		btn_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a = String.valueOf(tf_personalNumber.getText()).trim();
				if (a.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bitte geben Sie die Personalnummer ein !", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DbConnection dbcon = new DbConnection();
					try {
						if (dbcon.isRegistered(Integer.parseInt(a))) {
							JOptionPane.showMessageDialog(null,
									"Geben Sie das Informationen ein, das Sie aendern moechten");
							String[] infos2 = new String[5];
							infos2 = dbcon.autoComplete(Integer.parseInt(a));
							tf_name.setText(infos2[0]);
							tf_surname.setText(infos2[1]);
							tf_password.setText(infos2[2]);
							cmbx_role.setSelectedItem(infos2[3]);
							cmbx_status.setSelectedItem(infos2[4]);
						}
					} catch (NumberFormatException | InstantiationException | IllegalAccessException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "es existiert nicht  !", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btn_edit.setForeground(Color.WHITE);
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_edit.setBackground(new Color(46, 139, 87));
		btn_edit.setBounds(157, 416, 136, 41);
		pn_body.add(btn_edit);

		btn_save = new JButton("Speichern");
		btn_save.setBorder(whiteline);
		btn_save.setBackground(new Color(60, 179, 113));
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DbConnection dbcon = new DbConnection();
				try {

					dbcon.changeInfos(tf_name.getText(), tf_surname.getText(),
							Integer.parseInt(tf_personalNumber.getText()), String.valueOf(tf_password.getPassword()),
							cmbx_role.getSelectedItem().toString(), cmbx_status.getSelectedItem().toString());

				} catch (NumberFormatException | InstantiationException | IllegalAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "es existiert nicht !", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btn_save.setForeground(new Color(255, 255, 255));
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_save.setBounds(303, 417, 136, 41);
		pn_body.add(btn_save);

		pack();
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {

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
			java.util.logging.Logger.getLogger(ManualOperations.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ManualOperations.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ManualOperations.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ManualOperations.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ManualOperations(isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JButton btn_register;
	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JComboBox<String> cmbx_role;
	private javax.swing.JLabel lb_name;
	private javax.swing.JLabel lb_role;
	private javax.swing.JLabel lb_manual;
	private javax.swing.JLabel lb_password;
	private javax.swing.JLabel lb_surname;
	private javax.swing.JLabel lb_personalNumber;
	private javax.swing.JPanel pn_title;
	private javax.swing.JPanel pn_body;
	private javax.swing.JPasswordField tf_password;
	private javax.swing.JTextField tf_surname;
	private javax.swing.JTextField tf_personalNumber;
	private javax.swing.JTextField tf_name;
	private JLabel lb_status;
	private JLabel lb_message;
	private JButton btn_edit;
	private JButton btn_save;
}
