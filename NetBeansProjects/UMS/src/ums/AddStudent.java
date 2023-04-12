
package ums;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class AddStudent extends JFrame {
    
    JTextField tfname, tffname;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L));
    
    
    AddStudent(){
      setSize(900,700);  
      setLocation(350,50);
      
      setLayout(null);
      JLabel heading=new JLabel("New Student Details");
      heading.setBounds(310,30,500,50);
      heading.setFont(new Font("serif", Font.BOLD,30));
      add(heading);
      
      
      
      JLabel lblname=new JLabel("Name");
      lblname.setBounds(50,150,100,30);
      lblname.setFont(new Font("serif", Font.BOLD,20));
      add(lblname);
      
      tfname=new JTextField();
      tfname.setBounds(200,150,150,30);
      add(tfname);
      
      
      JLabel lblfname=new JLabel("Father's name");
      lblfname.setBounds(500,150,200,30);
      lblfname.setFont(new Font("serif", Font.BOLD,20));
      add(lblfname);
      
      tffname=new JTextField();
      tffname.setBounds(650,150,150,30);
      add(tffname);
      
      JLabel lblrollno=new JLabel("Roll number");
      lblrollno.setBounds(50,200,200,30);
      lblrollno.setFont(new Font("serif", Font.BOLD,20));
      add(lblrollno);
      
      setVisible(true);
    }
    
    public static void main (String [] args){
        new AddStudent();
    }
}
