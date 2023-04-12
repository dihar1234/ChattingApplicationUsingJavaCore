package chatting.application.using.socket.programming;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.net.*;
import java.io.*;

//java swing and awt
public class Server  implements ActionListener {//after running the class we will see the frame. Hence we will do the coding of constructor in the frame only.
    
    JTextField text;
    JPanel a1;
    static Box vertical=Box.createVerticalBox();
    static JFrame f= new JFrame();
    static DataOutputStream dout;
    
    Server (){
        f.setLayout(null);
        JPanel p1=new JPanel();//to do something on the frame
        p1.setBackground(new Color(0,0,70));
        p1.setLayout(null);
        p1.setBounds(0,0,450,70);
        f.add(p1);//because we want to add the image on the panel
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel back= new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter(){//this will close the frame on clicking the arrow image
            public void mouseClicked (MouseEvent ae){
                System.exit(0);
            }
        });
        
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/Profile.PNG"));
        Image i5=i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel profile= new JLabel(i6);
        profile.setBounds(40,10,50,50);
        p1.add(profile);
        
        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8=i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel video= new JLabel(i9);
        video.setBounds(300,20,30,30);
        p1.add(video);
        
        ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11=i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12= new ImageIcon(i11);
        JLabel phone= new JLabel(i12);
        phone.setBounds(360,20,30,30);
        p1.add(phone);
        
        ImageIcon i13= new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14=i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15= new ImageIcon(i14);
        JLabel morevert= new JLabel(i15);
        morevert.setBounds(400,20,30,30);
        p1.add(morevert);
        
        //using Jlabel we can write anything 
        JLabel name = new JLabel ("Harsh Modi");
        //now we need to change the foreground color of the text 
        name.setBounds(110,20,100,18);
        name.setForeground(Color.WHITE);
        name.setFont (new Font("GILL SANS", Font.BOLD,17));
         p1.add(name);
         
         
        //Again we will use JLabel to write active now  
        JLabel status = new JLabel ("Active now");
        p1.add(status);
        //now we need to change the foreground color of the text 
        status.setBounds(110,40,100,18);
        status.setForeground(Color.WHITE);
        status.setFont (new Font("SANS_SERIF", Font.BOLD,12));
        p1.add(status);
        
        
        //Now we had to create one more panel 
        a1= new JPanel ();
        a1.setBounds(5,75,440,570);
        f.add(a1);
        
        //JTextField is a class where the user can write the message to anyone
        text= new JTextField ();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("DIALOG", Font.PLAIN,14));
        f.add (text);
        
        //JButton class is used to create buttons
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(0,0,70));
        send.addActionListener(this);
        send.setFont (new Font("MONOSPACED", Font.BOLD,15));
        send.setForeground(Color.WHITE);
        f.add(send);
                
                
                
        f.setUndecorated(true);
        
        f.setSize(450,700);
        f.setVisible(true);
        f.setLocation(200,50);
        f.getContentPane().setBackground(Color.WHITE);//change the color of the background which comes under the awt package 
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
       String out=text.getText();
       JPanel p2= formatLabel(out);
       a1.setLayout(new BorderLayout());
       JPanel right= new JPanel (new BorderLayout());
       right.add(p2,BorderLayout.LINE_END);
       vertical.add(right);
       vertical.add(Box.createVerticalStrut(15));
       
       a1.add(vertical, BorderLayout.PAGE_START);
       
       
       dout.writeUTF(out);
       //to repaint the text on clicking the send button
       text.setText("");
       
       f.repaint();
       f.invalidate();
       f.validate();
       
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
    public static JPanel formatLabel(String out){
       JPanel panel= new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       JLabel output= new JLabel("<html><p style=\"width: 150px\">"+out+"</p></html>");
       output.setFont(new Font("Tahoma", Font.PLAIN,16));
       output.setBackground(new Color(205,240,255));
       output.setOpaque(true);
       output.setBorder(new EmptyBorder(15,15,15,50));
       
       panel.add(output);
       
       
       //using calender class for getting time
       Calendar cal=Calendar.getInstance();
       SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
       JLabel time=new JLabel();
       time.setText(sdf.format(cal.getTime()));
       panel.add(time);
       return panel;
    }
    public static void main(String [] args){
        new Server ();
        try {
            ServerSocket skt= new ServerSocket(6001);
            while(true){
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                 dout= new DataOutputStream(s.getOutputStream());
                
                while (true){
                    String msg= din.readUTF();
                    JPanel panel= formatLabel(msg);
                    JPanel left= new JPanel (new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }   
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
