package ums;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1920,1080);
        
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/VITproject.jpeg")); //created an image object for inserting an image
      Image i2= i1.getImage().getScaledInstance(1920, 960, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      add(image);
      //here we does not need setbounds because we need it only when we are making the layout as null
      JMenuBar mb=new JMenuBar();
      //For adding any new item into the menu bar like new Information
      JMenu newInformation=new JMenu("New information");
      mb.add(newInformation);
      newInformation.setForeground(Color.BLUE);
      setJMenuBar(mb);
      //Adding drop down lists
      JMenuItem facultyInfo= new JMenuItem("New Faculty Information");
      facultyInfo.setBackground(Color.YELLOW);
      newInformation.add(facultyInfo);
      
      
      JMenuItem studentInfo= new JMenuItem("New Student Information");
      studentInfo.setBackground(Color.YELLOW);
      newInformation.add(studentInfo);
      
      //Creating a details tab 
      JMenu details=new JMenu("View Details");
      details.setForeground(Color.BLUE);
      mb.add(details);
      setJMenuBar(mb);
      //Adding drop down lists
      JMenuItem facultydetails= new JMenuItem("View Faculty Details");
      facultydetails.setBackground(Color.WHITE);
      details.add(facultydetails);
      
      
      JMenuItem studentdetails= new JMenuItem("View Student Details");
      studentdetails.setBackground(Color.WHITE);
      details.add(studentdetails);
      
      
      //Creating a leave tab 
      JMenu leave =new JMenu("Apply Leave ");
      leave.setForeground(Color.BLUE);
      mb.add(leave);
      //Adding drop down lists
      JMenuItem facultyleave= new JMenuItem("Faculty Leave");
      facultyleave.setBackground(Color.WHITE);
      leave.add(facultyleave);
      
      
      JMenuItem studentleave= new JMenuItem("Student Leave");
      studentleave.setBackground(Color.WHITE);
      leave.add(studentleave);
      
      
      
      //Creating a leave details tab 
      JMenu leavedetails =new JMenu("Leave Details ");
      leavedetails.setForeground(Color.BLUE);
      mb.add(leavedetails);
      //Adding drop down lists
      JMenuItem facultyleavedetails= new JMenuItem("Faculty Leave Details");
      facultyleavedetails.setBackground(Color.WHITE);
      leavedetails.add(facultyleavedetails);
      
      
      JMenuItem studentleavedetails= new JMenuItem("Student Leave Details");
      studentleavedetails.setBackground(Color.WHITE);
      leavedetails.add(studentleavedetails);
      
      
      
      //Creating an examination details tab 
      JMenu exam=new JMenu("Examination");
      exam.setForeground(Color.BLUE);
      mb.add(exam);
      //Adding drop down lists
      JMenuItem examinationdetails= new JMenuItem("Examination results");
      facultyleavedetails.setBackground(Color.WHITE);
      exam.add(examinationdetails);
      
      
      JMenuItem entermarks= new JMenuItem("Enter Marks");
      studentleavedetails.setBackground(Color.WHITE);
      exam.add(entermarks);
      
      
      
      JMenu updateinfo=new JMenu("Update Details");
      updateinfo.setForeground(Color.BLUE);
      mb.add(updateinfo);
      //Adding drop down lists
      JMenuItem updatefacultyinfo= new JMenuItem("Update Faculty Details");
      updatefacultyinfo.setBackground(Color.WHITE);
      updateinfo.add(updatefacultyinfo);
      
      
      JMenuItem updatestudentinfo= new JMenuItem("Update Student Details");
      updatestudentinfo.setBackground(Color.WHITE);
      updateinfo.add(updatestudentinfo);
      
      
      
      //fee details section
      JMenu fee=new JMenu("Fee Details");
      fee.setForeground(Color.BLUE);
      mb.add(fee);
      //Adding drop down lists
      JMenuItem structure= new JMenuItem("Fee Structure");
      structure.setBackground(Color.WHITE);
      fee.add(structure);
      
      
      JMenuItem feeform= new JMenuItem("Student Fee Form");
      feeform.setBackground(Color.WHITE);
      fee.add(feeform);
      
      
      
      //Basic utilities 
      JMenu utility=new JMenu("Utility");
      utility.setForeground(Color.BLUE);
      mb.add(utility);
      //Adding drop down lists
      JMenuItem notepad= new JMenuItem("Notepad");
      notepad.setBackground(Color.WHITE);
      notepad.addActionListener(this);
      utility.add(notepad);
      
      
      JMenuItem calc= new JMenuItem("Calculator");
      calc.setBackground(Color.WHITE);
      calc.addActionListener(this);
      utility.add(calc);
      
      
      //Creating the VTOP section
      JMenu vtop=new JMenu("VTOP Portal");
      vtop.setForeground(Color.BLUE);
      mb.add(vtop);
      //Adding drop down lists
      JMenuItem vtopfaculty= new JMenuItem("VTOP for Faculty");
      vtopfaculty.setBackground(Color.WHITE);
      vtop.add(vtopfaculty);
      
      
      JMenuItem vtopstudent= new JMenuItem("VTOP for Students");
      vtopstudent.setBackground(Color.WHITE);
      vtop.add(vtopstudent);
      
      JMenuItem vtopalumni= new JMenuItem("VTOP for Alumni");
      vtopalumni.setBackground(Color.WHITE);
      vtop.add(vtopalumni);
      
      
       //Exit
      JMenu exit=new JMenu("Exit");
      exit.setForeground(Color.BLUE);
      mb.add(exit);
      //Adding drop down lists
      JMenuItem ex= new JMenuItem("Exit");
      ex.setBackground(Color.WHITE);
      ex.addActionListener(this);
      exit.add(ex);
      
      
      //it should be your last statement 
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            String msg=ae.getActionCommand();
            if (msg.equals("Exit")){
                setVisible(false);
            }else  if (msg.equals("Calculator")){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){
                    
                }
            }else  if (msg.equals("Notepad")){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){
                    
                }
            }
    }
    public static void main (String[] args){
        new Project();
    }
}
