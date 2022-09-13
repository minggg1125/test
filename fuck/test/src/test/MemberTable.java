package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class MemberTable extends JFrame implements MouseListener,KeyListener {
	//CSVReader reader = new CSVReader(new FileReader("C:\\Users\\ougi1\\eclipse-workspace\\0901\\database\\UserDB.csv"));
	private final String[] labels= {"아이디","비밀번호","전화번호","주소"};
	private JTextField []fields=new JTextField[4];
	
	private JScrollPane scrolledTable;
	private JTable table;
	private JTable table_1;
	private JButton addBtn;
	private JButton delBtn;
	private JButton ProBtn;
	
	public MemberTable(String title) {
		this.setLayout(new BorderLayout(10,10));
		
		JPanel topPanel=new JPanel(new GridLayout(6,4,10,5));
		
		for(int i=0;i<4;i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i]=new JTextField(30);
			topPanel.add(fields[i]);
		}
		tabledata td = new tabledata();
		topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.add("North",topPanel);				//가장 위쪽 Panel 설정
		
		String header[]= {"아이디","비밀번호","전화번호","주소"};
		DefaultTableModel model=new DefaultTableModel(header,0);	//header추가, 행은 0개 지정
		
		table=new JTable(model);
		scrolledTable=new JScrollPane(table);	//스크롤 될 수 있도록 JScrollPane 적용
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));	//너무 붙어있어서 가장자리 띄움(padding)
		this.add("Center",scrolledTable);	//가운데에 JTable 추가
		
	      JPanel ManagerPanel = new JPanel();
	      ManagerPanel.setBounds(0,0,840,445);
	      ManagerPanel.setVisible(true);
	      ManagerPanel.setLayout(null);
		
	      JPanel tp = new JPanel();
	      tp.setBounds(30, 50, 770, 310);
	      ManagerPanel.add(tp);
		
	      table_1 = new JTable(td);
	      table_1.setBounds(10, 10, 750, 270);
	      table_1.setFont(new Font("굴림", Font.PLAIN, 15));
	      table_1.setRowHeight(30);
	      table_1.setPreferredScrollableViewportSize(new Dimension(750, 270));
	      tp.add(new JScrollPane(table_1)); 
	      JTableHeader headers = table_1.getTableHeader();
	      table_1.setVisible(true);
		 
		
		JPanel rightPanel=new JPanel(new GridLayout(5,1,10,10));
		
		addBtn=new JButton("회원 추가");
		delBtn=new JButton("회원 삭제");

	         
		
		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.add("East",rightPanel);		//오른쪽에 버튼들 추가
		
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(620,400);
		this.setLocationRelativeTo(null);	//창 가운데 위치
		this.setVisible(true);
		
		
		//이벤트 추가
		addBtn.addMouseListener(this);	//추가 처리
		delBtn.addMouseListener(this);	//삭제 처리
		for(int i=0;i<4;i++)	//엔터 처리
			fields[i].addKeyListener(this);
		table.addMouseListener(this);	//셀 읽기 처리
		
	}



	private boolean isInvalidInput(String input) {
		return input==null||input.length()==0;
	}

	public void removeRecord(int index) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		if(index<0) {
			if(table.getRowCount()==0)//비어있는 테이블이면
				return;
			index=0;
		}
		model.removeRow(index);
	}
	public void addRecord() {
//		try {
//		TableModel model4 = table.getModel();
//		FileWriter csv = new FileWriter(new File("C:\\Users\\ougi1\\eclipse-workspace\\0901\\database\\UserDB.csv"));
//		for (int i = 0; i < model.getColumnCount(); i++) {
//			csv.write(model.getColumnName(i) + ",");
//			}
//			csv.write("\n");
//
//			for (int i = 0; i < model.getRowCount(); i++) {
//			for (int j = 0; j < model.getColumnCount(); j++) {
//			csv.write(model.getValueAt(i, j).toString() + ",");
//			}
//			csv.write("\n");
//			}
//			csv.close();
//			return;
//			} catch (IOException e) {
//			e.printStackTrace();
//			}
//			return;
//			}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String []record=new String[4];
		for(int i=0;i<4;i++) {
			if(isInvalidInput(fields[i].getText())) {
				System.out.println("Invalid Input");
				return;
			}
			record[i]=fields[i].getText();
		}
		model.addRow(record);
		
		//모든 TextField 비우기
		for(int i=0;i<4;i++)
			fields[i].setText("");
		
		fields[0].requestFocus();
	}
	
	public void printCell(int row,int col) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		System.out.println(model.getValueAt(row, col));
	}

	//MouseListener Overrides
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src=e.getSource();
		if(src==addBtn) 
			addRecord();
		
		if(src==delBtn) {
			int selected=table.getSelectedRow();
			removeRecord(selected);
		}
		
		if(src==table) {
			int row=table.getSelectedRow();	
			int col=table.getSelectedColumn();
			printCell(row,col);
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	//KeyListener Overrides
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_ENTER) {
			addRecord();
		}
	}
}


