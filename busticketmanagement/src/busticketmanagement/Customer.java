/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;
import busticketmanagement.Routes.RouteWindow;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
//import project.Routes.RouteWindow;

/**
 *
 * @author Marina
 */

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
//public static Customer activeCustomer;
    private String fname;
    private String lname;
    private String phoneNumber;

    private String pass;
    private Visa v;

    public Customer() {
        JFrame window1;
        window1 = new Register();

    }
    //public ArrayList <String> info;
    public Customer(String fname, String lname, String phoneNumber, String pass) {
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;

        this.pass = pass;
    }

    public String getfname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    

    public String getlname() {
        return lname;
    }

    public String getnum() {
        return phoneNumber;
    }

    public String getpass() {
        return pass;
    }

    /*public void setpass(int pass) {
        this.pass = pass;
    }
    public int getpass() {
        return pass;
    }*/
    // ArrayList <String> Customers = new ArrayList<>();
    public void registerCustomer() throws IOException, FileNotFoundException, ClassNotFoundException {
        /*FileReader re = new FileReader("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt");
        re.read();
        System.out.println("Enter your first name: ");
        fname = in.nextLine();
        System.out.println("Enter your last name: ");
        lname = in.nextLine();
        System.out.println("Enter your age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = in.nextLine();
        /*System.out.println("Enter your password in 4 numbers: ");
        pass = in.nextInt();*/

        new Database();
        //info.add(getfname()+" "+ getlname()+" " + getage()+" " + getnum()+" " + getpass()+" ");
        /*File Cusromer = new File("C:\\Users\\Marina\\OneDrive\\Desktop");
        FileWriter fw = new FileWriter("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt", true);//true is for the boolean so it could append 
        try ( PrintWriter out = new PrintWriter(fw)) {
            out.print(info);
        }*/
    }

    /* public void login() throws FileNotFoundException, IOException {
        System.out.println("Enter your phone number to login: ");
        Scanner in = new Scanner(System.in);
        long pn = in.nextLong();
        if (pn == 123456789) {
            System.out.println("Please enter your password: ");
            int pa = in.nextInt();
            if (pa == 1234) {
                System.out.println("Hi, Admin");
                Admin a = new Admin();
                a.AddRoute();
            }
        } else {
            File reader = new File("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt");
            Scanner re = new Scanner(reader);
            while (re.hasNext()) {
                String s = re.next();
                //System.out.println(s);
                if (s.equals(pn)) {
                    System.out.println("Please enter your password: ");
                    int pa = in.nextInt();
                }
            }
        }
    }*/
    class Register extends JFrame implements ActionListener {

        JLabel FirstName = new JLabel("First Name *");
        JTextField fn = new JTextField(10);
        JLabel LastName = new JLabel("Last Name *");
        JTextField ln = new JTextField(10);
        JLabel PhoneNumber = new JLabel("Phone Number *");
        JTextField pn = new JTextField(11);
        JLabel password = new JLabel("password *");
        JTextField p = new JTextField();
        JButton save = new JButton("Save");

        public Register() {
            GridLayout grid = new GridLayout(7, 2, 10, 10);
            setLayout(grid);

            add(FirstName);
            add(fn);
            add(LastName);
            add(ln);
            add(PhoneNumber);
            add(pn);
            add(password);
            add(p);
            add(save);
            save.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(800, 400);
            setVisible(true);
            // this.info = new ArrayList();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           fname= fn.getText();
           lname = ln.getText();
           phoneNumber = pn.getText();
           pass = p.getText();
            if (e.getSource().equals(save)) {
                if ("".equals(fname) || "".equals(lname) || "".equals(phoneNumber) || "".equals(pass)){
                    JOptionPane.showMessageDialog(null, "*required field*", "Alert", JOptionPane.WARNING_MESSAGE);

                   
                    return;
                }
                for (int i = 0; i < fname.length(); i++) {
                    {
                        boolean flag1 = Character.isDigit(fn.getText().charAt(i));
                        if (flag1) {
                            JOptionPane.showMessageDialog(this, "Name must be required in charcters", "Alert", JOptionPane.WARNING_MESSAGE);
                            return;

                        }

                    }
                }
                for (int x = 0; x < lname.length(); x++) {
                    
                        boolean flag2 = Character.isDigit(ln.getText().charAt(x));
                        if (flag2) {
                            JOptionPane.showMessageDialog(this, "Name must be required in charcters", "Alert", JOptionPane.WARNING_MESSAGE);
                            return;

                        }

                    
                }
                for (int j = 0; j < phoneNumber.length(); j++) {
                    
                        boolean flag3 = Character.isDigit(pn.getText().charAt(j));
                        if (!flag3 || pn.getText().length() != 11 || pn.getText().length() > 11) {
                            JOptionPane.showMessageDialog(this, "Phone Number must consist of 11 numbers", "Alert", JOptionPane.WARNING_MESSAGE);
                            return;

                        }

                    
                }
                
                        if (pass.length() < 6 ) {
                            JOptionPane.showMessageDialog(this, "Weak password", "Alert", JOptionPane.WARNING_MESSAGE);
                            return;

                        }

                 
                //if(pn.getText())
                Database.customers.add(new Customer(fname, lname, phoneNumber, pass));
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                setVisible(false);
                Homepage h = new Homepage();
                h.setVisible(true);
            }
        }

    }

    public static Customer SearchByPhoneNumber(String key) {
        for (Customer i : Database.customers) {
            if (i.phoneNumber.equals(key)) {
                return i;
            }

        }
        return null;
    }

    public static Customer Login(String key1, String key2) {
        Customer c = SearchByPhoneNumber(key1);
        if (c == null) {
            return null;
        }
        if (c.pass.equals(key2)) {
            //Customer.activeCustomer = c;
            return c;
        }
        return null;
    }

}
