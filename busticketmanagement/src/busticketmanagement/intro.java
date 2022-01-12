/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;

import busticketmanagement.Customer.Register;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mayar
 */
public class intro extends JFrame implements ActionListener {

    JButton signin = new JButton("Sign in");
    JButton signup = new JButton("Sign up");
    ImageIcon icon = new ImageIcon("then_bus_1154158_50.png");
    JLabel label = new JLabel(icon);

    public intro() {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints g = new GridBagConstraints();
        GridBagConstraints g1 = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g1.insets = new Insets(10, 10, 10, 10);
        g.gridx = 1;
        g.gridy = 5;
        add(signin, g);
        g.gridx = 5;
        g.gridy = 5;
        add(signup, g);
        signin.addActionListener(this);
        signup.addActionListener(this);
        g1.gridx = 3;
        g1.gridy = 50;
        add(label, g1);
        //label.setSize(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);

    }

    /**
     *
     * @param action
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource().equals(signup)) {
            setVisible(false);
            Customer c = new Customer();
        }
        if (action.getSource().equals(signin)) {
            setVisible(false);
            signIn s = new signIn();
            s.setVisible(true);
        }
    }

}
 class Homepage extends JFrame implements ActionListener{

            JButton bookticket = new JButton("Book your ticket");
            JButton Cancelticket = new JButton("Cancel your ticket");
            JButton chat = new JButton("Chat with us");

            Homepage() {
                setSize(800, 400);
                GridBagLayout grid = new GridBagLayout();
                setLayout(grid);
                GridBagConstraints g = new GridBagConstraints();
                g.insets = new Insets(10, 10, 10, 10);
                g.gridx = 1;
                g.gridy = 0;
                add(bookticket,g);
                g.gridx = 5;
                g.gridy = 0;
                add(Cancelticket,g);
                g.gridx = 10;
                g.gridy = 0;
                add(chat,g);
                bookticket.addActionListener(this);
                Cancelticket.addActionListener(this);
                chat.addActionListener(this);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bookticket)){
                    setVisible(false);
                    Routes r = new Routes();
                    r.setVisible(true);
        }
          if(e.getSource().equals(Cancelticket)){
              
          }
          if(e.getSource().equals(chat)){
              Client client1 = new Client();
              //client1.run();
          }
          
    }
        }
    

class signIn extends JFrame implements ActionListener {

   static JFrame w2;

   /* public static void open() {
        w2 = new signIn();
    }*/
    JLabel phoneno = new JLabel("Phone number");
    JTextField pn = new JTextField(11);
    JLabel pass = new JLabel("Password");
    JPasswordField p = new JPasswordField(20);
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton signin = new JButton("Sign in");

    public signIn() {
        setSize(800, 400);
        GridLayout grid = new GridLayout(7, 2, 5, 5);
        setLayout(grid);
        add(phoneno);
        add(pn);
        add(pass);
        add(p);
        add(showPassword);
        add(signin);
        signin.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showPassword.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signin)) {
            if (pn.getText().equalsIgnoreCase("123456789") && p.getText().equalsIgnoreCase("1234")) {

                int input = JOptionPane.showOptionDialog(null, "Hi Admin", "Welcome", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if (input == JOptionPane.OK_OPTION) {
                    setVisible(false);
                    Admin a = new Admin();
                    a.setVisible(true);
                    return;
                }

                // frame el admin hena, JFrame window =new 
            }

            if (Customer.Login(pn.getText(), p.getText()) == null) {
                JOptionPane.showMessageDialog(this, "Invalid Login");
                return;
            } else {
                Homepage h = new Homepage();
                setVisible(false);
            }

            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) {

                    p.setEchoChar((char) 0);

                } else {
                    p.setEchoChar('•');
                }
            }

        }
       
}}
