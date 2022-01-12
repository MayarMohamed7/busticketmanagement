/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;

import static busticketmanagement.Customer.SearchByPhoneNumber;
import busticketmanagement.Routes.RouteWindow;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author Marina
 */
public class Admin extends JFrame implements ActionListener{
  // ArrayList<String> PickUpPoints=new ArrayList<>();
    //ArrayList<String> DroppingPoint=new ArrayList<>();  
    //added another list 3asahn myhslsh conflict
    //ArrayList<String> routes = new ArrayList<>();
    //Routes R = new Routes();
        JFrame w1;
        JLabel enter = new JLabel ("Enter");
        JButton addpickup= new JButton("add pickup point");
        JButton deletepickup= new JButton("delete pickup point");
        JButton viewcus=new JButton("View Customers");
        JTextField textfield = new JTextField();
        //JTextField ans = new JTextField();
     public Admin(){
         GridLayout grid = new GridLayout(10,10, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);
            add(enter);
            add(textfield);
            add(addpickup);
            //add(ans);
            addpickup.addActionListener(this);
            deletepickup.addActionListener(this);
            viewcus.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
            add(deletepickup);
            add(viewcus);
            
            
            
     
    
     }
     

   /* public void viewcus(int phoneno){
        phoneno = Integer.parseInt(textfield.getText());
        boolean = false;
        for()
    }*/

   
    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException{
        if(e.getSource().equals(addpickup)){
            try{ 
                
                
           
           // r.combobox1.addItem(addp.getText());
            //r.val = addp.getText();
    
              
            }
            catch (NullPointerException ex){
                
            }
          
}
        if(e.getSource().equals(viewcus)){
              String val = textfield.getText();  
              Customer c = SearchByPhoneNumber(val);
              //ans.setText();
             // c.SearchByPhoneNumber(val);
                
          }
  
     
     
   
}
}