/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import objects.Main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JScrollPane;
import javax.swing.SortOrder;
import javax.swing.JButton;

public class BurnInTesterContinuation extends javax.swing.JFrame {

	DefaultTableModel model;
	String message;
	static HashMap<String, ArrayList<String>> slotOf = new HashMap<String, ArrayList<String>>();
	static String isAdmin;

	HashMap<String, Integer> okOrNok = new HashMap<String, Integer>();

	public HashMap<String, Integer> okControl2() {

		okOrNok.put("NOK", 0);
		okOrNok.put("OK", 0);
		for (int i = 0; i < tb_checkIn.getRowCount(); i++) {

			if (tb_checkIn.getModel().getValueAt(i, 3).toString() == "NOK") {

				okOrNok.put("NOK", okOrNok.get("NOK") + 1);
			} else {
				okOrNok.put("OK", okOrNok.get("OK") + 1);
			}
		}
		return okOrNok;
	}

	public BurnInTesterContinuation(HashMap<String, ArrayList<String>> hm, String isAdmin) {

		BurnInTesterContinuation.slotOf = hm;
		this.isAdmin = isAdmin;
		initComponents();

		tb_checkIn = new javax.swing.JTable();
		tb_checkIn.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Slots", "Bauteil-ID", "Auftrag", "   " }));
		model = (DefaultTableModel) tb_checkIn.getModel();
		ArrayList<String> keys = new ArrayList<String>();

		for (String key : hm.keySet()) {
			keys.add(key);
		}

		for (int i = 0; i < keys.size(); i++) {
			String k = keys.get(i);
			ArrayList<String> deger = new ArrayList<>();
			deger = hm.get(k);
			model.addRow(new Object[] { k, deger.get(0), deger.get(1), "OK" });
		}

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tb_checkIn.getModel());
		tb_checkIn.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(20);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		Random random = new Random();

		int maksimum = (tb_checkIn.getRowCount()) - 1;
		int randomSayi = random.nextInt(maksimum);

		HashSet<Integer> satirlar = new HashSet<Integer>();

		for (int i = 0; i < randomSayi; i++) {

			int randomSayi2 = random.nextInt(maksimum);
			satirlar.add(randomSayi2);
		}
		for (int i = 0; i < tb_checkIn.getRowCount(); i++) {
			if (satirlar.contains(i)) {
				tb_checkIn.getModel().setValueAt("NOK", i, 3);
			}
		}
		this.setLocationRelativeTo(null);

		lb_notOkay = new JLabel();
		lb_notOkay.setText(" Bitte loeschen Sie Slots mit NOK ");
		Border wline = BorderFactory.createLineBorder(new Color(255, 59, 59), 5);
		lb_notOkay.setBorder(wline);
		lb_notOkay.setForeground(Color.WHITE);
		lb_notOkay.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_notOkay.setBounds(10, 53, 478, 100);
		lb_notOkay.setVisible(false);
		pnl_body.add(lb_notOkay);

		img_false = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cross.png")).getImage();
		img_false.setIcon(new ImageIcon(img));
		img_false.setBounds(406, 25, 96, 121);
		img_false.setVisible(false);
		pnl_body.add(img_false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 41, 488, 412);
		pnl_body.add(scrollPane);
		tb_scroll_checkIn = new javax.swing.JScrollPane();
		scrollPane.setViewportView(tb_scroll_checkIn);

		Border line = BorderFactory.createLineBorder(new Color(0, 153, 0), 3);
		tb_scroll_checkIn.setBorder(line);
		tb_scroll_checkIn.setViewportView(tb_checkIn);

		pnl_body.add(btn_controlAgain);
		JTableHeader header = tb_checkIn.getTableHeader();
		header.setForeground(Color.black);
		header.setBackground(Color.white);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jSpinner1 = new javax.swing.JSpinner();
		pnl_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_functionCheck = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		pnl_body = new javax.swing.JPanel();
		lb_allRight = new javax.swing.JLabel();
		lb_allRight.setVisible(false);
		Border wline = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_allRight.setBorder(wline);
		lb_allRight.setBounds(10, 484, 478, 100);

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		btn_check = new javax.swing.JButton();
		btn_check.setBorder(whiteline);
		btn_check.setBounds(530, 492, 500, 40);
		btn_check.setVisible(false);
		btn_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				message = "STRTPING|25";
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
				for (int maxMinsWait = 0; maxMinsWait < 3; maxMinsWait++) {
					for (int i = 1; i <= 20; i++) {
						for (int j = 0; j < 3; j++) {
							message = "PING|" + i;
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
						}
					}
				}
				message = "STOPPING";
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
				CheckOut hm = new CheckOut(isAdmin);
				hm.setVisible(true);
				hm.pack();
				hm.setLocationRelativeTo(null);
				hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BurnInTesterContinuation.this.dispose();

			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pnl_title.setBackground(new java.awt.Color(0, 153, 0));

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

