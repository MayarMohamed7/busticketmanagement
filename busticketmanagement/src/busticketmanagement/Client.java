/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticketmanagement;

/**
 *
 * @author Mayar
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
 
public class Client {

JTextArea incoming;
JTextField outgoing;
JButton sendbutton;
BufferedReader reader;
PrintWriter writer;
Socket sock;
public void go(){
JFrame frame = new JFrame("Client");
JPanel mainpanel = new JPanel();
 
incoming = new JTextArea(15,50);
incoming.setLineWrap(true);
incoming.setWrapStyleWord(true);
incoming.setEditable(false);
 
JScrollPane qScroller = new JScrollPane(incoming);
qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
 
outgoing = new JTextField(20);
sendbutton = new JButton("Send");
 
sendbutton.addActionListener(new SendButtonListener());
 
mainpanel.add(qScroller);
mainpanel.add(outgoing);
mainpanel.add(sendbutton);
 
setUpNetworking();
Thread readerThread = new Thread(new IncomingReader());
readerThread.start();
frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
frame.setSize(400, 400);
frame.setVisible(true);
}private void setUpNetworking(){
 
try{
 
sock = new Socket("127.0.0.1", 5000);
InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
reader = new BufferedReader(streamReader);
writer = new PrintWriter(sock.getOutputStream());
System.out.println("Networking established!!");
 
}catch(IOException e){
e.printStackTrace();
}
}
public class SendButtonListener implements ActionListener{
 
public void actionPerformed(ActionEvent e){
try{
writer.println(outgoing.getText());
writer.flush();
}catch(Exception ex){
ex.printStackTrace();
}
 
outgoing.setText("");
outgoing.requestFocus();
}
}
public class IncomingReader implements Runnable{
 
public void run(){
String message;
try{
while((message = reader.readLine()) != null){
System.out.println("read" + message);
incoming.append(message + "\n");
 
}
}catch(Exception e){
  e.printStackTrace();
  }
 }
 }
}
        


