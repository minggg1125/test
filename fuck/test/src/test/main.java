package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Member;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.AbstractButton;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.Text;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;

public class main extends JFrame{
   

   private JFrame frame;
   private JTextField txtid;
   private JPasswordField txtPass;
   private JTextField textinputid;
   private JPasswordField textinputPass2;
   private HashMap<String,String> userMap;
   private JTextField textinputphone;
   private JTextField textaddress;
   private JTable table;
   private JPasswordField textinputPass;
   private JTable table_1;
   private JTextField Searchinput;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               main window = new main();
            //
                window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public main() { 
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
   	  tabledata td = new tabledata(); // table 호출
   	  MemberTable mt = new MemberTable("member");
      frame = new JFrame();
      frame.setVisible(true);   
      frame.setSize(new Dimension(856,484));
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      mt.setVisible(false);

      imagepanel loginPanel = new imagepanel(new ImageIcon("C:\\Users\\ougi1\\eclipse-workspace\\test\\images\\trade01.jpg").getImage());
      imagepanel sidePanel = new imagepanel(new ImageIcon("C:\\Users\\ougi1\\eclipse-workspace\\test\\images\\trade02.png").getImage());
      imagepanel managerPanel = new imagepanel(new ImageIcon("C:\\Users\\ougi1\\eclipse-workspace\\test\\images\\trade03.png").getImage());
      
      frame.getContentPane().setLayout(null);
      managerPanel.setBounds(0, 0, 840, 445);
      loginPanel.setBounds(0,0,840,445);
      sidePanel.setBounds(0,0,441,445);
      managerPanel.setLayout(null);
      loginPanel.setLayout(null);      
      sidePanel.setLayout(null);
   
      JPanel JoinPanel = new JPanel();
      JoinPanel.setBounds(441, 0, 399, 445);   
      JoinPanel.setVisible(false);
      JoinPanel.setLayout(null);
      
      JPanel ProfilePanel = new JPanel();
      ProfilePanel.setBackground(new Color(248, 152, 7));
      ProfilePanel.setBounds(0, 0, 840, 445);
      ProfilePanel.setVisible(false);
      
      
      table_1 = new JTable(td);
      table_1.setBounds(10, 10, 750, 270);
      table_1.setFont(new Font("굴림", Font.PLAIN, 15));
      table_1.setRowHeight(30);
      table_1.setPreferredScrollableViewportSize(new Dimension(750, 270));
      JScrollPane scrollPane = new JScrollPane(table_1);
      scrollPane.setBounds(12, 10, 816, 315);
      ProfilePanel.setLayout(null);
      JScrollPane scrollPane_1 = new JScrollPane(table_1);
      scrollPane_1.setBounds(44, 5, 752, 298);
      ProfilePanel.add(scrollPane_1);  
      JTableHeader header = table_1.getTableHeader();

   
      frame.getContentPane().add(ProfilePanel);
      frame.getContentPane().add(loginPanel);
      frame.getContentPane().add(JoinPanel);
      frame.getContentPane().add(managerPanel);
      frame.getContentPane().add(sidePanel);
      
      JLabel lblNewLabel = new JLabel("ID");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
      lblNewLabel.setBounds(673, 228, 20, 25);
      loginPanel.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("PW");
      lblNewLabel_1.setBounds(673, 263, 20, 15);
      loginPanel.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("이름");
	  lblNewLabel_2.setBounds(72, 81, 57, 15);
	  JoinPanel.add(lblNewLabel_2);
	  
	  JLabel lblNewLabel_3 = new JLabel("비밀번호");
	  lblNewLabel_3.setBounds(72, 106, 90, 15);
	  JoinPanel.add(lblNewLabel_3);     
	  
	  JLabel lblNewLabel_4 = new JLabel("비밀번호 확인");
	  lblNewLabel_4.setBounds(72, 131, 76, 15);
	  JoinPanel.add(lblNewLabel_4);
	  
	  JLabel lblNewLabel_5 = new JLabel("전화번호");
	  lblNewLabel_5.setBounds(72, 156, 57, 15);
	  JoinPanel.add(lblNewLabel_5);
	  
	  JLabel lblNewLabel_6 = new JLabel("주소지");
	  lblNewLabel_6.setBounds(72, 181, 57, 15);
	  JoinPanel.add(lblNewLabel_6);
	  
	  JLabel lblNewLabel_7 = new JLabel("영어+숫자 8자제한");
	  lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 11));
	  lblNewLabel_7.setBounds(294, 106, 93, 16);
	  JoinPanel.add(lblNewLabel_7);
	  
      JLabel lblNewLabel_8 = new JLabel("Search");
      ProfilePanel.add(lblNewLabel_8);
      lblNewLabel_8.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
      lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_8.setBounds(12, 308, 193, 54);
     
      txtid = new JTextField();
      txtid.setBounds(700, 230, 101, 21);
      loginPanel.add(txtid);
      txtid.setColumns(10);
     
      txtPass = new JPasswordField();
      txtPass.setBounds(700, 263, 101, 21);
      loginPanel.add(txtPass);
        
	  textinputid= new texthint("ex)홍길동");	
	  textinputid.setFont(new Font("맑은 고딕", Font.ITALIC, 13));
	  textinputid.setBounds(166, 78, 116, 21);
	  JoinPanel.add(textinputid);
	  textinputid.setColumns(10);
                        
      textinputPass = new JPasswordField();
      textinputPass.setBounds(166, 103, 116, 21);
      JoinPanel.add(textinputPass);
      textinputPass.setText("");
      
      textinputPass2 = new JPasswordField();
      textinputPass2.setBounds(166, 128, 116, 21);
      JoinPanel.add(textinputPass2);
        
      textinputphone = new texthint("-포함 입력");
      textinputphone.setBounds(166, 150, 116, 21);
      textinputphone.setFont(new Font("맑은 고딕", Font.ITALIC, 13));
      JoinPanel.add(textinputphone);
      textinputphone.setColumns(10);
          
      textaddress = new texthint("도로명주소입력");
      textaddress.setBounds(166, 178, 174, 21);
      textaddress.setFont(new Font("맑은 고딕", Font.ITALIC, 13));
      JoinPanel.add(textaddress);
      textaddress.setColumns(10);
      
      Searchinput = new JTextField();
      Searchinput.setBounds(200, 309, 596, 49);
      ProfilePanel.add(Searchinput);
      Searchinput.setColumns(10);
      
      JButton btngoback = new JButton("Back");
      btngoback.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
            ProfilePanel.setVisible(false);
            table_1.setVisible(false);
            managerPanel.setVisible(true);
      		
      	}
      });
      btngoback.setFont(new Font("굴림", Font.PLAIN, 17));
      btngoback.setBounds(627, 368, 169, 54);
      ProfilePanel.add(btngoback);
      Searchinput.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent e) {
             String search = Searchinput.getText();
             TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
             table_1.setRowSorter(trs);
             trs.setRowFilter(RowFilter.regexFilter(search));
          }
      }); 
          
      JButton btnAddDel = new JButton("Add Del");
      btnAddDel.setBounds(446, 384, 185, 51);
      managerPanel.add(btnAddDel);
      
      btnAddDel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			mt.setVisible(true);
			
		}
	});
    
      
      JButton btnLogin = new JButton("Login");
      btnLogin.setBounds(652, 291, 87, 19);
      loginPanel.add(btnLogin);
      //로그인버튼 액션
      btnLogin.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String maid ="관리자";
            String pass ="1234";
            String guest = "게스트";
            String pass2 = "1234";
      

            if(maid.equals(txtid.getText())&&pass.equals(txtPass.getText())){
               JOptionPane.showMessageDialog(null, "관리자 아이디로 로그인됩니다.");
               	//	frame.setVisible(false);
               		loginPanel.setVisible(false);
              		managerPanel.setVisible(true);
              		
                    return;
                     }
            
            if(guest.equals(txtid.getText())&&pass2.equals(txtPass.getText())){
                JOptionPane.showMessageDialog(null, "게스트 아이디로 로그인됩니다.");//회원창 안만듬
                   loginPanel.setVisible(false);
                   JoinPanel.setVisible(false);
                      return;
                         }     
         
            else {
               JOptionPane.showMessageDialog(null,"아이디,비밀번호를 확인바랍니다.");
                        return;
                     }
               }    
               });
     
      
      JButton btnSignUp = new JButton("Sign Up");  
      btnSignUp.setBounds(72, 234, 130, 23);
      JoinPanel.add(btnSignUp);
      //Sing Up 버튼 눌럿을때 액션리스너들
      btnSignUp.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JoinPanel.setVisible(false);
            loginPanel.setVisible(true);
            
               String id = textinputid.getText();
               String pw = textinputPass.getText().trim();
           
               if(id.length()==0 || pw.length()==0) {
                  JOptionPane.showInternalMessageDialog(null, "아이디혹은 비밀번호를 입력하여주십시오");
                     return;          
                        }    
                     
               if(!String.valueOf(textinputPass.getPassword()).equals(String.valueOf(textinputPass2.getPassword()))) {
                  JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.", "Wraning", JOptionPane.WARNING_MESSAGE);
                     return;
                        }
               try {
               boolean fileExists = new File("C:\\Users\\ougi1\\eclipse-workspace\\0901\\database\\UserDB.csv").exists();//파일이없을경우
                  FileWriter fw = new FileWriter("C:\\Users\\ougi1\\eclipse-workspace\\0901\\database\\UserDB.csv",true);
               if(!fileExists) {
            	   fw.append("Name,Pass,Phone,Address");    
            }
               			String name = textinputid.getText();
               			String pass = textinputPass.getText();
               			String phone = textinputphone.getText();
               			String add = textaddress.getText();
               
               fw.append(name+","+pass+","+phone+","+add+"\n");
                  textinputid.setText("");
                  textinputPass.setText("");
                  textinputPass2.setText("");
                  textinputphone.setText("");
                  textaddress.setText("");
                     JOptionPane.showMessageDialog(null,"회원가입을 축하드립니다.");
                     		fw.close();
                     		td.refresh();}
         catch(Exception e1) {
         }}
         });    
      
      
      JButton btnGoBack = new JButton("Go Back");
      btnGoBack.setBounds(210, 234, 130, 23);
      JoinPanel.add(btnGoBack);
      
      btnGoBack.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JoinPanel.setVisible(false);
            loginPanel.setVisible(true);
              textinputid.setText("");
              textinputPass.setText("");
              textinputPass2.setText("");
              textinputphone.setText("");
              textaddress.setText("");
                     }
         
                   });
      
      JButton btn_Profile = new JButton("Profile");
      btn_Profile.setBounds(643, 384, 185, 51);
      managerPanel.add(btn_Profile);
      
      btn_Profile.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ProfilePanel.setVisible(true);
            table_1.setVisible(true);
            managerPanel.setVisible(false);
         } 
      });
     
      JButton btnJoin = new JButton("Join");
      btnJoin.setBounds(741, 291, 87, 19);
      loginPanel.add(btnJoin);
  
      btnJoin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            loginPanel.setVisible(false);
            JoinPanel.setVisible(true);
            managerPanel.setVisible(false);
            sidePanel.setVisible(true);
                  }
                     });

      }
      }
   


 