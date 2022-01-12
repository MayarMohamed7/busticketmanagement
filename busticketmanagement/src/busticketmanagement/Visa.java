/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;
import busticketmanagement.Ticket.lastpage;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Mayar
 */
public class Visa implements Serializable{
      private long cardNO;
    private String CardHolder;
    private int CVV;
    //private java.util.Date expdate;
    private String expdate;
    
    public void setcardNo(long cardNO){
        this.cardNO = cardNO;
    }
    public long getcardNO(){
        return cardNO;
    }
    public void setcardHolder(String CardHolder){
        this.CardHolder = CardHolder;
    }
     public String getcardHolder(){
        return CardHolder;
    }
    public void setCVV(int CVV){
        this.CVV = CVV;
    }
    public int getCVV(){
        return CVV;
    }
    /*public void setexpDate(java.util.Date expdate){
        this.expdate = expdate;
        
    }*/
   /* public java.util.Date getexpDate(){
        return expdate;
    }*/
    public void setexpdate(String expdate){
        this.expdate = expdate;
    }
    public String getexpdate(){
        return expdate;
    }
    public Visa(){
        JFrame w1;
        w1 = new VisaWindow();
    }
    static class VisaWindow extends JFrame implements ActionListener{
         JLabel Cardno = new JLabel("Card Number *");
        JTextField Cardn = new JTextField(16);
          JLabel Cardname = new JLabel("Card holder name *");
        JTextField Cardnam = new JTextField(20);
          JLabel cvv = new JLabel("CVV *");
        JTextField cv = new JTextField(3);
          JLabel exp = new JLabel("expiration date in this format (MM/YY) *");
        JTextField expd= new JTextField(5);
        JButton done = new JButton("Done");
        public VisaWindow(){
             GridLayout grid = new GridLayout(5,2, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);
            add(Cardno);
            add(Cardn);
            add(Cardname);
            add(Cardnam);
            add(cvv);
            add(cv);
            add(exp);
            add(expd);
            add(done);
            done.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(done)){
                setVisible(false);
                    lastpage l = new lastpage();
                    l.setVisible(true);
            }
        }
        
    }
    public void info(){
        Scanner in = new Scanner (System.in);
            System.out.println("Enter card number: ");
            cardNO = in.nextLong();
            in.nextLine(); //to return the input that was once skipped
            System.out.println("Enter card holder name: ");  
            CardHolder = in.nextLine();
            System.out.println("Enter CVV: ");
             CVV = in.nextInt();
             System.out.println("Enter expiration date in this format (mm/yy)");
             expdate = in.next();
           /* System.out.println("Enter expiration date (dd//mm//yy): ");
             SimpleDateFormat fo = new SimpleDateFormat("dd/mm/yy");
             fo.format(expdate);*/
    }

    public void actionPerformed(ActionEvent e) {
                
                
    }
    
}
