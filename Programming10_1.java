/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming10_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class Programming10_1 implements ActionListener
{
    JLabel heading,lpub_id,lpub_name,lphone,laddress,lcity,lstate,lzip;
    JTextField pub_idField,pub_nameField,phoneField,addressField,cityField,stateField,zipField;
    JButton insert,exit;
    Connection con;
    Statement stmt;
    PreparedStatement stat;
    ResultSet rs;
    JPanel p1;
    JFrame f1;
    
    public Programming10_1()
    {
        try
        {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NewLibrary;user=admin;password=shaoli");
             stmt=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
        }
    }
    
    public void compshow()
    {
        f1=new JFrame("PUBLISHERS");
        p1=new JPanel();
        heading=new JLabel("PUBLISHER'S INFORMATION");
        
        lpub_id=new JLabel("Publisher's ID:");
        lpub_name=new JLabel("Publisher's Name:");
        lphone=new JLabel("Phone Number:");
        laddress=new JLabel("Address:");
        lcity=new JLabel("City:");
        lstate=new JLabel("State:");
        lzip=new JLabel("Zip:");
        
        pub_idField=new JTextField(6);
        pub_nameField=new JTextField(50);
        phoneField=new JTextField(15);
        addressField=new JTextField(50);
        cityField=new JTextField(50);
        stateField=new JTextField(50);
        zipField=new JTextField(20);
        
        insert=new JButton("Insert");
        exit=new JButton("Exit");
        
        p1.setLayout(null);
        heading.setBounds(250,35,200,40);
        p1.add(heading);
        
        lpub_id.setBounds(75,90,200,30);
        pub_idField.setBounds(400,90,100,25);
        p1.add(lpub_id);
        p1.add(pub_idField);
        
        lpub_name.setBounds(75,120,200,30);
        pub_nameField.setBounds(400,120,200,25);
        p1.add(lpub_name);
        p1.add(pub_nameField);
        
        lphone.setBounds(75,150,200,30);
        phoneField.setBounds(400,150,150,25);
        p1.add(lphone);
        p1.add(phoneField);
        
        laddress.setBounds(75,180,200,30);
        addressField.setBounds(400,180,250,25);
        p1.add(laddress);
        p1.add(addressField);
        
        lcity.setBounds(75,210,200,30);
        cityField.setBounds(400,210,200,25);
        p1.add(lcity);
        p1.add(cityField);
        
        lstate.setBounds(75,240,200,30);
        stateField.setBounds(400,240,200,25);
        p1.add(lstate);
        p1.add(stateField);
        
        lzip.setBounds(75,270,200,30);
        zipField.setBounds(400,270,200,25);
        p1.add(lzip);
        p1.add(zipField);
        
        insert.setBounds(175,350,100,30);
        exit.setBounds(325,350,100,30);
        p1.add(insert);
        p1.add(exit);
        
        f1.add(p1);
        f1.setSize(680,500);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        insert.addActionListener(this);
        exit.addActionListener(this);
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand()=="Exit")
        {
            System.exit(0);
        }
        
        if(ae.getActionCommand()=="Insert")
        {
            if(!pub_idField.getText().equals(""))
            {
                try
                {
                    stat=con.prepareStatement("INSERT INTO Publishers VALUES(?,?,?,?,?,?,?)");
                    String pid=pub_idField.getText();
                    String pname=pub_nameField.getText();
                    String pphone=phoneField.getText();
                    String paddress=addressField.getText();
                    String pcity=cityField.getText();
                    String pstate=stateField.getText();
                    String pzip=zipField.getText();
                    
                    
                    stat.setString(1, pid);
                    stat.setString(2, pname);
                    stat.setString(3, pphone);
                    stat.setString(4, paddress);
                    stat.setString(5, pcity);
                    stat.setString(6, pstate);
                    stat.setString(7, pzip);
                    
                    stat.executeUpdate();
                    
                    pub_idField.setText("");
                    pub_nameField.setText("");
                    phoneField.setText("");
                    addressField.setText("");
                    cityField.setText("");
                    stateField.setText("");
                    zipField.setText("");
                    JOptionPane.showMessageDialog(f1,"Information has been inserted.","Information",JOptionPane.INFORMATION_MESSAGE);
                }
                
                catch(Exception e)
                {
                    String msg=e.getMessage();
                    
                    if(e.getMessage().equals(msg))
                    {
                        JOptionPane.showMessageDialog(f1,"Record already exists.","Warning Message",JOptionPane.WARNING_MESSAGE);
                        pub_idField.setText("");
                        pub_nameField.setText("");
                        phoneField.setText("");
                        addressField.setText("");
                        cityField.setText("");
                        stateField.setText("");
                        zipField.setText("");
                    }
                }
            }
            else
            {
                 JOptionPane.showMessageDialog(f1,"Please fill the details properly.","Error Message",JOptionPane.ERROR_MESSAGE);
                       
            }
        
        }
    }
    

    public static void main(String[] args) 
    {
        
        Programming10_1 obj=new Programming10_1();
        obj.compshow();
       
    }
    
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
   
