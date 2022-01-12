/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;

import busticketmanagement.Ticket.lastpage;
import busticketmanagement.Visa.VisaWindow;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 *
 * @author Marina
 */
public class Payment implements Serializable {
    
private double amount;
    private String Ways_Of_Payment;
    Scanner in = new Scanner(System.in);

    public Payment(ButtonModel selection) {
       
    }
    public double getAmount()
    {
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount=amount;
    }
    public void setway(String way)
    {
        this.Ways_Of_Payment=way;
    }
    public String getway()
    {
        return Ways_Of_Payment;
    }
     static class PaymentWindow extends JFrame implements ActionListener  {

        static JFrame window;

        public static void open() throws IOException, FileNotFoundException, ClassNotFoundException {
            window = new PaymentWindow();
        }
         JLabel PaymentMethod= new JLabel("Payment Method");
         JRadioButton Visa =new JRadioButton("Visa");
         JRadioButton Cash =new JRadioButton("Cash");
         ButtonGroup choice=new ButtonGroup();
         JButton pay=new JButton("Pay");
        public PaymentWindow(){
            GridLayout grid = new GridLayout(10,10, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);

            add(PaymentMethod);
            add(Visa);
            add(Cash);
            choice.add(Visa);
            choice.add(Cash);
            add(pay);
            
            pay.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
           
            // this.info = new ArrayList();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(pay)) {
                Database.Payment = new ArrayList<>();
               
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(Visa.isSelected()){
                    setVisible(false);
                Visa v = new Visa();
               
                }
                if(Cash.isSelected()){
                    int input = JOptionPane.showOptionDialog(null, "Please pay the required amount to the driver", "Cash payment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if(input == JOptionPane.OK_OPTION)
                            {
                               setVisible(false);
                               lastpage l = new lastpage();
                               l.setVisible(true);
                                   return;
                             }
                   
                }

                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                
              
            
        }
        }


    }
    
}