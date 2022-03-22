/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregister;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import database.DbConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import objects.ClimateCabinet;
import objects.Controll;
import objects.Main;

import javax.swing.ImageIcon;

public class CheckIn extends javax.swing.JFrame {
	DefaultTableModel model;
	String message;
	static HashMap<String, String> slotOfDut = new HashMap<String, String>();
	HashMap<String, ArrayList<String>> savedValues = new HashMap<>();
	ArrayList<String> divideRest = new ArrayList<>();
	static String auftrag;
	static String isAdmin;

	public CheckIn(HashMap<String, String> hm, String auftrag, final String isAdmin) {
		this.isAdmin = isAdmin;
		CheckIn.auftrag = auftrag;
		CheckIn.slotOfDut = hm;

		initComponents();
		DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
		String prufling = "";
		for (String s : slotOfDut.keySet()) {
			if (slotOfDut.get(s).equals("Slot_001")) {
				prufling = s;
			}
		}
		model.addRow(new Object[] { "Slot_001", prufling, auftrag });
		divideRest.add(prufling);
		divideRest.add(auftrag);
		savedValues.put("Slot_001", divideRest);
		tb_scroll.setViewportView(tb_checkIn);
		this.setLocationRelativeTo(null);
		tf_slotNumber.setText("Slot_0");
		tf_slotNumber_1.setText("Slot_0");
		pn_body.setLayout(null);
		pn_body.add(btn_addSwitch);
		pn_body.add(lb_finish);
		pn_body.add(btn_cancel);
		pn_body.add(lb_trackingNumber);
		pn_body.add(lb_slotNumber);
		pn_body.add(btn_finish);
		pn_body.add(tf_trackingNumber);
		pn_body.add(tf_slotNumber);
		pn_body.add(btn_addOrder);
		pn_body.add(lb_minutes);
		pn_body.add(lb_time);
		pn_body.add(lb_seconds);
		pn_body.add(btn_functionTest);
		pn_body.add(scroll_table);
		pn_body.add(btn_removeExaminee);
		pn_body.add(lb_message);
		pn_body.add(tf_removeSlotExaminee);
		pn_body.add(btn_retest);
		pn_body.add(lb_trackingNumber_1);
		pn_body.add(lb_slotNumber_1);
		pn_body.add(tf_trackingNumber_1);
		pn_body.add(tf_slotNumber_1);

		lb_message_1 = new JLabel("Bitte geben Sie die Slot ein");
		lb_message_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_message_1.setForeground(Color.WHITE);
		lb_message_1.setBounds(973, 457, 205, 13);
		pn_body.add(lb_message_1);
		JTableHeader tableHeader = tb_checkIn.getTableHeader();
		Color myColor = new Color(82, 170, 217);
		tableHeader.setBackground(myColor);
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableHeader.setForeground(Color.WHITE);

		Border line = BorderFactory.createLineBorder(new Color(0, 153, 0), 3);
		scroll_table.setBorder(line);

		lb_timeBorder = new JLabel("");
		lb_timeBorder.setBounds(143, 188, 251, 85);
		Border wline = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_timeBorder.setBorder(wline);
		lb_timeBorder.setVisible(false);
		pn_body.add(lb_timeBorder);

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		btn_burnIn = new JButton("Burn in\r\n\r\n");
		btn_burnIn.setBorder(whiteline);
		btn_burnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_burnIn.setForeground(Color.WHITE);
		btn_burnIn.setBackground(new Color(220, 20, 60));
		btn_burnIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_burnIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				message = "ENDINIT|";
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
				message = "STRTPRE|25";
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

				for (int i = 1; i <= 20; i++) {
					for (int j = 0; j < 3; j++) {
						message = "PRETST|" + i;
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

				message = "ENDPRE|";
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
				BurnInTester b;
				try {
					message = "STRTBURNIN|";
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
					message = "OPERTEMP|";
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
					message = "SETTARGET|40|100|3|5";
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
					b = new BurnInTester(savedValues, isAdmin);
					b.setVisible(true);
					b.pack();
					b.setLocationRelativeTo(null);
					b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					CheckIn.this.dispose();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_burnIn.setBounds(726, 572, 237, 73);
		pn_body.add(btn_burnIn);

		btn_burnIn.setVisible(false);

	}

	@SuppressWarnings("unchecked")

	int minute;
	int seconde;
	Timer timer;
	DbConnection db = new DbConnection();
	String value = "";
	List<String[]> valuesToGetAdded = new ArrayList<String[]>();
	String[] valuesAtTable = new String[4];

	private void initComponents() {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		lb_finish = new JLabel("");
		lb_finish.setBounds(106, 356, 485, 68);
		Border wline = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);
		lb_finish.setBorder(wline);
		lb_minutes = new JLabel("0");
		lb_minutes.setBounds(200, 200, 43, 50);
		lb_minutes.setFont(new Font("Tahoma", Font.BOLD, 50));
		lb_minutes.setForeground(Color.WHITE);
		lb_minutes.setVisible(false);
		lb_time = new JLabel(":");
		lb_time.setBounds(253, 207, 30, 37);
		lb_time.setForeground(Color.WHITE);
		lb_time.setFont(new Font("Tahoma", Font.BOLD, 50));
		lb_time.setVisible(false);

		lb_seconds = new JLabel("0");
		lb_seconds.setBounds(293, 204, 76, 43);
		lb_seconds.setForeground(Color.WHITE);
		lb_seconds.setFont(new Font("Tahoma", Font.BOLD, 50));
		lb_seconds.setVisible(false);

		lb_finish.setForeground(Color.WHITE);
		lb_finish.setFont(new Font("Tahoma", Font.BOLD, 23));
		btn_functionTest = new JButton();
		btn_functionTest.setBorder(whiteline);
		btn_functionTest.setBounds(726, 668, 515, 45);
		btn_functionTest.setVisible(false);
		btn_functionTest.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btn_functionTest.setVisible(false);
				lb_trackingNumber.setVisible(false);
				lb_slotNumber.setVisible(false);
				tf_slotNumber.setVisible(false);
				tf_trackingNumber.setVisible(false);

				lb_timeBorder.setVisible(true);
				lb_minutes.setVisible(true);
				lb_time.setVisible(true);
				lb_seconds.setVisible(true);

				minute = Integer.parseInt(lb_minutes.getText());
				seconde = Integer.parseInt(lb_seconds.getText());

				timer = new Timer(1250, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (seconde == 59) {
							seconde = 0;
							minute++;
						} else {
							seconde++;
							lb_minutes.setText("" + minute);
							lb_seconds.setText("" + seconde);
						}
					}
				});
				timer.start();

				for (int i = 0; i < tb_checkIn.getRowCount(); i++) {
					try {
						value = db.istGeprüft((tb_checkIn.getModel().getValueAt(i, 0)).toString());
						tb_checkIn.getModel().setValueAt(value, i, 3);
					} catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				Border green = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);

				okControl();
				if (okControl().get("NOK") == 0) {

					lb_finish.setText("Alle Prueflinge sind OK !");
					lb_finish.setBorder(green);
					DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
					for (int i = 0; i < model.getRowCount(); i++) {
						if ((String) model.getValueAt(i, 1) != " ") {
							ClimateCabinet cc = new ClimateCabinet();
							String divide = (String) model.getValueAt(i, 1);
							String rest = (String) model.getValueAt(i, 2);
							String slot = (String) model.getValueAt(i, 0);
							String rowTh = slot.substring(6, 8);
							String message = "";
							try {
								if (!db.controlSetup(divide, rest)) {
									db.addDutToDb(divide);
									db.addOrderToDb(rest);
								}
								cc.setSlots(divide, slot);
								if (rowTh.charAt(0) == '0') {
									message = "INIT|" + rowTh.charAt(1) + "|" + divide;
								} else {
									message = "INIT|" + rowTh + "|" + divide;
								}
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
							} catch (InstantiationException | IllegalAccessException | SQLException e1) {

								e1.printStackTrace();
							}
						}

					}
					btn_burnIn.setVisible(true);
				} else {
					lb_finish.setText("   Fehlerhafte Switches erkannt !");
					DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
					while (okControl().get("NOK") != 0) {
						int removeSlot = -1;
						okControl();
						String message = JOptionPane.showInputDialog("Sie muessen die Fehlerhafte Switches loeschen!");
						for (int i = 0; i < model.getRowCount(); i++) {
							String a = (String) model.getValueAt(i, 0);
							if (a.equals(message)) {
								removeSlot = i;
								savedValues.remove(a);
							}
							if (removeSlot != -1) {
								model.setValueAt(" ", removeSlot, 0);
								model.setValueAt(" ", removeSlot, 1);
								model.setValueAt(" ", removeSlot, 2);
								model.setValueAt(" ", removeSlot, 3);
							}
						}
					}
					lb_finish.setText("  Alle Prueflinge sind OK !");

					lb_trackingNumber_1.setVisible(true);
					lb_slotNumber_1.setVisible(true);
					tf_trackingNumber_1.setVisible(true);
					tf_slotNumber_1.setVisible(true);
					btn_addSwitch.setVisible(true);
					btn_burnIn.setVisible(false);
					btn_retest.setVisible(true);

					for (int i = 0; i < model.getRowCount(); i++) {
						if ((String) model.getValueAt(i, 1) != " ") {
							ClimateCabinet cc = new ClimateCabinet();
							String divide = (String) model.getValueAt(i, 1);
							String rest = (String) model.getValueAt(i, 2);
							String slot = (String) model.getValueAt(i, 0);
							String rowTh = slot.substring(6, 8);
							String message = "";
							try {
								if (!db.controlSetup(divide, rest)) {
									db.addDutToDb(divide);
									db.addOrderToDb(rest);
								}
								cc.setSlots(divide, slot);
								if (rowTh.charAt(0) == '0') {
									message = "INIT|" + rowTh.charAt(1) + "|" + divide;
								} else {
									message = "INIT|" + rowTh + "|" + divide;
								}
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
							} catch (InstantiationException | IllegalAccessException | SQLException e1) {

								e1.printStackTrace();
							}
						}

					}
					for (int j = model.getRowCount() - 1; j >= 0; j--) {
						if (model.getValueAt(j, 0).toString().trim().length() == 0) {
							model.removeRow(j);
						}
					}
				}
			}
		});
		btn_functionTest.setText("Funktionstest");
		btn_functionTest.setForeground(Color.WHITE);
		btn_functionTest.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_functionTest.setBackground(new Color(255, 102, 0));

		lb_finish.setVisible(false);
		pn_body = new javax.swing.JPanel();
		lb_trackingNumber = new javax.swing.JLabel();
		lb_trackingNumber.setBounds(113, 75, 170, 22);
		lb_slotNumber = new javax.swing.JLabel();
		lb_slotNumber.setBounds(110, 129, 43, 22);
		tf_trackingNumber = new javax.swing.JTextField();
		tf_trackingNumber.setBounds(392, 74, 142, 31);
		tf_slotNumber = new javax.swing.JTextField();
		tf_slotNumber.setBounds(392, 127, 142, 33);
		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBounds(106, 669, 177, 45);
		btn_cancel.setBorder(whiteline);
		btn_finish = new javax.swing.JButton();
		btn_finish.setBorder(whiteline);
		btn_finish.setBounds(106, 301, 170, 45);
		btn_finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_addOrder.setVisible(false);
				btn_removeExaminee.setVisible(false);
				tf_removeSlotExaminee.setVisible(false);
				btn_finish.setVisible(false);
				lb_message_1.setVisible(false);
				lb_message.setVisible(false);
				lb_finish.setText("           Alle " + tb_checkIn.getRowCount() + " Gereate sind erfasst.");
				lb_finish.setVisible(true);
				btn_functionTest.setVisible(true);
			}
		});
		btn_addOrder = new javax.swing.JButton();
		btn_addOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_addOrder.setBorder(whiteline);
		btn_addOrder.setBounds(343, 301, 191, 45);
		scroll_table = new javax.swing.JScrollPane();
		scroll_table.setBounds(726, 73, 515, 358);
		btn_removeExaminee = new javax.swing.JButton();
		btn_removeExaminee.setBorder(whiteline);
		btn_removeExaminee.setBounds(726, 482, 205, 45);
		tf_removeSlotExaminee = new javax.swing.JTextField();
		tf_removeSlotExaminee.setBounds(973, 496, 268, 19);
		lb_message = new javax.swing.JLabel();
		lb_message.setBounds(978, 417, 123, 13);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		pn_body.setBackground(new java.awt.Color(52, 73, 94));

		lb_trackingNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lb_trackingNumber.setForeground(new java.awt.Color(255, 255, 255));
		lb_trackingNumber.setText("Trackingnummer: ");

		lb_slotNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lb_slotNumber.setForeground(new java.awt.Color(255, 255, 255));
		lb_slotNumber.setText("Slot:");

		btn_cancel.setBackground(new java.awt.Color(150, 40, 27));
		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Abbrechen");
		btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				abbrechen_buttonMouseClicked(evt);
			}
		});

		btn_finish.setBackground(new java.awt.Color(255, 102, 0));
		btn_finish.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_finish.setForeground(new java.awt.Color(255, 255, 255));
		btn_finish.setText("Fertig");
		btn_finish.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				fertig_buttonMouseClicked(evt);
			}
		});

		btn_addOrder.setBackground(new java.awt.Color(82, 170, 217));
		btn_addOrder.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_addOrder.setForeground(new java.awt.Color(255, 255, 255));
		btn_addOrder.setText("Auftrag hinzufuegen");
		btn_addOrder.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				auftrag_hinzufugenMouseClicked(evt);
			}
		});

		btn_removeExaminee.setBackground(new java.awt.Color(150, 40, 27));
		btn_removeExaminee.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_removeExaminee.setForeground(new java.awt.Color(255, 255, 255));
		btn_removeExaminee.setText("Pruefling entfernen");
		btn_removeExaminee.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				prufling_entfernen_buttonMouseClicked(evt);
			}
		});

		lb_message.setForeground(new java.awt.Color(255, 255, 255));
		lb_message.setText("Bitte geben Sie die Slot ein");

		btn_addSwitch = new JButton("Switch hinzufuegen\r\n");
		btn_addSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean isOkey = true;
				String tracking = tf_trackingNumber_1.getText();

				Controll control2 = new Controll();

				String slot = tf_slotNumber_1.getText();
				String rowTh = slot.substring(6, 8);

				if (control2.lengthControl(tracking)) {
					if (!control2.slotLengthControl(slot, rowTh)) {
						isOkey = false;
					}
				} else {
					isOkey = false;
				}

				String divide = tracking.substring(0, 18);
				String rest = tracking.substring(19, 29);

				DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();

				if (isOkey == true) {

					if (tb_checkIn.getRowCount() > 20) {
						JOptionPane.showMessageDialog(null, "Sie koennen nicht mehr als 20 hinzufuegen", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (tb_checkIn.getRowCount() == 20) {
						JOptionPane.showMessageDialog(null, "Limit : 20. Sie haben Ihre letzte Ergaenzung gemacht",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (tb_checkIn.getRowCount() == 0 && !(tb_checkIn.getRowCount() > 0)) {
						model.addRow(new Object[] { slot, divide, rest });
						divideRest.clear();
						divideRest.add(divide);
						divideRest.add(rest);
						savedValues.put(slot, divideRest);
					}

					else {
						int row = 0;
						int counter = tb_checkIn.getRowCount();
						while (row <= counter - 1) {
							if (slot.equals(String.valueOf(tb_checkIn.getValueAt(row, 0)))) {
								JOptionPane.showMessageDialog(null, "Dieser Slot existiert bereits");
								isOkey = false;
							}
							row++;
						}

						row = 0;

						while (row <= counter - 1) {
							if (divide.equals(String.valueOf(tb_checkIn.getValueAt(row, 1)))) {
								JOptionPane.showMessageDialog(null, "Dieser Bauteil existiert bereits");
								isOkey = false;
							}
							row++;
						}

						if (isOkey == true) {
							ClimateCabinet c = new ClimateCabinet();

							model.addRow(new Object[] { slot, divide, rest });

							String message = "";
							try {
								if (!db.controlSetup(divide, rest)) {
									db.addDutToDb(divide);
									db.addOrderToDb(rest);
								}
								c.setSlots(divide, slot);
								if (rowTh.charAt(0) == '0') {
									message = "INIT|" + rowTh.charAt(1) + "|" + divide;
								} else {
									message = "INIT|" + rowTh + "|" + divide;
								}
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
							} catch (InstantiationException | IllegalAccessException | SQLException e1) {

								e1.printStackTrace();
							}
							divideRest.clear();
							divideRest.add(divide);
							divideRest.add(rest);
							savedValues.put(slot, divideRest);
							c.setSlots(divide, slot);
							TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tb_checkIn.getModel());
							tb_checkIn.setRowSorter(sorter);
							List<RowSorter.SortKey> sortKeys = new ArrayList<>(20);
							sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
							sorter.setSortKeys(sortKeys);
						}
					}
				}
			}
		});
		btn_addSwitch.setBorder(whiteline);
		btn_addSwitch.setBounds(106, 602, 177, 44);
		btn_addSwitch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_addSwitch.setForeground(Color.WHITE);
		btn_addSwitch.setBackground(new Color(255, 69, 0));
		btn_addSwitch.setVisible(false);

		lb_trackingNumber_1 = new JLabel("Trackingnumber :");
		lb_trackingNumber_1.setBounds(111, 482, 148, 17);
		lb_trackingNumber_1.setForeground(Color.WHITE);
		lb_trackingNumber_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_trackingNumber_1.setVisible(false);

		lb_slotNumber_1 = new JLabel("Slot :");
		lb_slotNumber_1.setBounds(113, 535, 115, 17);
		lb_slotNumber_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_slotNumber_1.setForeground(Color.WHITE);
		lb_slotNumber_1.setVisible(false);

		tf_trackingNumber_1 = new JTextField();
		tf_trackingNumber_1.setBounds(269, 481, 136, 19);
		tf_trackingNumber_1.setColumns(10);
		tf_trackingNumber_1.setVisible(false);

		tf_slotNumber_1 = new JTextField();
		tf_slotNumber_1.setBounds(269, 536, 138, 19);
		tf_slotNumber_1.setColumns(10);
		tf_slotNumber_1.setVisible(false);

		btn_retest = new JButton("Nachtest");
		btn_retest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btn_retest.setVisible(false);
				btn_burnIn.setVisible(true);
				tf_slotNumber_1.setVisible(false);
				tf_trackingNumber_1.setVisible(false);
				btn_addSwitch.setVisible(false);
				lb_slotNumber_1.setVisible(false);
				lb_trackingNumber_1.setVisible(false);

				btn_functionTest.setVisible(false);
				lb_trackingNumber.setVisible(false);
				lb_slotNumber.setVisible(false);
				tf_slotNumber.setVisible(false);
				tf_trackingNumber.setVisible(false);

				lb_timeBorder.setVisible(true);
				lb_minutes.setVisible(true);
				lb_time.setVisible(true);
				lb_seconds.setVisible(true);

				minute = Integer.parseInt(lb_minutes.getText());
				seconde = Integer.parseInt(lb_seconds.getText());

				timer = new Timer(1250, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (seconde == 59) {
							seconde = 0;
							minute++;
						} else {
							seconde++;
							lb_minutes.setText("" + minute);
							lb_seconds.setText("" + seconde);
						}
					}
				});
				timer.start();

				for (int i = 0; i < tb_checkIn.getRowCount(); i++) {
					try {
						value = db.istGeprüft((tb_checkIn.getModel().getValueAt(i, 0)).toString());
						tb_checkIn.getModel().setValueAt(value, i, 3);
					} catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				Border green = BorderFactory.createLineBorder(new Color(0, 153, 0), 5);

				okControl();
				if (okControl().get("NOK") == 0) {

					lb_finish.setText("Alle Prueflinge sind OK !");
					lb_finish.setBorder(green);
					DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
					for (int i = 0; i < model.getRowCount(); i++) {
						if ((String) model.getValueAt(i, 1) != " ") {
							ClimateCabinet cc = new ClimateCabinet();
							String divide = (String) model.getValueAt(i, 1);
							String rest = (String) model.getValueAt(i, 2);
							String slot = (String) model.getValueAt(i, 0);
							String rowTh = slot.substring(6, 8);
							String message = "";
							try {
								if (!db.controlSetup(divide, rest)) {
									db.addDutToDb(divide);
									db.addOrderToDb(rest);
								}
								cc.setSlots(divide, slot);
								if (rowTh.charAt(0) == '0') {
									message = "INIT|" + rowTh.charAt(1) + "|" + divide;
								} else {
									message = "INIT|" + rowTh + "|" + divide;
								}
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
							} catch (InstantiationException | IllegalAccessException | SQLException e1) {

								e1.printStackTrace();
							}
						}

					}
					btn_burnIn.setVisible(true);

				} else {
					lb_finish.setText("   Fehlerhafte Switches erkannt !");
					DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
					while (okControl().get("NOK") != 0) {
						int removeSlot = -1;
						okControl();
						String message = JOptionPane.showInputDialog("Sie muessen die Fehlerhafte Switches loeschen!");
						for (int i = 0; i < model.getRowCount(); i++) {
							String a = (String) model.getValueAt(i, 0);
							if (a.equals(message)) {
								removeSlot = i;
								savedValues.remove(a);
							}
							if (removeSlot != -1) {
								model.setValueAt(" ", removeSlot, 0);
								model.setValueAt(" ", removeSlot, 1);
								model.setValueAt(" ", removeSlot, 2);
								model.setValueAt(" ", removeSlot, 3);
							}
						}
					}
					lb_finish.setText("  Alle Prueflinge sind OK !");

					lb_trackingNumber_1.setVisible(true);
					lb_slotNumber_1.setVisible(true);
					tf_trackingNumber_1.setVisible(true);
					tf_slotNumber_1.setVisible(true);
					btn_addSwitch.setVisible(true);
					btn_burnIn.setVisible(false);
					btn_retest.setVisible(true);

					for (int i = 0; i < model.getRowCount(); i++) {
						if ((String) model.getValueAt(i, 1) != " ") {
							ClimateCabinet cc = new ClimateCabinet();
							String divide = (String) model.getValueAt(i, 1);
							String rest = (String) model.getValueAt(i, 2);
							String slot = (String) model.getValueAt(i, 0);
							String rowTh = slot.substring(6, 8);
							String message = "";
							try {
								if (!db.controlSetup(divide, rest)) {
									db.addDutToDb(divide);
									db.addOrderToDb(rest);
								}
								cc.setSlots(divide, slot);
								if (rowTh.charAt(0) == '0') {
									message = "INIT|" + rowTh.charAt(1) + "|" + divide;
								} else {
									message = "INIT|" + rowTh + "|" + divide;
								}
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
							} catch (InstantiationException | IllegalAccessException | SQLException e1) {

								e1.printStackTrace();
							}
						}
					}
					for (int j = model.getRowCount() - 1; j >= 0; j--) {
						if (model.getValueAt(j, 0).toString().trim().length() == 0) {
							model.removeRow(j);
						}
					}
				}
			}
		});
		btn_retest.setVisible(false);
		btn_retest.setBorder(whiteline);

		btn_retest.setBounds(721, 603, 316, 41);
		btn_retest.setForeground(Color.WHITE);
		btn_retest.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_retest.setBackground(new Color(204, 204, 0));
		tb_scroll = new javax.swing.JScrollPane();
		scroll_table.setViewportView(tb_scroll);
		tb_checkIn = new javax.swing.JTable();

		tb_checkIn.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Slots", "Bauteil-ID", "Auftrag", "          " }));
		tb_scroll.setViewportView(tb_checkIn);

		JPanel pn_title = new JPanel();
		pn_title.setBackground(new Color(0, 153, 0));

		JLabel lb_checkIn = new JLabel();
		lb_checkIn.setBounds(35, 26, 1370, 27);
		lb_checkIn.setText("Checkin");
		lb_checkIn.setForeground(Color.WHITE);
		lb_checkIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lb_checkIn.setBackground(Color.WHITE);

		JLabel lb_min = new JLabel();
		lb_min.setBounds(1466, 0, 20, 76);
		Cursor imlec = new Cursor(Cursor.HAND_CURSOR);
		lb_min.setCursor(imlec);
		lb_min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		lb_min.setText("-");
		lb_min.setForeground(Color.WHITE);
		lb_min.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_min.setBackground(Color.WHITE);

		JPanel jPanel1_1 = new JPanel();
		jPanel1_1.setBounds(0, 82, 1542, 295);
		GroupLayout gl_jPanel1_1 = new GroupLayout(jPanel1_1);
		gl_jPanel1_1.setHorizontalGroup(gl_jPanel1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 510, Short.MAX_VALUE).addGap(0, 510, Short.MAX_VALUE));
		gl_jPanel1_1.setVerticalGroup(gl_jPanel1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 295, Short.MAX_VALUE).addGap(0, 295, Short.MAX_VALUE));
		jPanel1_1.setLayout(gl_jPanel1_1);

		JLabel lb_close = new JLabel();
		lb_close.setBounds(1504, 0, 28, 76);
		Cursor imlec_2 = new Cursor(Cursor.HAND_CURSOR);
		lb_close.setCursor(imlec_2);

		lb_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.exit(0);
			}
		});
		lb_close.setText("X");
		lb_close.setForeground(Color.WHITE);
		lb_close.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_close.setBackground(Color.WHITE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(0)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 1542, GroupLayout.PREFERRED_SIZE))
						.addComponent(pn_body, GroupLayout.PREFERRED_SIZE, 1542, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_title, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pn_body, GroupLayout.PREFERRED_SIZE, 919, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(130, Short.MAX_VALUE)));
		pn_title.setLayout(null);
		pn_title.add(lb_checkIn);
		pn_title.add(lb_min);
		pn_title.add(lb_close);
		pn_title.add(jPanel1_1);
		getContentPane().setLayout(layout);

		pack();
	}

	private void abbrechen_buttonMouseClicked(java.awt.event.MouseEvent evt) {
		MainMenu hm = new MainMenu(isAdmin);
		hm.setVisible(true);
		hm.pack();
		hm.setLocationRelativeTo(null);
		hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	private void fertig_buttonMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void auftrag_hinzufugenMouseClicked(java.awt.event.MouseEvent evt) {
		boolean isOkey = true;
		String tracking = tf_trackingNumber.getText();

		Controll control = new Controll();

		String slot = tf_slotNumber.getText();
		String rowTh = slot.substring(6, 8);

		if (control.lengthControl(tracking)) {
			if (!control.slotLengthControl(slot, rowTh)) {
				isOkey = false;
			}
		} else {
			isOkey = false;
		}

		String divide = tracking.substring(0, 18);
		String rest = tracking.substring(19, 29);

		DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();

		if (isOkey == true) {

			if (tb_checkIn.getRowCount() > 20) {
				JOptionPane.showMessageDialog(null, "Sie koennen nicht mehr als 20 hinzufuegen", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (tb_checkIn.getRowCount() == 20) {
				JOptionPane.showMessageDialog(null, "Limit : 20. Sie haben Ihre letzte Ergaenzung gemacht", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (tb_checkIn.getRowCount() == 0 && !(tb_checkIn.getRowCount() > 0)) {
				model.addRow(new Object[] { slot, divide, rest });
				divideRest.clear();
				divideRest.add(divide);
				divideRest.add(rest);
				savedValues.put(slot, divideRest);
			}

			else {
				int row = 0;
				int counter = tb_checkIn.getRowCount();
				while (row <= counter - 1) {
					if (slot.equals(String.valueOf(tb_checkIn.getValueAt(row, 0)))) {
						JOptionPane.showMessageDialog(null, "Dieser Slot existiert bereits");
						isOkey = false;
					}
					row++;
				}

				row = 0;

				while (row <= counter - 1) {
					if (divide.equals(String.valueOf(tb_checkIn.getValueAt(row, 1)))) {
						JOptionPane.showMessageDialog(null, "Dieser Bauteil existiert bereits");
						isOkey = false;
					}
					row++;
				}

				if (isOkey == true) {
					ClimateCabinet c = new ClimateCabinet();

					model.addRow(new Object[] { slot, divide, rest });
					divideRest.clear();
					divideRest.add(divide);
					divideRest.add(rest);
					savedValues.put(slot, divideRest);
					c.setSlots(divide, slot);
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tb_checkIn.getModel());
					tb_checkIn.setRowSorter(sorter);
					List<RowSorter.SortKey> sortKeys = new ArrayList<>(20);
					sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
					sorter.setSortKeys(sortKeys);
				}
			}
		}

	}// GEN-LAST:event_auftrag_hinzufugenMouseClicked

	private void prufling_entfernen_buttonMouseClicked(java.awt.event.MouseEvent evt) {
		DefaultTableModel model = (DefaultTableModel) tb_checkIn.getModel();
		String isSlotThere = tf_removeSlotExaminee.getText();
		int howManyrows = tb_checkIn.getRowCount();
		String a;
		if (howManyrows > 0) {
			int removeSlot = -1;
			for (int j = 0; j < howManyrows; j++) {
				a = (String) model.getValueAt(j, 0);
				if (a.equals(isSlotThere)) {
					removeSlot = j;
				}
			}
			if (removeSlot != -1) {
				model.removeRow(removeSlot);
				savedValues.remove(isSlotThere);
			} else {
				JOptionPane.showMessageDialog(null, "Diese Slot existiert nicht");
			}
		}

	}

	public HashMap<String, Integer> okControl() {

		HashMap<String, Integer> okOrNok = new HashMap<String, Integer>();
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

	public HashMap<Integer, String> cc() {
		HashMap<Integer, String> okOrNok = new HashMap<Integer, String>();

		for (int i = 0; i < tb_checkIn.getRowCount(); i++) {

			if (tb_checkIn.getModel().getValueAt(i, 3).toString() == "NOK") {
				okOrNok.put(i, "NOK");
			} else {
				okOrNok.put(i, "OK");
			}

		}

		return okOrNok;
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new CheckIn(slotOfDut, auftrag, isAdmin).setVisible(true);
			}
		});
	}

	private javax.swing.JButton btn_cancel;
	private javax.swing.JButton btn_addOrder;
	private javax.swing.JTable tb_checkIn;
	private javax.swing.JButton btn_finish;
	private javax.swing.JLabel lb_slotNumber;
	private javax.swing.JLabel lb_message;
	private javax.swing.JPanel pn_body;
	private javax.swing.JScrollPane scroll_table;
	private javax.swing.JScrollPane tb_scroll;
	private javax.swing.JButton btn_removeExaminee;
	private javax.swing.JTextField tf_removeSlotExaminee;
	private javax.swing.JTextField tf_slotNumber;
	private javax.swing.JLabel lb_trackingNumber;
	private javax.swing.JTextField tf_trackingNumber;
	private JTextField tf_trackingNumber_1;
	private JTextField tf_slotNumber_1;
	private JButton btn_retest;
	private JButton btn_addSwitch;
	private JLabel lb_finish;
	private JLabel lb_minutes;
	private JLabel lb_time;
	private JLabel lb_seconds;
	private JButton btn_functionTest;
	private JLabel lb_trackingNumber_1;
	private JLabel lb_slotNumber_1;
	private JLabel lb_message_1;
	private JLabel clock_icon;
	private JLabel lb_timeBorder;
	private JButton btn_burnIn;
}
