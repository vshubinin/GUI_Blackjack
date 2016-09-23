import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class guiBlackjack {

	private JFrame frame;
	private JTextField ScorePalyer;
	private JTextField tfStavka;
	private JLabel CardRub;
	private String rub1 = "img/rub/b2.png";
	private String rub2 = "img/rub/1.png";
	public JButton btn2;
	public JButton btn3;
	public JButton btnNextGame;
	public JLabel lbScoreDiler;
	public JLabel lbScoreYou;
	public JLabel Card1Player;
	public JLabel Card2Player;
	public JLabel Card3Player;
	public JLabel Card4Player;
	public JLabel Card5Player;
	public JLabel Card6Player;
	public JLabel Card1Diler;
	public JLabel Card2Diler;
	public JLabel Card3Diler;
	public JLabel Card4Diler;
	public JLabel Card5Diler;
	public JLabel Card6Diler;
	public JLabel Backgaund;
	public int CardDilNum=0;
	public int CardPlaNum=1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public int YouScore = 0;
	public int DilerScore = 0;
	public int Score = 100;
	public int Stavka = 10;
	public String bt ="img/card/b/2.png";
	public JLabel lbYouWin;
	public JLabel lbDilerWin;
	public ArrayList<Cards> deck;
	public Cards[] cardsArray;
	public ArrayList<Cards> player;
	public ArrayList<Cards> dealer;


	/**1
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiBlackjack window = new guiBlackjack();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiBlackjack() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		newGame();
		//Scorenew();


		//
		//

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 850, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel MenuPanel = new JPanel();
		frame.getContentPane().add(MenuPanel, BorderLayout.NORTH);
		MenuPanel.setLayout(new BoxLayout(MenuPanel, BoxLayout.X_AXIS));

		JMenuBar menuBar = new JMenuBar();
		MenuPanel.add(menuBar);

		JMenu mnMenu = new JMenu("\u0418\u0433\u0440\u0430");
		menuBar.add(mnMenu);

		JMenuItem mntmMenuItem1 = new JMenuItem("\u041D\u043E\u0432\u0430\u044F \u0438\u0433\u0440\u0430");
		mntmMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbDilerWin.setText("");
				lbYouWin.setText("");
				btnNextGame.setVisible(false);;
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				Scorenew();
				cleardesk();
				newGame();
			}
		});
		mnMenu.add(mntmMenuItem1);

		JMenuItem mntmMenuItem2 = new JMenuItem("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		mntmMenuItem2.setVisible(false);
		mnMenu.add(mntmMenuItem2);

		JMenuItem mntmMenuItem = new JMenuItem("\u0412\u044B\u0445\u043E\u0434");
		mntmMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mnMenu.add(mntmMenuItem);

		JMenu mnNewMenu = new JMenu("\u0412\u0438\u0434");
		menuBar.add(mnNewMenu);

		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("\u0412\u0438\u0434 1");
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardRub.setIcon(new ImageIcon(rub2));
				if(Card1Diler.getIcon().toString() == "img/rub/b2.png"){Card1Diler.setIcon(new ImageIcon(rub2));}
				if(Card2Diler.getIcon().toString() == "img/rub/b2.png"){Card2Diler.setIcon(new ImageIcon(rub2));}
				if(Card3Diler.getIcon().toString() == "img/rub/b2.png"){Card3Diler.setIcon(new ImageIcon(rub2));}
				if(Card4Diler.getIcon().toString() == "img/rub/b2.png"){Card4Diler.setIcon(new ImageIcon(rub2));}
				if(Card5Diler.getIcon().toString() == "img/rub/b2.png"){Card5Diler.setIcon(new ImageIcon(rub2));}
				if(Card6Diler.getIcon().toString() == "img/rub/b2.png"){Card6Diler.setIcon(new ImageIcon(rub2));}
				Backgaund.repaint();

			}
		});
		chckbxmntmNewCheckItem.setSelected(true);
		buttonGroup.add(chckbxmntmNewCheckItem);
		mnNewMenu.add(chckbxmntmNewCheckItem);

		JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("\u0412\u0438\u0434 2");
		chckbxmntmNewCheckItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardRub.setIcon(new ImageIcon(rub1));
				if(Card1Diler.getIcon().toString() == "img/rub/1.png"){Card1Diler.setIcon(new ImageIcon(rub1));}
				if(Card2Diler.getIcon().toString() == "img/rub/1.png"){Card2Diler.setIcon(new ImageIcon(rub1));}
				if(Card3Diler.getIcon().toString() == "img/rub/1.png"){Card3Diler.setIcon(new ImageIcon(rub1));}
				if(Card4Diler.getIcon().toString() == "img/rub/1.png"){Card4Diler.setIcon(new ImageIcon(rub1));}
				if(Card5Diler.getIcon().toString() == "img/rub/1.png"){Card5Diler.setIcon(new ImageIcon(rub1));}
				if(Card6Diler.getIcon().toString() == "img/rub/1.png"){Card6Diler.setIcon(new ImageIcon(rub1));}
				Backgaund.repaint();
			}
		});
		buttonGroup.add(chckbxmntmNewCheckItem_1);
		mnNewMenu.add(chckbxmntmNewCheckItem_1);

		JPanel ButtonPanel = new JPanel();
		frame.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);
		ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//JButton btn1 = new JButton("\u041F\u0430\u0441");
		//btn1.setPreferredSize(new Dimension(150, 23));
		//btn1.setMinimumSize(new Dimension(150, 23));
		//btn1.setMaximumSize(new Dimension(150, 23));
		//ButtonPanel.add(btn1);

		btn2 = new JButton("\u041F\u043E\u0434\u043D\u044F\u0442\u044C \u0441\u0442\u0430\u0432\u043A\u0443");
		btn2.setPreferredSize(new Dimension(300, 23));
		btn2.setMinimumSize(new Dimension(150, 23));
		btn2.setMaximumSize(new Dimension(150, 23));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Stavka+=10;
				String strStavka10 = Integer.toString(Stavka);
				tfStavka.setText(strStavka10);
			}
		});
		ButtonPanel.add(btn2);

		btn3 = new JButton("\u0412\u0441\u043A\u0440\u044B\u0442\u044C");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//if(Card1Player.isVisible()){
				if(Card1Player.isVisible()){
					btnNextGame.setVisible(true);
					//btn1.setEnabled(false);
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					int i = 0,i1=0;
					Random rnd = new Random();
					//
					lbScoreDiler.setVisible(false);
					while(DilerScore<=17){
						DilerScore += dealer.get(i).getScore();
						i++;
						CardDilNum+=1;
					}
					if(DilerScore<=17){
						i1 = rnd.nextInt(10);						
						if(i1>5){
							i++;
							DilerScore += dealer.get(i).getScore();
							CardDilNum+=1;	
						}
					}
					String strDilerScore = Integer.toString(DilerScore);
					lbScoreDiler.setText(strDilerScore);
					lbScoreDiler.setVisible(true);
					frame.repaint();
					//

					if(CardDilNum==6){
						Card6Diler.setVisible(true);
						Card6Diler.setIcon(new ImageIcon(dealer.get(5).getImageCard()));
						Card5Diler.setVisible(true);
						Card5Diler.setIcon(new ImageIcon(dealer.get(4).getImageCard()));
						Card4Diler.setVisible(true);
						Card4Diler.setIcon(new ImageIcon(dealer.get(3).getImageCard()));
						Card3Diler.setVisible(true);
						Card3Diler.setIcon(new ImageIcon(dealer.get(2).getImageCard()));
						Card2Diler.setVisible(true);
						Card2Diler.setIcon(new ImageIcon(dealer.get(1).getImageCard()));
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					if(CardDilNum==5){
						Card5Diler.setVisible(true);
						Card5Diler.setIcon(new ImageIcon(dealer.get(4).getImageCard()));
						Card4Diler.setVisible(true);
						Card4Diler.setIcon(new ImageIcon(dealer.get(3).getImageCard()));
						Card3Diler.setVisible(true);
						Card3Diler.setIcon(new ImageIcon(dealer.get(2).getImageCard()));
						Card2Diler.setVisible(true);
						Card2Diler.setIcon(new ImageIcon(dealer.get(1).getImageCard()));
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					if(CardDilNum==4){
						Card4Diler.setVisible(true);
						Card4Diler.setIcon(new ImageIcon(dealer.get(3).getImageCard()));
						Card3Diler.setVisible(true);
						Card3Diler.setIcon(new ImageIcon(dealer.get(2).getImageCard()));
						Card2Diler.setVisible(true);
						Card2Diler.setIcon(new ImageIcon(dealer.get(1).getImageCard()));
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					if(CardDilNum==3){
						Card3Diler.setVisible(true);
						Card3Diler.setIcon(new ImageIcon(dealer.get(2).getImageCard()));
						Card2Diler.setVisible(true);
						Card2Diler.setIcon(new ImageIcon(dealer.get(1).getImageCard()));
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					if(CardDilNum==2){
						Card2Diler.setVisible(true);
						Card2Diler.setIcon(new ImageIcon(dealer.get(1).getImageCard()));
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					if(CardDilNum==1){
						Card1Diler.setVisible(true);
						Card1Diler.setIcon(new ImageIcon(dealer.get(0).getImageCard()));
						Backgaund.repaint();
					}
					//

					//
					if (DilerScore > YouScore)
					{
						if(DilerScore <= 21 & YouScore <= 21)
						{
							lbDilerWin.setText("����������");
							lbYouWin.setText("");
							frame.repaint();
							Score-=Stavka;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
						if(DilerScore > 21 & YouScore > 21) 
						{
							lbDilerWin.setText("�����");
							lbYouWin.setText("�����");
							frame.repaint();
							Score+=0;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
						if(DilerScore > 21 & YouScore <= 21) 
						{
							lbDilerWin.setText("");
							lbYouWin.setText("����������");
							frame.repaint();
							Score+=Stavka;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
					}
					if (YouScore > DilerScore)
					{
						if(YouScore <= 21 & DilerScore <= 21 )
						{
							lbDilerWin.setText("");
							lbYouWin.setText("����������");
							frame.repaint();
							Score+=Stavka;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
						if( YouScore > 21 & DilerScore > 21) 
						{
							lbDilerWin.setText("�����");
							lbYouWin.setText("�����");
							frame.repaint();
							Score+=0;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
						if( YouScore > 21 & DilerScore <= 21) 
						{
							lbDilerWin.setText("����������");
							lbYouWin.setText("");
							frame.repaint();
							Score-=Stavka;
							String strStavka10 = Integer.toString(Score);
							ScorePalyer.setText(strStavka10);
						}
					}
					if (YouScore == DilerScore)
					{
						lbDilerWin.setText("�����");
						lbYouWin.setText("�����");
						frame.repaint();
						Score+=0;
						String strStavka10 = Integer.toString(Score);
						ScorePalyer.setText(strStavka10);
					}
				}else{
				}
			}
			//}
		});
		btn3.setPreferredSize(new Dimension(300, 23));
		btn3.setMinimumSize(new Dimension(150, 23));
		btn3.setMaximumSize(new Dimension(150, 23));
		ButtonPanel.add(btn3);

		JPanel ScorePanel = new JPanel();
		frame.getContentPane().add(ScorePanel, BorderLayout.EAST);
		GridBagLayout gbl_ScorePanel = new GridBagLayout();
		gbl_ScorePanel.columnWidths = new int[] {150};
		gbl_ScorePanel.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50};
		gbl_ScorePanel.columnWeights = new double[]{1.0};
		gbl_ScorePanel.rowWeights = new double[]{0.0};
		ScorePanel.setLayout(gbl_ScorePanel);

		JLabel lblNewLabel = new JLabel("\u0412\u0430\u0448\u0438 \u043C\u043E\u043D\u0435\u0442\u044B");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		ScorePanel.add(lblNewLabel, gbc_lblNewLabel);

		ScorePalyer = new JTextField();
		ScorePalyer.setEditable(false);
		ScorePalyer.setForeground(new Color(204, 0, 0));
		ScorePalyer.setFont(new Font("/font/elec.ttf", Font.BOLD , 20));
		String strCore = Integer.toString(Score);
		ScorePalyer.setText(strCore);
		ScorePalyer.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_ScorePalyer = new GridBagConstraints();
		gbc_ScorePalyer.insets = new Insets(0, 0, 5, 0);
		gbc_ScorePalyer.fill = GridBagConstraints.HORIZONTAL;
		gbc_ScorePalyer.gridx = 0;
		gbc_ScorePalyer.gridy = 1;
		ScorePanel.add(ScorePalyer, gbc_ScorePalyer);
		ScorePalyer.setColumns(3);

		JLabel lblNewLabel_1 = new JLabel("\u0421\u0442\u0430\u0432\u043A\u0430");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		ScorePanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		tfStavka = new JTextField();
		tfStavka.setHorizontalAlignment(SwingConstants.CENTER);
		tfStavka.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfStavka.setForeground(new Color(51, 0, 102));
		tfStavka.setEditable(false);
		String strStavka = Integer.toString(Stavka);
		tfStavka.setText(strStavka);
		GridBagConstraints gbc_tfStavka = new GridBagConstraints();
		gbc_tfStavka.insets = new Insets(0, 0, 5, 0);
		gbc_tfStavka.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStavka.gridx = 0;
		gbc_tfStavka.gridy = 3;
		ScorePanel.add(tfStavka, gbc_tfStavka);
		tfStavka.setColumns(2);

		JButton btnNewButton = new JButton("\u0422\u0415\u0421\u0422");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JLabel lblNewLabel_6 = new JLabel("edu.step.blackjeck.2015");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		ScorePanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		ScorePanel.add(btnNewButton, gbc_btnNewButton);

		JPanel GamePanel = new JPanel();
		frame.getContentPane().add(GamePanel, BorderLayout.CENTER);
		GamePanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(0, 0, 700, 416);
		GamePanel.add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panelDiller = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDiller.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelDiller.setBackground(new Color(0, 0, 0, 0));
		panel.add(panelDiller);

		Card1Diler = new JLabel(" ");
		Card1Diler.setVisible(false);
		Card1Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card1Diler);

		Card2Diler = new JLabel(" ");
		Card2Diler.setVisible(false);
		Card2Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card2Diler);

		Card3Diler = new JLabel(" ");
		Card3Diler.setVisible(false);
		Card3Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card3Diler);

		Card4Diler = new JLabel(" ");
		Card4Diler.setVisible(false);
		Card4Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card4Diler);

		Card5Diler = new JLabel(" ");
		Card5Diler.setVisible(false);
		Card5Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card5Diler);

		Card6Diler = new JLabel(" ");
		Card6Diler.setVisible(false);
		Card6Diler.setIcon(new ImageIcon(rub2));
		panelDiller.add(Card6Diler);

		//
		Scorenew();
		//

		JPanel panelScore = new JPanel();
		panelScore.setBackground(new Color(0, 0, 0, 0));
		panel.add(panelScore);
		panelScore.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0, 0));
		panel_1.setBounds(0, 0, 600, 138);
		panelScore.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[200px][200px][150]", "[46px][46px][46px]"));

		JLabel lbTextDiler = new JLabel("\u041E\u0447\u043A\u0438 \u0434\u0438\u043B\u0435\u0440\u0430: ");
		lbTextDiler.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTextDiler.setForeground(new Color(255, 255, 255));
		lbTextDiler.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lbTextDiler, "cell 0 0,grow");

		lbScoreDiler = new JLabel("0");
		lbScoreDiler.setForeground(new Color(255, 255, 255));
		lbScoreDiler.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lbScoreDiler, "cell 1 0,grow");

		btnNextGame = new JButton("\u041F\u0440\u043E\u0434\u043E\u043B\u0436\u0438\u0442\u044C");
		btnNextGame.setVisible(false);

		lbDilerWin = new JLabel("");
		lbDilerWin.setForeground(new Color(255, 255, 255));
		lbDilerWin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbDilerWin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbDilerWin, "cell 2 0");
		panel_1.add(btnNextGame, "cell 2 1");
		btnNextGame.setPreferredSize(new Dimension(150, 23));
		btnNextGame.setMinimumSize(new Dimension(150, 23));
		btnNextGame.setMaximumSize(new Dimension(150, 23));
		btnNextGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				lbDilerWin.setText("");
				lbYouWin.setText("");
				btnNextGame.setVisible(false);;
				cleardesk();
				frame.repaint();
				//newGame();
			}
		});

		JLabel lbTextUser = new JLabel("\u0412\u0430\u0448\u0438 \u043E\u0447\u043A\u0438: ");
		lbTextUser.setForeground(new Color(255, 255, 255));
		lbTextUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTextUser.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lbTextUser, "cell 0 2,grow");

		lbScoreYou = new JLabel("0");
		lbScoreYou.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbScoreYou.setForeground(new Color(255, 255, 255));
		panel_1.add(lbScoreYou, "cell 1 2,grow");

		lbYouWin = new JLabel("");
		lbYouWin.setForeground(new Color(255, 255, 255));
		lbYouWin.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lbYouWin, "cell 2 2");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 0));
		panel_2.setBounds(600, 0, 93, 138);
		panelScore.add(panel_2);
		panel_2.setLayout(null);

		CardRub = new JLabel("");
		CardRub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//frame.dispose();
				//
				//
				btn2.setEnabled(false);
				if(YouScore>21 | btnNextGame.isVisible()){
					Backgaund.repaint();
				}else{

					if(CardPlaNum>6){
						//int max = JOptionPane.showMessageDialog(null, "��������","������ ���� ����� ������", JOptionPane.ERROR_MESSAGE);
						//CardDilNum=6;
						JOptionPane.showMessageDialog(null, "������ ���� ����� ������ !!!");

					}if(CardPlaNum==6){
						Card6Player.setIcon(new ImageIcon(player.get(5).getImageCard()));
						Card6Player.setVisible(true);
						//Card6Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(5).getScore();
						String strYouScore6 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore6);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					if(CardPlaNum==5){
						Card5Player.setIcon(new ImageIcon(player.get(4).getImageCard()));
						Card5Player.setVisible(true);
						//Card5Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(4).getScore();
						String strYouScore5 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore5);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					if(CardPlaNum==4){
						Card4Player.setIcon(new ImageIcon(player.get(3).getImageCard()));
						Card4Player.setVisible(true);
						//Card4Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(3).getScore();
						String strYouScore4 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore4);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					if(CardPlaNum==3){
						Card3Player.setIcon(new ImageIcon(player.get(2).getImageCard()));
						Card3Player.setVisible(true);
						//Card3Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(2).getScore();
						String strYouScore3 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore3);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					if(CardPlaNum==2){
						Card2Player.setIcon(new ImageIcon(player.get(1).getImageCard()));
						Card2Player.setVisible(true);
						//Card2Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(1).getScore();
						String strYouScore2 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore2);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					if(CardPlaNum==1){
						Card1Player.setIcon(new ImageIcon(player.get(0).getImageCard()));
						Card1Player.setVisible(true);
						//Card1Diler.setVisible(true);
						Backgaund.repaint();
						//CardDilNum+=1;
						lbScoreYou.setVisible(false);
						YouScore += player.get(0).getScore();
						String strYouScore1 = Integer.toString(YouScore);
						lbScoreYou.setText(strYouScore1);
						lbScoreYou.setIcon(null);
						lbScoreYou.setVisible(true);
						CardPlaNum+=1;
						Backgaund.repaint();
						Backgaund.repaint();
					}
					//if(YouScore>21){
					//btnNextGame.setVisible(true);
					//btn1.setEnabled(false);
					//Backgaund.repaint();
					//}
				}
			}
		});
		CardRub.setBounds(1, 5, 90, 126);
		CardRub.setIcon(new ImageIcon(rub2));
		panel_2.add(CardRub);

		JPanel panelPlaeyr = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelPlaeyr.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelPlaeyr.setBackground(new Color(0, 0, 0, 0));
		panel.add(panelPlaeyr);

		Card1Player = new JLabel(" ");
		Card1Player.setVisible(false);
		Card1Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card1Player);

		Card2Player = new JLabel(" ");
		Card2Player.setVisible(false);
		Card2Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card2Player);

		Card3Player = new JLabel(" ");
		Card3Player.setVisible(false);
		Card3Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card3Player);

		Card4Player = new JLabel(" ");
		Card4Player.setVisible(false);
		Card4Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card4Player);

		Card5Player = new JLabel(" ");
		Card5Player.setVisible(false);
		Card5Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card5Player);

		Card6Player = new JLabel(" ");
		Card6Player.setVisible(false);
		Card6Player.setIcon(new ImageIcon(rub2));
		panelPlaeyr.add(Card6Player);

		Backgaund = new JLabel("");
		Backgaund.setBounds(0, 0, 700, 416);
		GamePanel.add(Backgaund);
		Backgaund.setIconTextGap(10);
		Backgaund.setHorizontalTextPosition(SwingConstants.CENTER);
		Backgaund.setHorizontalAlignment(SwingConstants.CENTER);
		Backgaund.setIcon(new ImageIcon("img/back-1.png"));


	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void newGame(){
		//
		cardsArray = new Cards[52];
		//2//
		cardsArray[0]=new Cards(2,"img/card/c/2.png");
		cardsArray[1]=new Cards(2,"img/card/b/2.png");
		cardsArray[2]=new Cards(2,"img/card/k/2.png");
		cardsArray[3]=new Cards(2,"img/card/p/2.png");
		//3//
		cardsArray[4]=new Cards(3,"img/card/c/3.png");
		cardsArray[5]=new Cards(3,"img/card/b/3.png");
		cardsArray[6]=new Cards(3,"img/card/k/3.png");
		cardsArray[7]=new Cards(3,"img/card/p/3.png");
		//4//
		cardsArray[8]=new Cards(4,"img/card/c/4.png");
		cardsArray[9]=new Cards(4,"img/card/b/4.png");
		cardsArray[10]=new Cards(4,"img/card/k/4.png");
		cardsArray[11]=new Cards(4,"img/card/p/4.png");
		//5//
		cardsArray[12]=new Cards(5,"img/card/c/5.png");
		cardsArray[13]=new Cards(5,"img/card/b/5.png");
		cardsArray[14]=new Cards(5,"img/card/k/5.png");
		cardsArray[15]=new Cards(5,"img/card/p/5.png");
		//6//
		cardsArray[16]=new Cards(6,"img/card/c/6.png");
		cardsArray[17]=new Cards(6,"img/card/b/6.png");
		cardsArray[18]=new Cards(6,"img/card/k/6.png");
		cardsArray[19]=new Cards(6,"img/card/p/6.png");
		//7//
		cardsArray[20]=new Cards(7,"img/card/c/7.png");
		cardsArray[21]=new Cards(7,"img/card/b/7.png");
		cardsArray[22]=new Cards(7,"img/card/k/7.png");
		cardsArray[23]=new Cards(7,"img/card/p/7.png");
		//8//
		cardsArray[24]=new Cards(8,"img/card/c/8.png");
		cardsArray[25]=new Cards(8,"img/card/b/8.png");
		cardsArray[26]=new Cards(8,"img/card/k/8.png");
		cardsArray[27]=new Cards(8,"img/card/p/8.png");
		//9//
		cardsArray[28]=new Cards(9,"img/card/c/9.png");
		cardsArray[29]=new Cards(9,"img/card/b/9.png");
		cardsArray[30]=new Cards(9,"img/card/k/9.png");
		cardsArray[31]=new Cards(9,"img/card/p/9.png");
		//10//
		cardsArray[32]=new Cards(10,"img/card/c/10.png");
		cardsArray[33]=new Cards(10,"img/card/b/10.png");
		cardsArray[34]=new Cards(10,"img/card/k/10.png");
		cardsArray[35]=new Cards(10,"img/card/p/10.png");
		//�����//
		cardsArray[36]=new Cards(10,"img/card/c/v.png");
		cardsArray[37]=new Cards(10,"img/card/b/v.png");
		cardsArray[38]=new Cards(10,"img/card/k/v.png");
		cardsArray[39]=new Cards(10,"img/card/p/v.png");
		//����//
		cardsArray[40]=new Cards(10,"img/card/c/d.png");
		cardsArray[41]=new Cards(10,"img/card/b/d.png");
		cardsArray[42]=new Cards(10,"img/card/k/d.png");
		cardsArray[43]=new Cards(10,"img/card/p/d.png");
		//������//
		cardsArray[44]=new Cards(10,"img/card/c/k.png");
		cardsArray[45]=new Cards(10,"img/card/b/k.png");
		cardsArray[46]=new Cards(10,"img/card/k/k.png");
		cardsArray[47]=new Cards(10,"img/card/p/k.png");
		//���//
		cardsArray[48]=new Cards(11,"img/card/c/t.png");
		cardsArray[49]=new Cards(11,"img/card/b/t.png");
		cardsArray[50]=new Cards(11,"img/card/k/t.png");
		cardsArray[51]=new Cards(11,"img/card/p/t.png");
		//////
		deck = new ArrayList<>();

		for(int i=0;i<51;i++)
		{
			deck.add(cardsArray[i]);
			//System.out.println("�����: "+deck.get(i));
		}
		//
		Collections.shuffle(deck);
		player = new ArrayList<>();
		dealer = new ArrayList<>();
		//
		player.add(0,deck.remove(0));
		player.add(1,deck.remove(0));
		player.add(2,deck.remove(0));
		player.add(3,deck.remove(0));
		player.add(4,deck.remove(0));
		player.add(5,deck.remove(0));
		dealer.add(0,deck.remove(0));
		dealer.add(1,deck.remove(0));
		dealer.add(2,deck.remove(0));
		dealer.add(3,deck.remove(0));
		dealer.add(4,deck.remove(0));
		dealer.add(5,deck.remove(0));
		//
	}
	public void cleardesk(){
		CardDilNum=0;
		CardPlaNum=1;
		Card1Player.setVisible(false);
		Card1Diler.setVisible(false);
		Card2Player.setVisible(false);
		Card2Diler.setVisible(false);
		Card3Player.setVisible(false);
		Card3Diler.setVisible(false);
		Card4Player.setVisible(false);
		Card4Diler.setVisible(false);
		Card5Player.setVisible(false);
		Card5Diler.setVisible(false);
		Card6Player.setVisible(false);
		Card6Diler.setVisible(false);
		//
		if(CardRub.getIcon().toString() == "img/rub/b2.png"){
			Card1Diler.setIcon(new ImageIcon(rub1));
			Card2Diler.setIcon(new ImageIcon(rub1));
			Card3Diler.setIcon(new ImageIcon(rub1));
			Card4Diler.setIcon(new ImageIcon(rub1));
			Card5Diler.setIcon(new ImageIcon(rub1));
			Card6Diler.setIcon(new ImageIcon(rub1));
		}else{
			Card1Diler.setIcon(new ImageIcon(rub2));
			Card2Diler.setIcon(new ImageIcon(rub2));
			Card3Diler.setIcon(new ImageIcon(rub2));
			Card4Diler.setIcon(new ImageIcon(rub2));
			Card5Diler.setIcon(new ImageIcon(rub2));
			Card6Diler.setIcon(new ImageIcon(rub2));
		}
		Card1Diler.setVisible(true);
		Card2Diler.setVisible(true);
		YouScore = 0;
		DilerScore = 0;
		Stavka=10;
		String strStavka0 = Integer.toString(Stavka);
		tfStavka.setText(strStavka0);
		String strYouScore = Integer.toString(YouScore);
		String strYouDiler = Integer.toString(DilerScore);
		lbScoreDiler.setText(strYouDiler);
		lbScoreYou.setText(strYouScore);
		frame.repaint();
		newGame();

	}
	public void Scorenew(){
		Card1Diler.setVisible(true);
		Card2Diler.setVisible(true);
		Score = 100;
		Stavka=10;
		String strStavka0 = Integer.toString(Stavka);
		tfStavka.setText(strStavka0);
		String strScore0 = Integer.toString(Score);
		ScorePalyer.setText(strScore0);
		
		
	}
}