		lb_functionCheck.setBackground(new java.awt.Color(255, 255, 255));
		lb_functionCheck.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_functionCheck.setForeground(new java.awt.Color(255, 255, 255));
		lb_functionCheck.setText("Funktionscheck");

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

		javax.swing.GroupLayout gl_pnl_title = new javax.swing.GroupLayout(pnl_title);
		gl_pnl_title.setHorizontalGroup(gl_pnl_title.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnl_title.createSequentialGroup().addGap(29)
						.addComponent(lb_functionCheck, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE).addGap(67)
						.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE));
		gl_pnl_title.setVerticalGroup(gl_pnl_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnl_title.createSequentialGroup()
						.addGroup(gl_pnl_title.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_min, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_close, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_functionCheck))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		pnl_title.setLayout(gl_pnl_title);

		pnl_body.setBackground(new java.awt.Color(52, 73, 94));

		lb_allRight.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lb_allRight.setForeground(new java.awt.Color(255, 255, 255));
		lb_allRight.setText(" Alle Prueflinge sind in Ordnung ");

		btn_check.setBackground(new java.awt.Color(82, 170, 217));
		btn_check.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btn_check.setForeground(Color.WHITE);
		btn_check.setText("Alle i.O Produkte auschecken");

		img_tick = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/tick.png")).getImage();
		img_tick.setIcon(new ImageIcon(img));
		img_tick.setBounds(377, 476, 111, 80);
		img_tick.setIcon(new ImageIcon("C:\\Users\\pelin\\OneDrive\\Masa\u00FCst\u00FC\\tick (1).png"));
		img_tick.setVisible(false);

		btn_controlAgain = new JButton("Bitte Nochmal Ueberpruefen Sie");
		btn_controlAgain.setBorder(whiteline);
		btn_controlAgain.setForeground(Color.WHITE);
		btn_controlAgain.setBackground(new Color(220, 20, 60));
		btn_controlAgain.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_controlAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dm = (DefaultTableModel) tb_checkIn.getModel();
				if (okControl2().get("NOK") == 0) {

					btn_check.setVisible(true);
					lb_allRight.setVisible(true);
					img_tick.setVisible(true);

				}

				else {
					while (okControl2().get("NOK") != 0) {

						lb_notOkay.setVisible(true);
						img_false.setVisible(true);
						btn_check.setVisible(false);
						lb_allRight.setVisible(false);
						img_tick.setVisible(false);

						okControl2();

						String message = JOptionPane.showInputDialog("Sie muessen die Fehlerhafte Switches loeschen!");

						int removeSlot = -1;
						for (int i = 0; i < dm.getRowCount(); i++) {
							String satir = dm.getValueAt(i, 0).toString();
							if (satir.equals(message)) {
								removeSlot = i;
							}
							if (removeSlot != -1) {
								okOrNok.put("NOK", okOrNok.get("NOK") - 1);
								dm.setValueAt(" ", removeSlot, 0);
								dm.setValueAt(" ", removeSlot, 1);
								dm.setValueAt(" ", removeSlot, 2);
								dm.setValueAt(" ", removeSlot, 3);
							}

						}

					}
					lb_allRight.setVisible(true);
					img_tick.setVisible(true);
					btn_check.setVisible(true);
					img_false.setVisible(false);
					lb_notOkay.setVisible(false);
				}

				for (int j = dm.getRowCount() - 1; j >= 0; j--) {
					if (dm.getValueAt(j, 0).toString().trim().length() == 0) {
						dm.removeRow(j);
					}
				}
			}

		});
		btn_controlAgain.setBounds(90, 271, 296, 72);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnl_title, GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnl_body, GroupLayout.PREFERRED_SIZE, 1053, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnl_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnl_body, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		pnl_body.setLayout(null);
		pnl_body.add(lb_allRight);
		pnl_body.add(img_tick);
		pnl_body.add(btn_check);

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
			java.util.logging.Logger.getLogger(BurnInTesterContinuation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BurnInTesterContinuation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BurnInTesterContinuation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BurnInTesterContinuation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BurnInTesterContinuation(slotOf, isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	public javax.swing.JTable tb_checkIn;
	private javax.swing.JButton btn_check;
	private javax.swing.JLabel lb_allRight;
	private javax.swing.JLabel lb_functionCheck;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pnl_title;
	private javax.swing.JPanel pnl_body;
	private javax.swing.JScrollPane tb_scroll_checkIn;
	private javax.swing.JSpinner jSpinner1;
	private JLabel img_tick;
	private JLabel lb_notOkay;
	private JLabel img_false;
	private JButton btn_controlAgain;
}
