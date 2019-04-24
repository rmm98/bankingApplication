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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transactions extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    Transactions()
    {
        setFont(new Font("System",Font.BOLD,22));
        setTitle("Transaction");
        
        l1 = new JLabel("Please select your Transaction");
        l1.setFont(new Font("System",Font.BOLD,38));
        
        b1 = new JButton("Deposit");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cash Withdrawal");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Fast Cash");
        b3.setFont(new Font("System",Font.BOLD,18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Mini Statement");
        b4.setFont(new Font("System",Font.BOLD,18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("Pin Change");
        b5.setFont(new Font("System",Font.BOLD,18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("Balance Enquiry");
        b6.setFont(new Font("System",Font.BOLD,18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("Exit");
        b7.setFont(new Font("System",Font.BOLD,18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(100,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,470,300,60);
        add(b6);
        
        b7.setBounds(240,600,300,60);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            new Deposit().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == b2)
        {
            new Withdrawal().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == b3)
        {
            new FastCash().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == b4)
        {
            new Login().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == b5)
        {
            new PinChange().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == b6)
        {
            String pin = JOptionPane.showInputDialog("Enter PIN");
            Conn ob = new Conn();
            try
            {
                ResultSet rs = ob.stm.executeQuery("select balance from bank where pin = '"+pin+"'");
                if(rs.next())
                {
                    rs.last();
                    double balance = rs.getDouble("balance");
                    JOptionPane.showMessageDialog(null,"Your account balance is "+balance);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b7)
        {
            System.exit(0);
        }
        
    }
    
    //To Test
    public static void main(String args[])
    {
        new Transactions().setVisible(true);
    }
}
