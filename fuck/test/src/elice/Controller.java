package elice;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    public Controller() {
        try {
            conn = DriverManager.getConnection("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 회원 추가
    public void insertMember(Model model) {
        try {
            st = conn.createStatement();
            int stmt = st.executeUpdate(
                    "insert into member values ('" + model.name + "', '" + model.birth + "', '" + model.tel + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 목록 출력
    public ArrayList<Model> readMember() {
        ArrayList<Model> arr = new ArrayList<Model>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from member;");
            while (rs.next()) {
                arr.add(new Model(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    // 회원수정
    public void updateMember(String name, String tel) {
        try {
            st = conn.createStatement();
            int stmt = st
                    .executeUpdate("update member set tel = '" + tel + "' where name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 회원삭제
    public void deleteMember(String name) {
        try {
            st = conn.createStatement();
            int stmt = st.executeUpdate("delete from member where name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 검색
    public ArrayList<Model> searchMember(String content) {
        ArrayList<Model> arr = new ArrayList<Model>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from member where name like '%" + content + "%';");
            while (rs.next()) {
                arr.add(new Model(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
}