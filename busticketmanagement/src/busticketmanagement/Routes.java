/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;

import busticketmanagement.Payment.PaymentWindow;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static project.Database.save;


/**
 *
 * @author Mayar
 */
  public class Routes extends JFrame implements Serializable {
     private String pickuppoint;
    private String dest;
     private String day;
      private String time;

    

    public void setPickuppoint(String pickuppoint) {
        this.pickuppoint = pickuppoint;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPickuppoint() {
        return pickuppoint;
    }

    public String getDest() {
        return dest;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
      

    public Routes() {
       JFrame window;
        window = new RouteWindow();
    }

   public Routes(Object selectedItem, Object selectedItem0) {
        
   
        
}

    

    
        
    
    static class RouteWindow extends JFrame implements ActionListener {
         public Admin a;
         
             public String val;
             
                 /*public void addpickp(String val){
                     combobox1.addItem(val);
                 }*/
          JLabel price= new JLabel("The standard price of our ticket is 120 EGP");
          
         JLabel PickUpPoint= new JLabel("Pick Up Point");
         JComboBox combobox1=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
         JLabel Destination= new JLabel("Destination");
         JComboBox combobox2=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
     
         JLabel Day= new JLabel ("Day");
         JComboBox combobox3=new JComboBox((new String[] {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"}));
         JLabel Time= new JLabel ("when");
         JComboBox combobox4=new JComboBox((new String[] {"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"}));
         
        JButton Next = new JButton("Next");
        public RouteWindow(){
            GridLayout grid = new GridLayout(10, 10, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);
            add(price);
            price.setFont(new Font("Verdana", Font.BOLD,18));
            add(PickUpPoint);
            add(combobox1);
           // combobox1.setEditable(true);
            add(Destination);
            add(combobox2);
            //combobox2.setEditable(true);
            add(Day);
            add(combobox3);
            add(Time);
            add(combobox4);
            add(Next);
            Next.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
            
           
            // this.info = new ArrayList();
        }
        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource().equals(Next)) {
                if(combobox1.getSelectedItem()==combobox2.getSelectedItem())
            {
                 JOptionPane.showMessageDialog(this, "Please select different locations");
                 return;
            }
                
                Database.routes = new ArrayList<>();
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
                }
                Routes newRoutes;
                
                newRoutes = new Routes(combobox1.getSelectedItem(),combobox2.getSelectedItem());
               

                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                
                setVisible(false);
                PaymentWindow p = new PaymentWindow();
                p.setVisible(true);
            }
        }
        }
/*public class Routes extends JFrame implements Serializable {

    private String Route;
    

    //private String CurrentLoction;
    static class Display extends JFrame implements ActionListener
            
    { static JFrame window2;
        public static void openn()
    {
       window2 = new Routes();
    }
         
       
        
        JLabel PickUpPoint= new JLabel("Pick Up Point");
        JComboBox combobox=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
        JButton ok=new JButton("ok");
        
        public Display(){
             GridLayout grid = new GridLayout(7, 2, 10, 10);
            setLayout(grid);
       
       
        add(PickUpPoint);
        add(combobox);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(ok);
        setSize(800, 400);
        setVisible(true);
            }
        @Override
        public void actionPerformed(ActionEvent e) {
 if (e.getSource().equals(ok)) {
     window2.setVisible(false);
                Payment p = new Payment();
                p.setVisible(true);
 }
        }
    
    }
    public void setRoute(String Route) {
        this.Route = Route;
    }

    public String getRoute() {
        return Route;
    }
*/
    

    /* public void AddRoute() throws FileNotFoundException, IOException {
        
        System.out.println("Please enter the route you wish to add in this format (pickup point-dropping point)");
        Route = in.nextLine();
        //routes.add(Route);//in.nextLine 3ashan yakhod with the space kman

        FileWriter fw = new FileWriter("Routes.txt", true);//true is for the boolean so it could append 
        try (PrintWriter out = new PrintWriter(fw)) {
            System.out.println(System.lineSeparator());
            out.print(Route + System.lineSeparator());

        } finally {
            fw.close();//mafesh line geded-size leeh zero?
        }
    }*/
}