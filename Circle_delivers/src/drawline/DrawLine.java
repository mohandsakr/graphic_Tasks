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
    int quarter=0;
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
       //
     g.drawLine(x1, y1, x2, y2);
     if(angle==360){
                g.clearRect(0, 0, 500, 500);
                angle=0;
     }
 
  }
 public static  int xValue(int radius,int CenterX, int angle){
     double radianangle=(angle*Math.PI)/180;
     double leftHs=radius*Math.cos((radianangle));
        return (int)( CenterX+leftHs);
 
 
 }
 public static  int yValue(int radius,int CenterY, int angle){
     double radianangle=(angle*Math.PI)/180;
     double leftHs=radius*Math.sin((radianangle));
return (int)(CenterY+leftHs);
 }
 static int angle;
 static int radius;
 static int center_X_point;
 static  int center_Y_point;
 static  int start_X;
 static int start_Y;
 
  public static void main(String[] args) {
       angle=0;
       radius=200;
       center_X_point=250;
       center_Y_point=250;
       start_X=xValue(radius,center_X_point,angle);
       start_Y=yValue(radius, center_Y_point, angle);
    //int start_Y=center_Y_point+radius*(int)Math.sin((double)angle);
    JFrame frame = new JFrame("Draw Line");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);
    frame.setSize(500, 500);
  Timer timer=new Timer();
   TimerTask task = new TimerTask() {
         
         @Override
         public void run() {
             ++angle;
           int x1,y1,x2,y2;
             x1=start_X;
             y1=start_Y;
             x2=xValue(radius,center_X_point, angle);
             y2=yValue(radius, center_Y_point, angle);
            DrawLine panel = new DrawLine(x1,y1,x2,y2);
                 System.out.println(x1+" "+y1);
                 System.out.println(x2+" "+y2);
                 System.out.println("angle is "+angle);
                 start_X=x2;
                 start_Y=y2;
            frame.add(panel);
            frame.setVisible(true);
             
           
             
         }
     };
     
    timer.scheduleAtFixedRate(task, 20, 20); 
    /* System.out.println(yValue(radius, center_X_point, 50));
            System.out.println(yValue(radius, center_X_point, 120));*/

    
  }
  }
