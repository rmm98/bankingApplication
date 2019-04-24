/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author Reevan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
   JLabel l1,l2,l3;
   JTextField tf1;
   JPasswordField pf1; 
   JButton b1,b2,b3;
   
   public Login()
   {
       //Keeping header at center (If default then use super("Heading_name");)
//       setFont(new Font("System",Font.BOLD,22));
//       Font f = getFont();
//       FontMetrics fm = getFontMetrics(f);
//       int x = fm.stringWidth("AUTOMATED TELLER MACHINE");
//       int y = fm.stringWidth(" ");
//       int z = getWidth() - x;
//       int w = z/y;
//       String pad = "";
//       pad = String.format("%"+w+"s",pad);
//       setTitle(pad+"AUTOMATED TELLER MACHINE");
       setTitle("AUTOMATED TELLER MACHINE");
       
       //Adding the components declared
       l1 = new JLabel("WELCOME TO ATM");
       l1.setFont(new Font("Osward",Font.BOLD,30));
       
       l2 = new JLabel("Card No : ");
       l2.setFont(new Font("Raleway",Font.BOLD,20));
       
       l3 = new JLabel("PIN : ");
       l3.setFont(new Font("Raleway",Font.BOLD,20));
       
       tf1 = new JTextField(15);
       pf1 = new JPasswordField(15);
       
       b1 = new JButton("LOGIN");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       
       b2 = new JButton("CLEAR");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       
       b3 = new JButton("NEW USER");
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       
       setLayout(null);
       
       l1.setBounds(175,50,450,200);
       add(l1);
       
       l2.setBounds(125,150,375,200);
       add(l2);
       
       l3.setBounds(125,225,375,200);
       add(l3);
       
       tf1.setFont(new Font("Arial",Font.BOLD,14));
       tf1.setBounds(300,235,230,30);
       add(tf1);
       
       pf1.setFont(new Font("Arial",Font.BOLD,14));
       pf1.setBounds(300,310,230,30);
       add(pf1);
       
       b1.setFont(new Font("Arial",Font.BOLD,14));
       b1.setBounds(300,400,100,30);
       add(b1);
       
       b2.setFont(new Font("Arial",Font.BOLD,14));
       b2.setBounds(430,400,100,30);
       add(b2);
       
       b3.setFont(new Font("Arial",Font.BOLD,14));
       b3.setBounds(300,450,230,30);
       add(b3);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(750,750);
       setLocation(500,200);
       setVisible(true);
   } 
   
   @Override
   public void actionPerformed(ActionEvent ae)
   {
       try
       {
           Conn ob = new Conn();
           String cardno = tf1.getText();
           String pin = pf1.getText();
           String sql = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
           ResultSet rs = ob.stm.executeQuery(sql);
           
           if(ae.getSource() == b1)
           {
               if(rs.next())
               {
                   new Transactions().setVisible(true);
                   setVisible(false);
               }
               else
                   JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN");
           }
           
           else if(ae.getSource() == b2)
           {
               tf1.setText("");
               pf1.setText("");
           }
           
           else if(ae.getSource() == b3)
           {
               new SignUp().setVisible(true);
               setVisible(false);
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
           System.out.println("Error: "+e);
       }
   }
   
   //To test
   public static void main(String args[])
   {
       new Login();
   }
}


