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

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    
    PinChange()
    {
        setFont(new Font("System",Font.BOLD,22));
        setTitle("PIN Change");
        
        l1 = new JLabel("Change your PIN");
        l1.setFont(new Font("System",Font.BOLD,35));
        
        l2 = new JLabel("Current PIN");
        l2.setFont(new Font("System",Font.BOLD,22));
        
        l3 = new JLabel("New PIN");
        l3.setFont(new Font("System",Font.BOLD,22));
        
        l4 = new JLabel("Confirm New PIN");
        l4.setFont(new Font("System",Font.BOLD,22));
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway",Font.BOLD,22));
        
        t3 = new JPasswordField();
        t3.setFont(new Font("Raleway",Font.BOLD,22));
        
        b1 = new JButton("Save");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        
        l1.setBounds(320,130,800,60);
        add(l1);
        
        l2.setBounds(100,240,150,40);
        add(l2);
        
        l3.setBounds(100,300,150,40);
        add(l3);
        
        l4.setBounds(100,360,200,40);
        add(l4);
        
        t1.setBounds(310,240,360,40);
        add(t1);
        
        t2.setBounds(310,300,360,40);
        add(t2);
        
        t3.setBounds(310,360,360,40);
        add(t3);
        
        b1.setBounds(220,460,160,50);
        add(b1);
        
        b2.setBounds(400,460,160,50);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String oldpin = t1.getText();
            String newpin = t2.getText();
            String conpin = t3.getText();
            
            if(ae.getSource() == b1)
            {
                if(t1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Please Enter current pine");
                if(t2.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Enter new pin");
                if(t3.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Re-enter new pin");
                if(t3.getText().equals(t2.getText()))
                {
                    Conn ob = new Conn();
                    //String sql1 = "update bank set pin = '"+newpin+"' where pin = '"+oldpin+"'";
                    //String sql2 = "update login set pin = '"+newpin+"' where pin = '"+oldpin+"'";
                    String sql3 = "update coreuserdetails set pin = '"+newpin+"' where pin = '"+oldpin+"'";
                    
                    //ob.stm.executeUpdate(sql1);
                    //ob.stm.executeUpdate(sql2);
                    ob.stm.executeUpdate(sql3);
                    
                    JOptionPane.showMessageDialog(null,"PIN changed successfully!");
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null,"PIN entered doesn't match");
            }
            else if(ae.getSource() == b2)
            {
                new Transactions().setVisible(true);
                setVisible(false);
            }
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //To test
    public static void main(String args[])
    {
        new PinChange().setVisible(true);
    }
}
