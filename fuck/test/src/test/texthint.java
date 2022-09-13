package test;

import java.awt.Color;  

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusAdapter;  

import java.awt.event.FocusEvent;

import javax.swing.JTable;
import javax.swing.JTextField;  



public class texthint extends JTextField {  
     
     Font gainFont = new Font("맑은 고딕", Font.PLAIN, 13);  
     Font lostFont = new Font("맑은 고딕", Font.ITALIC, 13);  
 
     public texthint(final String hint) {  

       setText(hint);  
       setFont(lostFont);  
       setForeground(Color.GRAY);  

       this.addFocusListener(new FocusAdapter() {  

   
         public void focusGained(FocusEvent e) {  

           if (getText().equals(hint)) {  

             setText("");  

             setFont(gainFont);  

           } else {  

             setText(getText());  

             setFont(gainFont);  

           }  

         }  

     

         @Override  

         public void focusLost(FocusEvent e) {  

           if (getText().equals(hint)|| getText().length()==0) {  

             setText(hint);  

             setFont(lostFont);  

             setForeground(Color.GRAY);  

           } else {  

             setText(getText());  

             setFont(gainFont);  

             setForeground(Color.BLACK);  

           }  

         }  



       });  

     

     }



   }  