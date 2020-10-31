package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_Mariadb {
   
   public List<BookVO> bookList() {
      List<BookVO> list = new ArrayList<BookVO>();
      String sql = "select * from Book";
      
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      try {
         con = JDBCUtil.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()) {
            BookVO vo = new BookVO();
            vo.setBookno(rs.getInt("bookno"));
            vo.setPrice(rs.getInt("price"));
            vo.setPublisher(rs.getString("publisher"));
            vo.setTitle(rs.getString("title"));
            list.add(vo);
         }
         
      } catch (Exception e) {
         System.out.println("error"+e);
      }finally {
         JDBCUtil.close(con, ps, rs);
      }
      return list;
   }
   
   public int insertList() {
      int row = 0;
      
      String sql = 
         "insert into book (title,publisher,price)" +
               "values ('자바', '한빛', 900);";
      
      return row;      
      
      
   }

}