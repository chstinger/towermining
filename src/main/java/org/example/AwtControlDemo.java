package org.example;

import java.awt.*;
import java.awt.event.*;

public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private TextArea commentTextArea;
   private boolean stop=false;

   public AwtControlDemo(){
      prepareGUI();
   }

   public boolean isStop() {
      return stop;
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showTextAreaDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(800,800);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
   }

   public void showTextAreaDemo(){
      headerLabel.setText("Control in action: TextArea"); 

      Label  commentlabel= new Label("Comments: ", Label.RIGHT);

      commentTextArea = new TextArea("This is a AWT tutorial "
      +"to make GUI application in Java.",20,30);

      Button showButton = new Button("Stop");

      showButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
            stop=true;
         }
      }); 

      controlPanel.add(commentlabel);
      controlPanel.add(commentTextArea);
      controlPanel.add(showButton);
      mainFrame.setVisible(true);  
   }

   public void setText(String s) {
      commentTextArea.setText(s);
   }
}