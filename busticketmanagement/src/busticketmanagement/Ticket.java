/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.applet.*;
/**
 *
 * @author Mayar
 */
public class Ticket {
     private int SeatNO;
   private Time time;
   private java.util.Date date;
   
   public Ticket()
   { 
       
   }
   public void setSeatNO(int seatno)
   {
       this.SeatNO=seatno;
   }
   public int getSeatNO()
   {
       return SeatNO;
   }
   public void setDate(java.util.Date date){
       this.date = date;
   }
   public java.util.Date getdate (){
       return date;
   }
   public void setTime(Time time){
       this.time = time;
   }
   public Time getTime(){
       return time;
   }
  static class lastpage extends JFrame implements ActionListener { 
      JButton viewT=new JButton("View your ticket");
      JButton comp=new JButton("Do you have a suggestion or a complain?");
      JLabel done=new JLabel("your ticket is booked successfully");
     
      
   lastpage(){
      setSize(800,400);
      GridLayout grid = new GridLayout(10,10, 10, 10);  
      setLayout(grid);
      GridBagConstraints g = new GridBagConstraints();
      g.insets = new Insets(10, 10, 10, 10);
      done.setFont(new Font("Verdana", Font.BOLD,18));
      add(done);
      g.gridx = 1;
      g.gridy = 0;
      add(viewT,g);
      g.gridx = 5;
      g.gridy = 0;
      add(comp,g);
      viewT.addActionListener(this);
      comp.addActionListener(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
  }
      
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(viewT)){
                setVisible(false);
                    
            }
            if(e.getSource().equals(comp)){
                
            }
        }
   
   
   
   
  }
}
