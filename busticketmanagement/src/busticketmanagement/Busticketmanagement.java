/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busticketmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import busticketmanagement.intro;
import javax.swing.JFrame;
/**
 *
 * @author Marina
 */
public class Busticketmanagement {

    /**
     //@param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InputMismatchException, ClassNotFoundException{
        // TODO code application logic here
        new Database();
       JFrame w1;
        w1 = new intro();
         // EventQueue.invokeLater((Runnable) new runnable(){
           //Routes r=new Routes();
               //
       /* Bus b=new Bus();
        Ticket t=new Ticket();
        Payment p=new Payment();
        Cash c$=new Cash();
        Visa v= new Visa();
        Admin a = new Admin();
         c.registerCustomer();
      c.login();
      
      
     
      
    // Admin a = new Admin();
    // a.AddRoute();
     
     //cu.registerCustomer();
     
       
       // c.writeData();
       
        //p.way();*/

  }

}
