package loginregister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import objects.ClimateCabinet;
import objects.ClimateController;
import objects.Main;

import javax.swing.SwingWorker;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author user
 */

public class BurnInTester extends javax.swing.JFrame {

	static HashMap<String, ArrayList<String>> tableValues;
	int counter = 0;
	double currentTemp;
	String response;
	String actTemp = "";
	static String isAdmin;
	boolean pause = false;
	String message = "";

	class GetTemp extends SwingWorker<Void, Void> {
		Timer myTimer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				try {

					if (pause == false) {
						String message = "OPERTEMP|";
						System.out.println("===>> " + message);
						Main.toCabinet.println(message);
						response = Main.fromCabinet.readLine();
						System.out.println("<<=== " + response);
						StringTokenizer tokenizer = new StringTokenizer(response, ":");
						while (tokenizer.hasMoreTokens()) {
							actTemp = tokenizer.nextToken();
						}
					}

				} catch (UnknownHostException ex) {
					System.out.println("Unknown Host...");
					ex.printStackTrace();
				} catch (IOException ex) {
					System.out.println("IOProbleme...");
					ex.printStackTrace();
				}
				// currentTemp = climateController1.getCurrentTemp() +
				// (climateController1.getTemp() * counter);

				currentTemp = Double.parseDouble(actTemp);
				lb_awaitedTemperature.setText("SOLL Temperatur: " + climateController1.getWantedTemperature());
				lb_currentTemperature.setText("IST Temperatur: " + String.valueOf(currentTemp));
				lb_getTime.setText("verstrichene Zeit: " + (double) counter);
				if (climateController1.getWantedTemperature() == currentTemp) {
					pnlWorking.setBackground(new java.awt.Color(0, 153, 0));
					myTimer.cancel();
					lb_working.setText("Burn-IN Test ist fertig.");
					btn_continue.setVisible(true);
				}
				counter++;
				if (counter == climateController1.getSecond() + 1) {
					myTimer.cancel();
					lb_working.setText("Burn-IN Test ist fertig.");
					btn_continue.setVisible(true);
				}
			}
		};
		TimerTask taskAfterPause = new TimerTask() {

			@Override
			public void run() {
				currentTemp = climateController1.getCurrentTemp() + (climateController1.getTemp() * counter);
				lb_awaitedTemperature.setText("SOLL Temperature: " + climateController1.getWantedTemperature());
				lb_currentTemperature.setText("IST Temperatur: " + String.valueOf(currentTemp));

				if (climateController1.getWantedTemperature() == currentTemp) {
					myTimer.cancel();
					lb_working.setText("Burn-IN Test ist fertig.");
					pnlWorking.setBackground(new java.awt.Color(0, 153, 0));
					btn_continue.setVisible(true);
				}
				counter++;
				if (counter == climateController1.getSecond() + 1) {
					myTimer.cancel();
					lb_working.setText("Burn-IN Test ist fertig.");
					btn_continue.setVisible(true);
				}
			}

		};

		@Override
		protected Void doInBackground() throws Exception {
			climateController1.setTarget(new ClimateCabinet(), 40, expectedTime);

			myTimer.schedule(task, 0, 1000);
			if (climateController1.getCurrentTemp() <= climateController1.getWantedTemperature()) {
				for (int i = 0;; i++) {
					Thread.sleep(1000);

				}
			}
			return null;

		}

		public void pause() {
			myTimer.cancel();
		}

		public void resume() {
			this.myTimer = new Timer();
			this.myTimer.schedule(taskAfterPause, 0, 1000);
		}

	}

	class ProgressPercentage extends SwingWorker<Void, Void> {
		Timer myTimer1 = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				pbValue++;
				pb_temperature.setValue(pbValue);
			}

		};

		@Override
		protected Void doInBackground() throws Exception {
			double b = (climateController1.getSecond() / 50) * 1000;

			myTimer1.schedule(task, 0, (long) b);
			return null;

		}

		public void pause() {
			this.myTimer1.cancel();

		}

		public void resume() {
			this.myTimer1 = new Timer();
			double b = (climateController1.getSecond() / 50) * 1000;
			TimerTask taskAfterPause = new TimerTask() {

				@Override
				public void run() {
					pbValue++;
					pb_temperature.setValue(pbValue);

				}

			};
			this.myTimer1.schedule(taskAfterPause, 0, (long) b);
		}

	}

	GetTemp taskCurrentTemp = new GetTemp();
	public int pbValue = 0;
	public final ProgressPercentage taskPercentage = new ProgressPercentage();
	Timer timer;
	ClimateController climateController1 = new ClimateController();
	public int expectedTime = 100;

	public BurnInTester(HashMap<String, ArrayList<String>> tableValues, String isAdmin) throws InterruptedException {
		this.isAdmin = isAdmin;
		BurnInTester.tableValues = tableValues;
		initComponents();

	}

	@SuppressWarnings("unchecked")

	private void initComponents() throws InterruptedException {

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);

		pnl_title = new javax.swing.JPanel();
		lb_min = new javax.swing.JLabel();
		lb_BurnIN = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		lb_close = new javax.swing.JLabel();
		pnl_body = new javax.swing.JPanel();

		btn_cancel = new javax.swing.JButton();
		btn_cancel.setBackground(new Color(150, 40, 27));
		btn_cancel.setBorder(whiteline);

		if (isAdmin != "Admin") {
			btn_cancel.setVisible(false);
		}
		pb_temperature = new javax.swing.JProgressBar();
		UIManager.put("pbTemperature.foreground", Color.black);
		pb_temperature.setStringPainted(true);
		pb_temperature.setForeground(Color.blue);
		pb_temperature.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				ProgressPercentage taskPercentage = new ProgressPercentage();
				taskPercentage.execute();

				taskCurrentTemp.execute();

			}
		});
		pnlWorking = new javax.swing.JPanel();
		lb_working = new javax.swing.JLabel();
		lb_currentTemperature = new javax.swing.JLabel();
		lb_getTime = new javax.swing.JLabel();

		lb_getTime.setText("verstrichene Zeit: ");

		lb_timePeriod = new javax.swing.JLabel();
		lb_awaitedTemperature = new javax.swing.JLabel();
		btn_continue = new javax.swing.JButton();
		btn_continue.setBackground(new Color(80, 170, 217));
		btn_continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurnInTesterContinuation hm = new BurnInTesterContinuation(tableValues, isAdmin);
				hm.setVisible(true);
				hm.pack();
				hm.setLocationRelativeTo(null);
				hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BurnInTester.this.dispose();

			}
		});
		btn_continue.setBorder(whiteline);

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

		lb_BurnIN.setBackground(new java.awt.Color(255, 255, 255));
		lb_BurnIN.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
		lb_BurnIN.setForeground(new java.awt.Color(255, 255, 255));
		lb_BurnIN.setText("Burn-IN\r\n");

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
		pnl_title.setLayout(gl_pnl_title);
		gl_pnl_title.setHorizontalGroup(gl_pnl_title
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pnl_title.createSequentialGroup().addContainerGap()
						.addComponent(lb_BurnIN, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(86, 86, 86)
						.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		gl_pnl_title.setVerticalGroup(gl_pnl_title.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_pnl_title.createSequentialGroup()
						.addGroup(gl_pnl_title.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lb_min, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_BurnIN).addComponent(lb_close, javax.swing.GroupLayout.PREFERRED_SIZE,
										76, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pnl_body.setBackground(new java.awt.Color(52, 73, 94));
		pnl_body.addContainerListener(new java.awt.event.ContainerAdapter() {
			public void componentAdded(java.awt.event.ContainerEvent evt) {
				jPanel3ComponentAdded(evt);

			}
		});

		btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
		btn_cancel.setText("Abbrechen");
		btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnCancelMouseClicked(evt);
			}
		});
		btn_cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});

		pb_temperature.setBackground(new java.awt.Color(255, 255, 255));

		pb_temperature.addContainerListener(new java.awt.event.ContainerAdapter() {
			public void componentRemoved(java.awt.event.ContainerEvent evt) {
				componentRemoved(evt);
			}
		});
		pb_temperature.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentHidden(java.awt.event.ComponentEvent evt) {
				componentHidden(evt);
			}
		});

		lb_working.setBackground(new java.awt.Color(204, 204, 204));
		lb_working.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lb_working.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lb_working.setText("Burn- IN Test Laeuft...");
		lb_working.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				lblWorkingPropertyChange(evt);
			}
		});

		javax.swing.GroupLayout pnlWorkingLayout = new javax.swing.GroupLayout(pnlWorking);
		pnlWorkingLayout.setHorizontalGroup(pnlWorkingLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lb_working, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE));
		pnlWorkingLayout.setVerticalGroup(pnlWorkingLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lb_working, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		pnlWorking.setLayout(pnlWorkingLayout);

		lb_currentTemperature.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lb_currentTemperature.setForeground(new java.awt.Color(255, 255, 255));

		lb_getTime.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lb_getTime.setForeground(new java.awt.Color(255, 255, 255));

		lb_timePeriod.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lb_timePeriod.setForeground(new java.awt.Color(255, 255, 255));
		lb_timePeriod.setText("voraussichtliche Testdauer :" + expectedTime);

		lb_awaitedTemperature.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lb_awaitedTemperature.setForeground(new java.awt.Color(255, 255, 255));

		btn_continue.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		btn_continue.setForeground(new java.awt.Color(255, 255, 255));
		btn_continue.setText("Weiter");

		javax.swing.GroupLayout gl_pnl_body = new javax.swing.GroupLayout(pnl_body);
		gl_pnl_body.setHorizontalGroup(gl_pnl_body.createParallelGroup(Alignment.LEADING).addGroup(gl_pnl_body
				.createSequentialGroup()
				.addGroup(gl_pnl_body.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnl_body.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnl_body.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lb_timePeriod, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lb_getTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
								.addGroup(gl_pnl_body.createParallelGroup(Alignment.LEADING)
										.addComponent(lb_currentTemperature, GroupLayout.PREFERRED_SIZE, 227,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lb_awaitedTemperature, GroupLayout.PREFERRED_SIZE, 227,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28))
						.addGroup(Alignment.LEADING, gl_pnl_body.createSequentialGroup().addGap(25)
								.addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE).addComponent(
										btn_continue, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()).addComponent(pnlWorking, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addGroup(gl_pnl_body.createSequentialGroup().addContainerGap()
						.addComponent(pb_temperature, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
						.addContainerGap()));
		gl_pnl_body.setVerticalGroup(gl_pnl_body.createParallelGroup(Alignment.LEADING).addGroup(gl_pnl_body
				.createSequentialGroup().addContainerGap()
				.addComponent(
						pnlWorking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(26)
				.addGroup(gl_pnl_body.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_getTime, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_currentTemperature, GroupLayout.PREFERRED_SIZE, 26,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnl_body.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_timePeriod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_awaitedTemperature, GroupLayout.PREFERRED_SIZE, 26,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
				.addComponent(pb_temperature, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(61)
				.addGroup(gl_pnl_body.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_continue, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGap(27)));
		pnl_body.setLayout(gl_pnl_body);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnl_title, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addComponent(pnl_body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnl_title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnl_body, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	private void JlMin2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(JFrame.ICONIFIED);
	}

	private void JlClose2MouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {
		message = "STOPPING|";
		pause = true;
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
		MainMenu hm = new MainMenu("");
		hm.setVisible(true);
		hm.pack();
		hm.setLocationRelativeTo(null);
		hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jPanel3ComponentAdded(java.awt.event.ContainerEvent evt) {

	}

	private void btnContinueMouseClicked(java.awt.event.MouseEvent evt) {
		BurnInTesterContinuation hm = new BurnInTesterContinuation(tableValues, isAdmin);
		hm.setVisible(true);
		hm.pack();
		hm.setLocationRelativeTo(null);
		hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}

	private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void lblWorkingPropertyChange(java.beans.PropertyChangeEvent evt) {
		if (lb_working.getText() == "Burn-IN Test ist fertig.") {
			btn_continue.setVisible(true);
		} else {
			btn_continue.setVisible(false);
		}
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
			java.util.logging.Logger.getLogger(BurnInTester.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BurnInTester.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BurnInTester.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BurnInTester.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BurnInTester(tableValues, isAdmin).setVisible(true);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});
	}

	private javax.swing.JButton br;
	private javax.swing.JLabel lb_close;
	private javax.swing.JLabel lb_min;
	private javax.swing.JButton btn_cancel;
	private javax.swing.JButton btn_continue;
	private javax.swing.JLabel lb_BurnIN;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel pnl_title;
	private javax.swing.JPanel pnl_body;
	private javax.swing.JLabel lb_awaitedTemperature;
	private javax.swing.JLabel lb_currentTemperature;
	private javax.swing.JLabel lb_getTime;
	private javax.swing.JLabel lb_timePeriod;
	private javax.swing.JLabel lb_working;
	private javax.swing.JProgressBar pb_temperature;
	private javax.swing.JPanel pnlWorking;

}