import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.*;  

public class GUI implements ActionListener
{
	int count = 0;
	JInternalFrame frame,frame1;
	JLabel label;
	JFrame frame0;
	JDesktopPane desk;
	JPanel panel,panel1;
	BufferedImage myPicture;
	Image newImage;
	JTextField account_number_field,withdraw_field,credit_field,new_account_number_field,new_account_first_name_field,new_account_last_name_field,new_account_aadhar_field,new_account_address_field,new_account_amount_field;
	
	public GUI()
	{
			//Outer frame
		frame0 = new JFrame();
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desk = new JDesktopPane();
		frame0.setSize(1015, 540);
		frame0.setVisible(true);
		frame0.setTitle("International");
		
			//Inner frame
		frame = new JInternalFrame();
		panel = new JPanel();
		frame.add(panel);
		desk.add(frame);
		panel.setLayout(null);
		
			//Inner frame
		frame1 = new JInternalFrame();
		panel1 = new JPanel();
		frame1.add(panel1);
		desk.add(frame1);
		panel1.setLayout(null);
		
		frame0.add(desk);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("False Bank");
		panel.setBackground(new Color(51,255,153));
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("False Bank");
		panel1.setBackground(new Color(51,255,153));
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
			//Label
		JLabel account_enquiry = new JLabel("Account Enquiry: ");
		account_enquiry.setBounds(270,120,120,25);
		panel.add(account_enquiry);
		
		JLabel account_number_text = new JLabel("Account Number: ");
		account_number_text.setBounds(10+300,120+50,120,25);
		panel.add(account_number_text);
		
			//Text field
		account_number_field = new JTextField(20);
		account_number_field.setBounds(140+300,120+50,165,25);
		panel.add(account_number_field);
		account_number_field.setBorder(emptyBorder);
		
		
		JLabel withdraw_text = new JLabel("Debit: ");
		withdraw_text.setBounds(10+300,150+50,120,25);
		panel.add(withdraw_text);
		
		withdraw_field = new JTextField(20);
		withdraw_field.setBounds(140+300,150+50,165,25);
		panel.add(withdraw_field);
		withdraw_field.setText("0");
		withdraw_field.setBorder(emptyBorder);
		
		JLabel credit_text = new JLabel("Credit: ");
		credit_text.setBounds(10+300,180+50,120,25);
		panel.add(credit_text);
		
		
		credit_field = new JTextField(20);
		credit_field.setBounds(140+300,180+50,165,25);
		panel.add(credit_field);
		credit_field.setText("0");
		credit_field.setBorder(emptyBorder);
		
				//Button1
		JButton button1 = new JButton(" Find ");
		button1.setBounds(100+300,230+50,80,25);
		panel.add(button1);
		button1.setActionCommand("1");
		button1.addActionListener(this);
		button1.setBorder(emptyBorder);  
				
				//Switch screen Button1
		JButton switch1 = new JButton(" Create Account-> ");
		switch1.setBounds(100+300,330+50,180,25);
		panel.add(switch1);
		switch1.setActionCommand("3");
		switch1.addActionListener(this);
		switch1.setBorder(emptyBorder);
		
				//Create account
		JLabel account_create = new JLabel("Create Account: ");
		account_create.setBounds(270,120,120,25);
		panel1.add(account_create);
		
		
		JLabel new_account_number = new JLabel("Account Number: ");
		new_account_number.setBounds(10+300,100+50,120,25);
		panel1.add(new_account_number);
		
		new_account_number_field = new JTextField(20);
		new_account_number_field.setBounds(140+300,100+50,165,25);
		panel1.add(new_account_number_field);
		new_account_number_field.setBorder(emptyBorder);
		
		JLabel new_account_first_name = new JLabel("First Name: ");
		new_account_first_name.setBounds(10+300,130+50,120,25);
		panel1.add(new_account_first_name);
		
		new_account_first_name_field = new JTextField(20);
		new_account_first_name_field.setBounds(140+300,130+50,165,25);
		panel1.add(new_account_first_name_field);
		new_account_first_name_field.setBorder(emptyBorder);
		
		JLabel new_account_last_name = new JLabel("Last Name: ");
		new_account_last_name.setBounds(10+300,160+50,220,25);
		panel1.add(new_account_last_name);
		
		new_account_last_name_field = new JTextField(20);
		new_account_last_name_field.setBounds(140+300,160+50,165,25);
		panel1.add(new_account_last_name_field);
		new_account_last_name_field.setBorder(emptyBorder);
		
		JLabel new_account_address = new JLabel("Address: ");
		new_account_address.setBounds(10+300,190+50,220,25);
		panel1.add(new_account_address);
		
		new_account_address_field = new JTextField(20);
		new_account_address_field.setBounds(140+300,190+50,165,25);
		panel1.add(new_account_address_field);
		new_account_address_field.setBorder(emptyBorder);
		
		JLabel new_account_aadhar = new JLabel("Aadhar Number: ");
		new_account_aadhar.setBounds(10+300,220+50,220,25);
		panel1.add(new_account_aadhar);
		
		new_account_aadhar_field = new JTextField(20);
		new_account_aadhar_field.setBounds(140+300,220+50,165,25);
		panel1.add(new_account_aadhar_field);
		new_account_aadhar_field.setBorder(emptyBorder);
		
		JLabel new_account_amount = new JLabel("Initial Credit: ");
		new_account_amount.setBounds(10+300,250+50,120,25);
		panel1.add(new_account_amount);
		
		new_account_amount_field = new JTextField(20);
		new_account_amount_field.setBounds(140+300,250+50,165,25);
		panel1.add(new_account_amount_field);
		new_account_amount_field.setText("0");
		new_account_amount_field.setBorder(emptyBorder);
		
				//Button2
		JButton button2 = new JButton(" Create ");
		button2.setBounds(100+300,280+50,80,25);
		panel1.add(button2);
		button2.setActionCommand("2");
		button2.addActionListener(this);
		button2.setBorder(emptyBorder);
		
				//Switch screen Button2
		JButton switch2 = new JButton(" <-Account Enquiry ");
		switch2.setBounds(100+300,330+50,180,25);
		panel1.add(switch2);
		switch2.setActionCommand("4");
		switch2.addActionListener(this);
		switch2.setBorder(emptyBorder);
		
		
		try {
			myPicture = ImageIO.read(new File("fakery.png"));
			newImage = myPicture.getScaledInstance(250, 150, Image.SCALE_DEFAULT);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(newImage));
		panel.add(picLabel);
		JLabel picLabel1 = new JLabel(new ImageIcon(newImage));
		panel1.add(picLabel1);
		picLabel1.setBounds(10, 140, 250, 150);
		picLabel.setBounds(10, 140, 250, 150);
		
				//Label
		label = new JLabel("");
		label.setBounds(50+300,370+50,800,25);
		panel.add(label);
		
		frame.setSize(1000,500);
		frame.setVisible(true);
		
		frame1.setSize(1000,500);
		frame1.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if("1".equals(e.getActionCommand()))
		{
			JSONParser parser = new JSONParser();
	        try {
				JSONObject data1 = (JSONObject) parser.parse(new FileReader("client.json"));
				JSONObject data2 = (JSONObject) data1.get(account_number_field.getText());
				
				JSONObject data3 = data2;
				String temp_amount_1 = data3.get("Amount").toString();
				int temp_amount = Integer.parseInt(temp_amount_1) - Integer.parseInt(withdraw_field.getText()) + Integer.parseInt(credit_field.getText());
				int temp_amount_2 = - Integer.parseInt(withdraw_field.getText()) + Integer.parseInt(credit_field.getText());
				if(temp_amount<0)
				{
					JOptionPane.showMessageDialog(frame, "Insufficient funds");
					withdraw_field.setText("0");
					credit_field.setText("0");
				}
				else
				{	
					if(temp_amount_2 != 0)
					{
					 int x = JOptionPane.showConfirmDialog(frame,"The account - " + account_number_field.getText() + "  with balance " + temp_amount_1 +  " will be changed to: "  + temp_amount,"Query",JOptionPane.YES_NO_OPTION);
					 if(x == JOptionPane.YES_OPTION)
					 {
						 data2.put("Amount",temp_amount);
						 FileWriter file = new FileWriter("client.json");
					     file.write(data1.toJSONString());
					     file.flush();
					     file.close();
					     withdraw_field.setText("0");														
					     credit_field.setText("0");
					 }
					}
				}
				String display_data = "Name: " + data2.get("First_name") + " " + data2.get("Last_name") + "\n Address: " + data2.get("Address") +"\nAmount: " + data2.get("Amount");
				account_number_field.setText("");
				JOptionPane.showMessageDialog(frame, display_data);
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(frame,"No Account");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame,"No Account");
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(frame,"No Account");
			}catch(Exception e1){
	        	JOptionPane.showMessageDialog(frame,"No Account");
	        }
	        
		}
		
