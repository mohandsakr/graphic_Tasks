/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawline;

/**
 *
 * @author sakr
 */
import java.awt.*;
import java.util.*;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.*;
 import java.util.Timer;
public class DrawLine extends JPanel {
 int x1,y1,x2,y2;
 DrawLine(int a,int b,int c ,int d){
x1=a;
y1=b;
x2=c;
y2=d; 
 }
 @Override
   public void paintComponent(Graphics g) {
       
     g.setColor(Color.blue);
       g.clearRect(0, 0, 500, 500);
     g.drawLine(x1, y1, x2, y2);
   
 
  }
 
  
 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Draw Line");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);
    frame.setSize(500, 500);
 
  Random random=new Random();
 
 
 Timer timer=new Timer();
     TimerTask task = new TimerTask() {
         
         @Override
         public void run() {
           int x1,y1,x2,y2;
            x1=random.nextInt(500)+1;
            x2=random.nextInt(500)+1;
            y1=random.nextInt(500)+1;
            y2=random.nextInt(500)+1;
            DrawLine panel = new DrawLine(x1,y1,x2,y2);
            frame.add(panel);
            frame.setVisible(true);
           
             
         }
     };
    timer.scheduleAtFixedRate(task, 1000, 1000); 
    
  DrawLine panel = new DrawLine(10,10,5,5);
            frame.add(panel);
            frame.setVisible(true);
  }
}