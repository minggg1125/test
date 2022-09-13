package test;

import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class tabledata extends AbstractTableModel{
   private List<profile> list;
   private JTable table;
  // MemberTable table= new MemberTable("");
   private String[] headers = {"ID","PASS","NUMBER","ADDRESS"};
   
   public tabledata() {
      updateList();
   }
   
//   public String getColumnName(int cell) {
//      return headers[cell];
//   }
   
   private void updateList() {
      list = new ArrayList<>();
      try {
         Scanner s = new Scanner(new File("C:\\Users\\ougi1\\eclipse-workspace\\test\\database\\UserDB.csv"));
         for(int i=0; s.hasNext(); i++) {
            String[]data= s.nextLine().split(",");
             if(i !=0) {
              profile t1 = new profile();
              profilebuilder t2 = new profilebuilder(t1);
               t1 = t2
                     .id(data[0])
                     .pass(data[1])
                     .phone(data[2])
                     .address(data[3])
                     .Test02();
                      list.add(t1);
              }
         }
         s.close();
      }
      catch (Exception e) {
         e.printStackTrace();
        }
      }

   @Override
   public int getRowCount() {
      return list.size();
   }

   @Override
   public int getColumnCount() {
      return 4;
   }

   @Override
   public Object getValueAt(int row, int cell) {
      switch(cell) {
      case 0:
         return list.get(row).getID();
      case 1:
         return list.get(row).getPASS();
      case 2:
         return list.get(row).getPHONE();
      case 3:
         return list.get(row).getADDRESS();
      }
      return null;
   }
  
   
   public void refresh(){
      updateList();
      super.fireTableDataChanged();
   }
 
   public void removeRecord(int index) {
	   if(index<0) {
			if(table.getRowCount()==0)//비어있는 테이블이면
				return;
			index=0;
		}
   }
   public void printCell(int row,int col) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		System.out.println(model.getValueAt(row, col));
	}



   public String getColumnName(int cell) {
      return headers[cell];
   }
//   
//   public String[][] getProFile(){
//      int cnt = 0;
//      String[][] info = new String[list.size()][headers.length];
//      for(test02 Profile : list) {
//         info[cnt][0] = Profile.getID();
//         info[cnt][1] = Profile.getPASS();
//         info[cnt][2] = Profile.getPHONE();
//         info[cnt][3] = Profile.getADDRESS();
//         cnt++;
//      } return info;
//   }
   
}