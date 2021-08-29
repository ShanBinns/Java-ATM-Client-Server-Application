/**
 * This class displays the customer's receipt
 * @author SBINNS
 *
 */

package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ReceiptView{
	private static JDialog receipt; 
	private JButton butOK;
    private JFrame frame;
    private String  service;
    private double amount;
    private double balance;
	   
    public ReceiptView(String ser, double amt, double bal){ 
    	this.service = ser;
        this.amount = amt;
        this.balance = bal;
		   
		 frame= new JFrame();  
	     receipt = new JDialog(frame , "Take your Receipt", true);  
	     receipt.setLayout( new FlowLayout() );  
	     butOK = new JButton ("OK");  
	     
	     LocalDateTime dateTime = LocalDateTime.now(); 
	     DateTimeFormatter FormatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	     String formattedDate = dateTime.format(FormatDateTime);; 
	     
	     
	     butOK.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	         	ReceiptView.receipt.setVisible(false);  
	         }
					
	     });  
	     
	       receipt.add( new JLabel (          "MTA Bank         ")); 
	       receipt.add( new JLabel ( formattedDate  + "   ")); 
	      	       receipt.add( new JLabel ("ATM Transaction")); 
	       receipt.add( new JLabel ("-----------------------------------------"));
	       receipt.add( new JLabel ("Card #                   XXXXXXXXX")); 
	       receipt.add( new JLabel (ser + "                    $" + amt)); 
	       receipt.add( new JLabel ("Account Balance        $" + bal)); 
	       receipt.add( new JLabel ("Thank you for using our ATM")); 
	       receipt.add( new JLabel ("-----------------------------------------"));
	       receipt.add(butOK);
		        
		   receipt.setSize(200,300);    
	       receipt.setVisible(true); 
	       receipt.setResizable(false);
	    }  
}
