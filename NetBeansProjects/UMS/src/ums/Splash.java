package ums;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable  {
    //constructor
    Thread t;
    Splash(){
        
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/VITfrontpage.png")); //created an image object for inserting an image
      Image i2= i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      add(image);
      
      t=new Thread(this);
      t.start();
      
      
      setVisible (true); 
      
      int x=1;
      //now we had to set the setVisible and setSize to change it dynamically 
      for (int i=2;i<=600;i+=4,x+=1){
      setSize(i+3*x,i+x/2);//size of the frame
      setLocation(600-((i+x)/2),350-(i/2));//(distance from the left, distance from the top)    
      try {
          Thread.sleep(10);
         }catch(Exception e){
             e.printStackTrace();
         }
      }
     
    }
    
    
    
    
    public void run(){
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        // We had to open the next frame
        }catch(Exception e){
            
        }
    }
   public static void main (String [] args){
       new Splash();
   } 
}
