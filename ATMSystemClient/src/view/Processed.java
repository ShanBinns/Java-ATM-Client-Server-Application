/**
 * This class displays the GUI for customer completed transactions
 * @author SBINNS
 *
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Processed extends JFrame implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblInsertCash;
	private JLabel lblWelcome;
	private JLabel lblAnother;
	private JButton btnYes;
	private JButton btnNo;
	private JButton btnEnter;
	private JButton btnClear;
	private JButton btnCancel;
	private JButton btnCardEject;
	private JButton btnCash;
	private JButton btnDepositCash; 
	private JButton b00, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, blank1, blank2;
	private JButton btn1, btn2, btn3 , btn4, btn5, btn6;
	private JPanel keyPad;
	private JPanel panelScreen;
	private JPanel panelCard;
	private JPanel panelTakeCash;
	
	
	public Processed(){
		this.initializeComponents();
		this.registerListeners();
		this.setWindowProperties();
		this.addComponentsToPanel();
		this.addComponentsToWindow();
	}
	
	public void initializeComponents() {
		this.lblTitle = new JLabel("MTA Bank");
		lblTitle.setBounds(5, 1, 250, 100);
		lblTitle.setForeground(Color.white);
		
		//Screen
		this.panelScreen = new JPanel();
		panelScreen.setBounds(140, 50, 500, 350);
		panelScreen.setBackground(new Color(14, 38, 177));
		panelScreen.setLayout(null);
		
		
		btn1 = new JButton(""); 		 
		btn1.setBounds(70, 180, 55, 40);		
		btn2 = new JButton("");  
		btn2.setBounds(70, 250, 55, 40);		
		btn3 = new JButton("");   
		btn3.setBounds(70, 320, 55, 40);		
		btn4 = new JButton("");  
		btn4.setBounds(655, 180, 55, 40);		
		btn5 = new JButton("");      
		btn5.setBounds(655, 250, 55, 40);		
		btn6 = new JButton("");   
		btn6.setBounds(655, 320, 55, 40);
		
		
		lblWelcome = new JLabel("YOUR TRANSACTION IS COMPLETED");
		lblWelcome.setBounds(160, 80, 500, 20);
		lblWelcome.setForeground(Color.white);
		
		lblAnother = new JLabel("Do you want to make another transaction?");
		lblAnother.setBounds(30, 140, 500, 20);
		lblAnother.setForeground(Color.white);
		
		btnYes = new JButton("Yes");
		btnYes.setBounds(297, 205, 200, 30);
		btnYes.setBackground(new Color(0,0,139));
		btnYes.setForeground(Color.white);
		
		btnNo = new JButton("No");
		btnNo.setBounds(297, 270, 200, 30);
		btnNo.setBackground(new Color(0,0,139));
		btnNo.setForeground(Color.white);
		
		
		//Keypad 
		this.btnEnter = new JButton("Enter");
		btnEnter.setBackground(Color.GREEN);
		this.btnClear = new JButton("Clear");
		btnClear.setBackground(Color.ORANGE);
		this.btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
								
		this.keyPad = new JPanel();
		keyPad.setBounds(50, 440, 220, 170);
		keyPad.setBackground(new Color(96,96,96));
		
		b00 = new JButton("00");
		b0 = new JButton("0"); 		b1 = new JButton("1");        b2 = new JButton("2");         b3 = new JButton("3");     
		b4 = new JButton("4");      b5 = new JButton("5");        b6 = new JButton("6");         b7 = new JButton("7");       
		b8 = new JButton("8");      b9 = new JButton("9");	      blank1 = new JButton(" ");     blank2 = new JButton("           ");
	 				
		
		//Card and cash Panels
		this.panelCard = new JPanel();
		this.btnCardEject = new JButton(new ImageIcon("./img/cardslot.PNG"));
		btnCardEject.setBounds(0,0,200,200);
		panelCard.setLayout(null);
		panelCard.setBounds(550, 440, 180, 170); 
		panelCard.add(btnCardEject);
		
		this.panelTakeCash = new JPanel();
		this.btnCash = new JButton(new ImageIcon("./img/cash.PNG"));
		btnCash.setBounds(0,0,300,75);
		panelTakeCash.setLayout(null);
		panelTakeCash.setBounds(240, 630, 300, 55); 
		panelTakeCash.add(btnCash);
		
		
		//Insertion slot for cash 
		this.lblInsertCash = new JLabel("Insert cash here");
		lblInsertCash.setBounds(300, 490, 200, 80);
		lblInsertCash.setForeground(Color.white);
		this.btnDepositCash = new JButton();
		btnDepositCash.setBounds(300,550,185,30);
		btnDepositCash.setBackground(new Color(96,96,96));
	
		
		this.add(lblTitle);
		this.add(btn1);
	    this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(panelTakeCash);
        this.add(panelCard);
        this.add(lblInsertCash);	
		this.add(btnDepositCash);	
	}
	
	
	
	private void addComponentsToPanel() {
		keyPad.add(b1);		
		keyPad.add(b2);		
		keyPad.add(b3);		keyPad.add(btnEnter);
		keyPad.add(b4);   
		keyPad.add(b5);			
		keyPad.add(b6);		keyPad.add(btnClear);
		keyPad.add(b7);		
		keyPad.add(b8);		
		keyPad.add(b9);		keyPad.add(btnCancel);
		keyPad.add(blank1);
		keyPad.add(b00);		
		keyPad.add(b0);	
		keyPad.add(blank2);
		
		panelScreen.add(lblWelcome);  
		panelScreen.add(btnYes);
		panelScreen.add(btnNo);
		panelScreen.add(lblAnother);
	}
	
	private void addComponentsToWindow() {
		this.add(keyPad);
		this.add(panelScreen);
		this.add(panelCard);
		this.add(panelTakeCash);
	}

	private void setWindowProperties() {
		this.setSize(800, 730);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE); 
		getContentPane().setBackground(Color.gray);
		
		
	}
	
	public void registerListeners()
	{
		this.btn6.addActionListener(this);
		this.btn5.addActionListener(this);
		this.btnNo.addActionListener(this);
		this.btnYes.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.btnCardEject.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnYes)|| e.getSource().equals(btn5)) {
			new Transactions();
			dispose();
		}
		if(e.getSource().equals(btnNo)|| e.getSource().equals(btn6) || e.getSource().equals(btnCardEject)) {
			dispose();
			JOptionPane.showMessageDialog(null, "Thanks for banking with MTA Bank", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
		}
			}

}