		else if("2".equals(e.getActionCommand()))
		{
			 int x = JOptionPane.showConfirmDialog(frame,"Do you want to create the Account","Query",JOptionPane.YES_NO_OPTION);
			 if(x == JOptionPane.YES_OPTION)
			 {
				 try {
					 	//Password pop up
					 JPasswordField temp_password = new JPasswordField();
					 int temp_waste = JOptionPane.showConfirmDialog(null, temp_password, "Employee Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					 String temp_password_field = String.valueOf(temp_password.getPassword());
					
					 if(temp_password_field.equals("123"))
					 {
						 Banking temp2 = new Banking();
						 int value1 = Integer.parseInt(new_account_number_field.getText());
						 String value2 = new_account_first_name_field.getText();
						 String value3 = new_account_last_name_field.getText();
						 String value4 = new_account_address_field.getText();
						 String value5 = new_account_aadhar_field.getText();
						 int value6 = Integer.parseInt(new_account_amount_field.getText());
						 new_account_number_field.setText("");
						 new_account_first_name_field.setText("");
						 new_account_last_name_field.setText("");
						 new_account_address_field.setText("");
						 new_account_aadhar_field.setText("");
						 new_account_amount_field.setText("0");
						 temp2.json_add(value1,value2,value3,value4,value5,value6);
						 JOptionPane.showMessageDialog(frame,"Account Created: \nAccount Number: " + value1 + "\nName: " + value2 + value3 + "\nAddress: " + value4 + "\nAadhar: " + value5 +"\nAmount: " + value6);
					 }
					 else {
						 JOptionPane.showMessageDialog(frame,"Error","Wrong Password",JOptionPane.ERROR_MESSAGE);
					 }
				 
				 }
				 catch(Exception e2){
					 JOptionPane.showMessageDialog(frame,"Error","Error Message",JOptionPane.ERROR_MESSAGE);
				 }
			 }
		}
		else if("3".equals(e.getActionCommand()))
		{
			frame.setVisible(false);
			frame1.setVisible(true);
		}
		else if("4".equals(e.getActionCommand()))
		{
			frame.setVisible(true);
			frame1.setVisible(false);
		}
		
	}
}
