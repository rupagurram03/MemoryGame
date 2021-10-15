package memoryGame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class MainGameBoard extends JFrame {

	// Variables declaration
	private JButton ExitButton;
	private JLabel MainMenuLabel;
	private JButton Start4x4Button;
	private JButton Start6x6Button;

	GameBoard1 gameOne = new GameBoard1();
	GameBoard2 gameTwo = new GameBoard2();

	public MainGameBoard() {
		initComponents();
	}

	private void initComponents() {

		MainMenuLabel = new JLabel();
		Start4x4Button = new JButton();
		Start6x6Button = new JButton();
		ExitButton = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Get ready to play the Memory Game");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		MainMenuLabel
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memoryGame/memory-game-share-image.png")));

		Start4x4Button.setText("Start 4x4 Game");
		Start4x4Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Start4x4ButtonActionPerformed(evt);
			}
		});

		Start6x6Button.setText("Start 6x6 Game");
		Start6x6Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Start6x6ButtonActionPerformed(evt);
			}
		});

		ExitButton.setFont(new java.awt.Font("Dialog", 0, 18));
		ExitButton.setText("Quit");
		ExitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(MainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(Start4x4Button, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addComponent(Start6x6Button, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(29, 29, 29)
								.addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Start4x4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Start6x6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(78, 78, 78))
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(MainMenuLabel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}

	// Play the original 4x4 Tile game.
	private void Start4x4ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		gameOne.setVisible(true);
	}

	// Quit the whole program
	private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		int quitOption = JOptionPane.showConfirmDialog(
    			rootPane,
    		    "Would you like to QUIT?",
    		    "Are you sure?",
    		    JOptionPane.YES_NO_OPTION);

		if (quitOption == 0) {
			System.exit(0);
		}
	}

	// Play the new 6x6 Tile Game
	private void Start6x6ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		gameTwo.setVisible(true);
	}

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainGameBoard().setVisible(true);
			}
		});
	}
}