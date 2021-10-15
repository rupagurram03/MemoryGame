package memoryGame;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GameBoard2 extends JFrame {
	
	// Variables declaration
    private JButton QuitButton;
    private JTextField ScoreScreen;
    private JLabel ScoreScreenLabel;
    private JButton Tile11;
    private JButton Tile12;
    private JButton Tile13;
    private JButton Tile14;
    private JButton Tile15;
    private JButton Tile16;
    private JButton Tile21;
    private JButton Tile22;
    private JButton Tile23;
    private JButton Tile24;
    private JButton Tile25;
    private JButton Tile26;
    private JButton Tile31;
    private JButton Tile32;
    private JButton Tile33;
    private JButton Tile34;
    private JButton Tile35;
    private JButton Tile36;
    private JButton Tile41;
    private JButton Tile42;
    private JButton Tile43;
    private JButton Tile44;
    private JButton Tile45;
    private JButton Tile46;
    private JButton Tile51;
    private JButton Tile52;
    private JButton Tile53;
    private JButton Tile54;
    private JButton Tile55;
    private JButton Tile56;
    private JButton Tile61;
    private JButton Tile62;
    private JButton Tile63;
    private JButton Tile64;
    private JButton Tile65;
    private JButton Tile66;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem resetBoardMenuItem;
    private JButton startGameButton;

    TileControl tileControl = new TileControl();

    ImageIcon Blank     = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/blankTile.png"));
    ImageIcon Circle    = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Circle.png"));
    ImageIcon Cross     = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Cross.png"));
    ImageIcon Diamond   = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Diamond.png"));
    ImageIcon Dice      = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Dice.png"));
    ImageIcon Donut     = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Donut.png"));
    ImageIcon Eclipse   = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Eclipse.png"));
    ImageIcon Eclipse2  = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Eclipse2.png"));
    ImageIcon Grapes    = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Grapes.png"));
    ImageIcon Heart     = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Heart.png"));
    ImageIcon L         = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/L.png"));
    ImageIcon Rectangle = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Rectangle.png"));
    ImageIcon Snowflake = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Snowflake.png"));
    ImageIcon SqDonut   = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/SqDonut.png"));
    ImageIcon Square    = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Square.png"));
    ImageIcon Star      = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Star.png"));
    ImageIcon Tear      = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Tear.png"));
    ImageIcon Triangle  = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/Triangle.png"));
    ImageIcon X         = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/shapes/X.png"));
    ImageIcon WIN       = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/win-loss/WIN.png"));
    ImageIcon LOSS      = new javax.swing.ImageIcon(getClass().getResource("/memoryGame/win-loss/LOSS.png"));
    
    int count = 0;                              //1 for first tile flipped, 2 for second.  if 2, check match.
    int ID_Guess1 = 100, ID_Guess2 = 100;       //the locations of the 2 tiles the user guessed.  if !match, remove icons at these 2 locations.
    int type_Guess1, type_Guess2;               //the ShapeCodes for the 2 guesses.  used for testing a match. 
    boolean match;                              //catches the result from testMatch sub.
    int score;                                  //saves the player's score
    String sScore;                              //to be sent to the label.
    int PrevID_Guess1;                          //these 2 are used to store the 2 tiles from the LAST matching, to know which (locations) to 
    int PrevID_Guess2;                          //return to blanks when a new matching has started.
    
    public GameBoard2() {
        initComponents();
    }

    private void initComponents() {
        ScoreScreenLabel = new JLabel();
        ScoreScreen = new JTextField();
        startGameButton = new JButton();
        Tile12 = new JButton();
        Tile13 = new JButton();
        Tile14 = new JButton();
        Tile15 = new JButton();
        Tile11 = new JButton();
        Tile16 = new JButton();
        Tile22 = new JButton();
        Tile26 = new JButton();
        Tile23 = new JButton();
        Tile24 = new JButton();
        Tile25 = new JButton();
        Tile21 = new JButton();
        Tile32 = new JButton();
        Tile36 = new JButton();
        Tile33 = new JButton();
        Tile34 = new JButton();
        Tile35 = new JButton();
        Tile31 = new JButton();
        Tile42 = new JButton();
        Tile46 = new JButton();
        Tile43 = new JButton();
        Tile44 = new JButton();
        Tile45 = new JButton();
        Tile41 = new JButton();
        Tile52 = new JButton();
        Tile56 = new JButton();
        Tile53 = new JButton();
        Tile54 = new JButton();
        Tile55 = new JButton();
        Tile51 = new JButton();
        Tile62 = new JButton();
        Tile66 = new JButton();
        Tile63 = new JButton();
        Tile64 = new JButton();
        Tile65 = new JButton();
        Tile61 = new JButton();
        QuitButton = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu2 = new JMenu();
        resetBoardMenuItem = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("6x6 Memory Game Board");

        ScoreScreenLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        ScoreScreenLabel.setText("SCORE:");

        ScoreScreen.setEditable(false);
        ScoreScreen.setBackground(new java.awt.Color(204, 204, 255));
        ScoreScreen.setFont(new java.awt.Font("Monospace", 0, 24));
        ScoreScreen.setText("0");
        ScoreScreen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ScoreScreen.setEnabled(false);
        ScoreScreen.setFocusable(false);

        startGameButton.setText("START");
        startGameButton.setToolTipText("");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        Tile12.setEnabled(false);
        Tile12.setFocusable(false);
        Tile12.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile12.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile12.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile12ActionPerformed(evt);
            }
        });

        Tile13.setEnabled(false);
        Tile13.setFocusable(false);
        Tile13.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile13.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile13.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile13ActionPerformed(evt);
            }
        });

        Tile14.setEnabled(false);
        Tile14.setFocusable(false);
        Tile14.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile14.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile14.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile14ActionPerformed(evt);
            }
        });

        Tile15.setEnabled(false);
        Tile15.setFocusable(false);
        Tile15.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile15.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile15.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile15ActionPerformed(evt);
            }
        });

        Tile11.setEnabled(false);
        Tile11.setFocusable(false);
        Tile11.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile11.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile11.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile11ActionPerformed(evt);
            }
        });

        Tile16.setEnabled(false);
        Tile16.setFocusable(false);
        Tile16.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile16.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile16.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile16ActionPerformed(evt);
            }
        });

        Tile22.setEnabled(false);
        Tile22.setFocusable(false);
        Tile22.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile22.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile22.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile22ActionPerformed(evt);
            }
        });

        Tile26.setEnabled(false);
        Tile26.setFocusable(false);
        Tile26.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile26.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile26.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile26ActionPerformed(evt);
            }
        });

        Tile23.setEnabled(false);
        Tile23.setFocusable(false);
        Tile23.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile23.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile23.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile23ActionPerformed(evt);
            }
        });

        Tile24.setEnabled(false);
        Tile24.setFocusable(false);
        Tile24.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile24.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile24.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile24ActionPerformed(evt);
            }
        });

        Tile25.setEnabled(false);
        Tile25.setFocusable(false);
        Tile25.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile25.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile25.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile25ActionPerformed(evt);
            }
        });

        Tile21.setEnabled(false);
        Tile21.setFocusable(false);
        Tile21.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile21.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile21.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile21ActionPerformed(evt);
            }
        });

        Tile32.setEnabled(false);
        Tile32.setFocusable(false);
        Tile32.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile32.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile32.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile32ActionPerformed(evt);
            }
        });

        Tile36.setEnabled(false);
        Tile36.setFocusable(false);
        Tile36.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile36.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile36.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile36ActionPerformed(evt);
            }
        });

        Tile33.setEnabled(false);
        Tile33.setFocusable(false);
        Tile33.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile33.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile33.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile33ActionPerformed(evt);
            }
        });

        Tile34.setEnabled(false);
        Tile34.setFocusable(false);
        Tile34.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile34.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile34.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile34ActionPerformed(evt);
            }
        });

        Tile35.setEnabled(false);
        Tile35.setFocusable(false);
        Tile35.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile35.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile35.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile35ActionPerformed(evt);
            }
        });

        Tile31.setEnabled(false);
        Tile31.setFocusable(false);
        Tile31.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile31.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile31.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile31ActionPerformed(evt);
            }
        });

        Tile42.setEnabled(false);
        Tile42.setFocusable(false);
        Tile42.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile42.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile42.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile42ActionPerformed(evt);
            }
        });

        Tile46.setEnabled(false);
        Tile46.setFocusable(false);
        Tile46.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile46.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile46.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile46ActionPerformed(evt);
            }
        });

        Tile43.setEnabled(false);
        Tile43.setFocusable(false);
        Tile43.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile43.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile43.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile43ActionPerformed(evt);
            }
        });

        Tile44.setEnabled(false);
        Tile44.setFocusable(false);
        Tile44.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile44.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile44.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile44ActionPerformed(evt);
            }
        });

        Tile45.setEnabled(false);
        Tile45.setFocusable(false);
        Tile45.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile45.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile45.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile45ActionPerformed(evt);
            }
        });

        Tile41.setEnabled(false);
        Tile41.setFocusable(false);
        Tile41.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile41.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile41.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile41ActionPerformed(evt);
            }
        });

        Tile52.setEnabled(false);
        Tile52.setFocusable(false);
        Tile52.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile52.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile52.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile52ActionPerformed(evt);
            }
        });

        Tile56.setEnabled(false);
        Tile56.setFocusable(false);
        Tile56.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile56.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile56.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile56ActionPerformed(evt);
            }
        });

        Tile53.setEnabled(false);
        Tile53.setFocusable(false);
        Tile53.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile53.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile53.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile53ActionPerformed(evt);
            }
        });

        Tile54.setEnabled(false);
        Tile54.setFocusable(false);
        Tile54.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile54.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile54.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile54ActionPerformed(evt);
            }
        });

        Tile55.setEnabled(false);
        Tile55.setFocusable(false);
        Tile55.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile55.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile55.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile55ActionPerformed(evt);
            }
        });

        Tile51.setEnabled(false);
        Tile51.setFocusable(false);
        Tile51.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile51.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile51.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile51ActionPerformed(evt);
            }
        });

        Tile62.setEnabled(false);
        Tile62.setFocusable(false);
        Tile62.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile62.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile62.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile62ActionPerformed(evt);
            }
        });

        Tile66.setEnabled(false);
        Tile66.setFocusable(false);
        Tile66.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile66.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile66.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile66ActionPerformed(evt);
            }
        });

        Tile63.setEnabled(false);
        Tile63.setFocusable(false);
        Tile63.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile63.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile63.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile63ActionPerformed(evt);
            }
        });

        Tile64.setEnabled(false);
        Tile64.setFocusable(false);
        Tile64.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile64.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile64.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile64ActionPerformed(evt);
            }
        });

        Tile65.setEnabled(false);
        Tile65.setFocusable(false);
        Tile65.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile65.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile65.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile65ActionPerformed(evt);
            }
        });

        Tile61.setEnabled(false);
        Tile61.setFocusable(false);
        Tile61.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile61.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile61.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile61ActionPerformed(evt);
            }
        });

        QuitButton.setText("QUIT");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        jMenu2.setText("Game");

        resetBoardMenuItem.setText("Reset Board");
        resetBoardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBoardMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(resetBoardMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ScoreScreenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ScoreScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(startGameButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    )))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile61, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile62, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile63, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile64, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile65, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile66, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile45, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile46, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile51, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile52, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile53, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile54, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile55, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tile56, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScoreScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScoreScreenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                ))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tile15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tile11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile46, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile45, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile56, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile52, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile53, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile55, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile54, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile51, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile66, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile62, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile63, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile65, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile64, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile61, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }

    //start the game
    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
       
        PrevID_Guess1 = 100;
        PrevID_Guess2 = 100;
        ID_Guess1 = 100;
        ID_Guess2 = 100;
        match = false;
        count = 0;
        score = 0;

        ScoreScreen.setText(Integer.toString(score));

        //Re-Enable the buttons.
        Tile11.setEnabled(true);
        Tile12.setEnabled(true);
        Tile13.setEnabled(true);
        Tile14.setEnabled(true);
        Tile15.setEnabled(true);
        Tile16.setEnabled(true);
        Tile21.setEnabled(true);
        Tile22.setEnabled(true);
        Tile23.setEnabled(true);
        Tile24.setEnabled(true);
        Tile25.setEnabled(true);
        Tile26.setEnabled(true);
        Tile31.setEnabled(true);
        Tile32.setEnabled(true);
        Tile33.setEnabled(true);
        Tile34.setEnabled(true);
        Tile35.setEnabled(true);
        Tile36.setEnabled(true);
        Tile41.setEnabled(true);
        Tile42.setEnabled(true);
        Tile43.setEnabled(true);
        Tile44.setEnabled(true);
        Tile45.setEnabled(true);
        Tile46.setEnabled(true);
        Tile51.setEnabled(true);
        Tile52.setEnabled(true);
        Tile53.setEnabled(true);
        Tile54.setEnabled(true);
        Tile55.setEnabled(true);
        Tile56.setEnabled(true);
        Tile61.setEnabled(true);
        Tile62.setEnabled(true);
        Tile63.setEnabled(true);
        Tile64.setEnabled(true);
        Tile65.setEnabled(true);
        Tile66.setEnabled(true);

        //Set the icons to be Blank.
        wipeBoard();

        //generate random #'s and assign them to shapes as IDs.
        tileControl.initShuffle6x6Tiles();
        for (int i = 0; i<= 35; i++){
            
            int type = tileControl.get6x6TileType(i);
        }
        //let the user see the board for a second.  Then they match by memory.
        flashShapes();
    }

    //desc="Reset the board as if it had never been opened, and then close it.  doesn't quit program."
    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int quitOption = JOptionPane.showConfirmDialog(
    			rootPane,
    		    "Would you like to QUIT?",
    		    "Are you sure?",
    		    JOptionPane.YES_NO_OPTION);

		if (quitOption == 0) {
			resetBoardMenuItemActionPerformed(evt);
	        this.dispose();
		}
	}

    //Tile 1,1 | ID 0 - Press
    private void Tile11ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 0;
        int type;
                
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }
    
    //Tile 1,2 | ID 1 - Press
    private void Tile12ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 1;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 1,3 | ID 2 - Press
    private void Tile13ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 2;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 1,4 | ID 3 - Press
    private void Tile14ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 3;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 1,5 | ID 4 - Press
    private void Tile15ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 4;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 1,6 | ID 5 - Press
    private void Tile16ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 5;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,1 | ID 6 - Press
    private void Tile21ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 6;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,2 | ID 7 - Press
    private void Tile22ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 7;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,3 | ID 8 - Press
    private void Tile23ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 8;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,4 | ID 9 - Press
    private void Tile24ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 9;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,5 | ID 10 - Press
    private void Tile25ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 10;
        int type;
        
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 2,6 | ID 11 - Press
    private void Tile26ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 11;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,1 | ID 12 - Press
    private void Tile31ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 12;
        int type;
     
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,2 | ID 13 - Press
    private void Tile32ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 13;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,3 | ID 14 - Press
    private void Tile33ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 14;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,4 | ID 15 - Press
    private void Tile34ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 15;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,5 | ID 16 - Press
    private void Tile35ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 16;
        int type;
    
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 3,6 | ID 17 - Press
    private void Tile36ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 17;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,1 | ID 18 - Press
    private void Tile41ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 18;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,2 | ID 19 - Press
    private void Tile42ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 19;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,3 | ID 20 - Press
    private void Tile43ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 20;
        int type;
     
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,4 | ID 21 - Press
    private void Tile44ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 21;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,5 | ID 22 - Press
    private void Tile45ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 22;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 4,6 | ID 23 - Press
    private void Tile46ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 23;
        int type;
    
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type); 
    }
    
    //Tile 5,1 | ID 24 - Press
    private void Tile51ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 24;
        int type;
  
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 5,2 | ID 25 - Press
    private void Tile52ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 25;
        int type;
         
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 5,3 | ID 26 - Press
    private void Tile53ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 26;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 5,4 | ID 27 - Press
    private void Tile54ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 27;
        int type;
        
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 5,5 | ID 28 - Press
    private void Tile55ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 28;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //TIle 5,6 | ID 29 - Press
    private void Tile56ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 29;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,1 | ID 30 - Press
    private void Tile61ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 30;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,2 | ID 31 - Press
    private void Tile62ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 31;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,3 | ID 32 - Press
    private void Tile63ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 32;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,4 | ID 33 - Press
    private void Tile64ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 33;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,5 | ID 34 - Press
    private void Tile65ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 34;
        int type;
      
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //Tile 6,6 | ID 35 - Press
    private void Tile66ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 35;
        int type;
       
        type = tileControl.get6x6TileType(ID);
        buttonPress(ID, type);
    }

    //resets the board, and internal values.  will end a game prematurely.
    private void resetBoardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        wipeBoard();
        PrevID_Guess1 = 100;
        PrevID_Guess2 = 100;
        ID_Guess1 = 100;
        ID_Guess2 = 100;
        match = false;
        count = 0;
        score = 0;
        sScore = "0";
        ScoreScreen.setText(sScore);
        
        buttonEnabledSwitch(false, 0);
        buttonEnabledSwitch(false, 1);
        buttonEnabledSwitch(false, 2);
        buttonEnabledSwitch(false, 3);
        buttonEnabledSwitch(false, 4);
        buttonEnabledSwitch(false, 5);
        buttonEnabledSwitch(false, 6);
        buttonEnabledSwitch(false, 7);
        buttonEnabledSwitch(false, 8);
        buttonEnabledSwitch(false, 9);
        buttonEnabledSwitch(false, 10);
        buttonEnabledSwitch(false, 11);
        buttonEnabledSwitch(false, 12);
        buttonEnabledSwitch(false, 13);
        buttonEnabledSwitch(false, 14);
        buttonEnabledSwitch(false, 15);
        buttonEnabledSwitch(false, 16);
        buttonEnabledSwitch(false, 17);
        buttonEnabledSwitch(false, 18);
        buttonEnabledSwitch(false, 19);
        buttonEnabledSwitch(false, 20);
        buttonEnabledSwitch(false, 21);
        buttonEnabledSwitch(false, 22);
        buttonEnabledSwitch(false, 23);
        buttonEnabledSwitch(false, 24);
        buttonEnabledSwitch(false, 25);
        buttonEnabledSwitch(false, 26);
        buttonEnabledSwitch(false, 27);
        buttonEnabledSwitch(false, 28);
        buttonEnabledSwitch(false, 29);
        buttonEnabledSwitch(false, 30);
        buttonEnabledSwitch(false, 31);
        buttonEnabledSwitch(false, 32);
        buttonEnabledSwitch(false, 33);
        buttonEnabledSwitch(false, 34);
        buttonEnabledSwitch(false, 35);
        
    }

    // will display an icon on the button based on the shape_code that the button asks for prior to calling this sub.
    private void showTileShape(int ID, int type){
        ImageIcon shape = new javax.swing.ImageIcon();
        
        ArrayList<ImageIcon> shapes = new ArrayList();
        shapes.add(Circle);
        shapes.add(Cross);
        shapes.add(Diamond);
        shapes.add(Dice);
        shapes.add(Donut);
        shapes.add(Eclipse);
        shapes.add(Eclipse2);
        shapes.add(Grapes);
        shapes.add(Heart);
        shapes.add(L);
        shapes.add(Rectangle);
        shapes.add(Snowflake);
        shapes.add(SqDonut);
        shapes.add(Square);
        shapes.add(Star);
        shapes.add(Tear);
        shapes.add(Triangle);
        shapes.add(X);
        
        //Flip tile based on ID (location).
        switch(ID){      
            case 0:
                Tile11.setIcon(shapes.get(type));
                break;
            case 1:
                Tile12.setIcon(shapes.get(type));
                break;
            case 2:
                Tile13.setIcon(shapes.get(type));
                break;
            case 3:
                Tile14.setIcon(shapes.get(type));
                break;
            case 4:
                Tile15.setIcon(shapes.get(type));
                break;
            case 5:
                Tile16.setIcon(shapes.get(type));
                break;
            case 6:
                Tile21.setIcon(shapes.get(type));
                break;
            case 7:
                Tile22.setIcon(shapes.get(type));
                break;
            case 8:
                Tile23.setIcon(shapes.get(type));
                break;
            case 9:
                Tile24.setIcon(shapes.get(type));
                break;
            case 10:
                Tile25.setIcon(shapes.get(type));
                break;
            case 11:
                Tile26.setIcon(shapes.get(type));
                break;
            case 12:
                Tile31.setIcon(shapes.get(type));
                break;
            case 13:
                Tile32.setIcon(shapes.get(type));
                break;
            case 14:
                Tile33.setIcon(shapes.get(type));
                break;
            case 15:
                Tile34.setIcon(shapes.get(type));
                break;
            case 16:
                Tile35.setIcon(shapes.get(type));
                break;
            case 17:
                Tile36.setIcon(shapes.get(type));
                break;
            case 18:
                Tile41.setIcon(shapes.get(type));
                break;
            case 19:
                Tile42.setIcon(shapes.get(type));
                break;
            case 20:
                Tile43.setIcon(shapes.get(type));
                break;
            case 21:
                Tile44.setIcon(shapes.get(type));
                break;
            case 22:
                Tile45.setIcon(shapes.get(type));
                break;
            case 23:
                Tile46.setIcon(shapes.get(type));
                break;
            case 24:
                Tile51.setIcon(shapes.get(type));
                break;
            case 25:
                Tile52.setIcon(shapes.get(type));
                break;
            case 26:
                Tile53.setIcon(shapes.get(type));
                break;
            case 27:
                Tile54.setIcon(shapes.get(type));
                break;
            case 28:
                Tile55.setIcon(shapes.get(type));
                break;
            case 29:
                Tile56.setIcon(shapes.get(type));
                break;
            case 30:
                Tile61.setIcon(shapes.get(type));
                break;
            case 31:
                Tile62.setIcon(shapes.get(type));
                break;
            case 32:
                Tile63.setIcon(shapes.get(type));
                break;
            case 33:
                Tile64.setIcon(shapes.get(type));
                break;
            case 34:
                Tile65.setIcon(shapes.get(type));
                break;
            case 35:
                Tile66.setIcon(shapes.get(type));
                break;
        } 
    }
    
    //Sets the icons to all of the buttons to BlankTile.png. Doesn't reset the actual game.
    private void wipeBoard(){
        Tile11.setIcon(Blank);
        Tile12.setIcon(Blank);
        Tile13.setIcon(Blank);
        Tile14.setIcon(Blank);
        Tile15.setIcon(Blank);
        Tile16.setIcon(Blank);
        Tile21.setIcon(Blank);
        Tile22.setIcon(Blank);
        Tile23.setIcon(Blank);
        Tile24.setIcon(Blank);
        Tile25.setIcon(Blank);
        Tile26.setIcon(Blank);
        Tile31.setIcon(Blank);
        Tile32.setIcon(Blank);
        Tile33.setIcon(Blank);
        Tile34.setIcon(Blank);
        Tile35.setIcon(Blank);
        Tile36.setIcon(Blank);
        Tile41.setIcon(Blank);
        Tile42.setIcon(Blank);
        Tile43.setIcon(Blank);
        Tile44.setIcon(Blank);
        Tile45.setIcon(Blank);
        Tile46.setIcon(Blank);
        Tile51.setIcon(Blank);
        Tile52.setIcon(Blank);
        Tile53.setIcon(Blank);
        Tile54.setIcon(Blank);
        Tile55.setIcon(Blank);
        Tile56.setIcon(Blank);
        Tile61.setIcon(Blank);
        Tile62.setIcon(Blank);
        Tile63.setIcon(Blank);
        Tile64.setIcon(Blank);
        Tile65.setIcon(Blank);
        Tile66.setIcon(Blank);
    }
    
    //do the 2 buttons chosen have matching shapes?
    private boolean testMatch(int type1, int type2){
        boolean match = false;
        
        if (type1 == type2){
            match = true;
        }
        
        return match;
    }
    
    //Check for a win or loss - if all buttons are pressed, make decision based on score.
    private void checkEndGame(){
        if (    !Tile11.isEnabled() && !Tile12.isEnabled() && !Tile13.isEnabled() && !Tile14.isEnabled() && !Tile15.isEnabled() && !Tile16.isEnabled() && 
                !Tile21.isEnabled() && !Tile22.isEnabled() && !Tile23.isEnabled() && !Tile24.isEnabled() && !Tile25.isEnabled() && !Tile26.isEnabled() &&
                !Tile31.isEnabled() && !Tile32.isEnabled() && !Tile33.isEnabled() && !Tile34.isEnabled() && !Tile35.isEnabled() && !Tile36.isEnabled() &&
                !Tile41.isEnabled() && !Tile42.isEnabled() && !Tile43.isEnabled() && !Tile44.isEnabled() && !Tile45.isEnabled() && !Tile46.isEnabled() &&
                !Tile51.isEnabled() && !Tile52.isEnabled() && !Tile53.isEnabled() && !Tile54.isEnabled() && !Tile55.isEnabled() && !Tile56.isEnabled() &&
                !Tile61.isEnabled() && !Tile62.isEnabled() && !Tile63.isEnabled() && !Tile64.isEnabled() && !Tile65.isEnabled() && !Tile66.isEnabled()){
            
        	if (score > 0){
                JOptionPane.showMessageDialog(rootPane,
                "                        Congratulations!        \n"
                + "You finished the game successfully with " + score  + " points \n", 
                "You Win!", 
                WIDTH, WIN);
            }
            else{
                JOptionPane.showMessageDialog(rootPane,
                "                               Nice Try!\n"
                + "You scored " + score + "points.\n"
                + "You need a score greater than 0 to win.  Try again!", 
                "You Lose!", 
                WIDTH, LOSS);
            }
        }
    }
    
    //Hide the shape and set icon to blank a particular button/Tile.
    private void hideSelectedTile(int ID){
        switch(ID){
            case 0:
                Tile11.setIcon(Blank);
                break;
            case 1:
                Tile12.setIcon(Blank);
                break;
            case 2:
                Tile13.setIcon(Blank);
                break;
            case 3: 
                Tile14.setIcon(Blank);
                break;
            case 4:
                Tile15.setIcon(Blank);
                break;
            case 5:
                Tile16.setIcon(Blank);
                break;
            case 6:
                Tile21.setIcon(Blank);
                break;
            case 7: 
                Tile22.setIcon(Blank);
                break;
            case 8:
                Tile23.setIcon(Blank);
                break;
            case 9:
                Tile24.setIcon(Blank);
                break;
            case 10:
                Tile25.setIcon(Blank);
                break;
            case 11:
                Tile26.setIcon(Blank);
                break;
            case 12:
                Tile31.setIcon(Blank);
                break;
            case 13:
                Tile32.setIcon(Blank);
                break;
            case 14:
                Tile33.setIcon(Blank);
                break;
            case 15:
                Tile34.setIcon(Blank);
                break;
            case 16:
                Tile35.setIcon(Blank);
                break;
            case 17:
                Tile36.setIcon(Blank);
                break;
            case 18:
                Tile41.setIcon(Blank);
                break;
            case 19:
                Tile42.setIcon(Blank);
                break;
            case 20:
                Tile43.setIcon(Blank);
                break;
            case 21:
                Tile44.setIcon(Blank);
                break;
            case 22:
                Tile45.setIcon(Blank);
                break;
            case 23:
                Tile46.setIcon(Blank);
                break;
            case 24:
                Tile51.setIcon(Blank);
                break;
            case 25:
                Tile52.setIcon(Blank);
                break;
            case 26:
                Tile53.setIcon(Blank);
                break;
            case 27:
                Tile54.setIcon(Blank);
                break;
            case 28:
                Tile55.setIcon(Blank);
                break;
            case 29:
                Tile56.setIcon(Blank);
                break;
            case 30:
                Tile61.setIcon(Blank);
                break;
            case 31:
                Tile62.setIcon(Blank);
                break;
            case 32:
                Tile63.setIcon(Blank);
                break;
            case 33:
                Tile64.setIcon(Blank);
                break;
            case 34:
                Tile65.setIcon(Blank);
                break;
            case 35:
                Tile66.setIcon(Blank);
                break;  
        }
    }
    
    //enable or disable a button. (enable when it's blank [again], & disable when a shape is showing.)
    private void buttonEnabledSwitch(boolean state, int ID){
        //based on boolean variable in state variable, will enable or disable a buton at a given ID.
        switch(ID){
            case 0:
                Tile11.setEnabled(state);
                break;
            case 1:
                Tile12.setEnabled(state);
                break;
            case 2:
                Tile13.setEnabled(state);
                break;
            case 3:
                Tile14.setEnabled(state);
                break;
            case 4:
                Tile15.setEnabled(state);
                break;
            case 5:
                Tile16.setEnabled(state);
                break;
            case 6:
                Tile21.setEnabled(state);
                break;
            case 7:
                Tile22.setEnabled(state);
                break;
            case 8:
                Tile23.setEnabled(state);
                break;
            case 9:
                Tile24.setEnabled(state);
                break;
            case 10:
                Tile25.setEnabled(state);
                break;
            case 11:
                Tile26.setEnabled(state);
                break;
            case 12:
                Tile31.setEnabled(state);
                break;
            case 13:
                Tile32.setEnabled(state);
                break;
            case 14:
                Tile33.setEnabled(state);
                break;
            case 15:
                Tile34.setEnabled(state);
                break;
            case 16:
                Tile35.setEnabled(state);
                break;
            case 17:
                Tile36.setEnabled(state);
                break;
            case 18:
                Tile41.setEnabled(state);
                break;
            case 19:
                Tile42.setEnabled(state);
                break;
            case 20:
                Tile43.setEnabled(state);
                break;
            case 21:
                Tile44.setEnabled(state);
                break;
            case 22:
                Tile45.setEnabled(state);
                break;
            case 23:
                Tile46.setEnabled(state);
                break;
            case 24:
                Tile51.setEnabled(state);
                break;
            case 25:
                Tile52.setEnabled(state);
                break;
            case 26:
                Tile53.setEnabled(state);
                break;
            case 27:
                Tile54.setEnabled(state);
                break;
            case 28:
                Tile55.setEnabled(state);
                break;
            case 29:
                Tile56.setEnabled(state);
                break;
            case 30:
                Tile61.setEnabled(state);
                break;
            case 31:
                Tile62.setEnabled(state);
                break;
            case 32:
                Tile63.setEnabled(state);
                break;
            case 33:
                Tile64.setEnabled(state);
                break;
            case 34:
                Tile65.setEnabled(state);
                break;
            case 35:
                Tile66.setEnabled(state);
                break;
        }  
    }
    
    //every tile that is pressed on the board uses this in order to make decisions in the game.
    private void buttonPress(int ID, int type){
        if (count == 0){
            showTileShape(ID, type);
            ID_Guess1 = ID;
            type_Guess1 = type;
            count++;
            
            //supposed to clear the 2 wrong tiles from the time before
            if (!match){
                hideSelectedTile(PrevID_Guess1);
                hideSelectedTile(PrevID_Guess2);
            }
        }
        else if (count == 1){
            showTileShape(ID, type);
            ID_Guess2 = ID;
            type_Guess2 = type;
            PrevID_Guess1 = ID_Guess1;
            PrevID_Guess2 = ID_Guess2;
            
          //before matching test if the same tile was pressed twice.  that's cheating.
            if (ID_Guess1 == ID_Guess2){
                JOptionPane.showMessageDialog(
                    rootPane,
                    "You cannot pick the same tile twice.\n", 
                    "Invalid Move", WIDTH, null
                );
                hideSelectedTile(ID_Guess1);
                ID_Guess1 = 100;
                ID_Guess2 = 100;
                PrevID_Guess1 = 100;
                PrevID_Guess2 = 100;
                buttonEnabledSwitch(true,ID_Guess1);
            }
            else {
                match = testMatch(type_Guess1, type_Guess2);

                if(!match){
                    score = score - 2;
                    sScore = Integer.toString(score);
                    ScoreScreen.setText(sScore);
                }
                else{
                    score = score + 4;
                    sScore = Integer.toString(score);
                    ScoreScreen.setText(sScore);

                    buttonEnabledSwitch(false, ID_Guess1);
                    buttonEnabledSwitch(false, ID_Guess2);
                   
                    checkEndGame();
                }
            }
            
            count = 0;
        }        
    }
    
    //Shows the shapes to the player for a small duration of time, then turns the buttons to blank again.
    private void flashShapes(){
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i<= 35; i++){
                        int type = tileControl.get6x6TileType(i);
                        showTileShape(i, type);
                    }
                    Thread.sleep(1200);
                    wipeBoard();
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(GameBoard2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start(); 
    }
}
