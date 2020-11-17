package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_Mariadb {
   
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs =null;
    
   public List<BookVO> bookList() {
      List<BookVO> list = new ArrayList<BookVO>();
      String sql = "select * from Book order by bookno desc";
      
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
            vo.setDay(rs.getNString("day"));
            list.add(vo);
         }
         
      } catch (Exception e) {
         System.out.println("error"+e);
      }finally {
         JDBCUtil.close(con, ps, rs);
      }
      return list;
   }
   
   public void bookAdd(BookVO vo) {
      
      String sql = 
         "insert into Book (title,publisher,price) values ( ?, ?, ?);";
      
      int row = 0;
      
      try {
    	  
    	  con = JDBCUtil.getConnection();
    	  ps = con.prepareStatement(sql);
    	  ps.setString(1, vo.getTitle());
          ps.setString(2, vo.getPublisher());
          ps.setInt(3,  vo.getPrice());
          
          row = ps.executeUpdate();
          
          if(row == 0) {
        	  throw new Exception("등록실패");
          }
    	  //실행
//    	  ps.executeQuery();
      } catch (Exception e) {
    	  e.printStackTrace();
	} finally {
		JDBCUtil.close(con, ps, null);
	}
      
      
   }
   public int bookDelete(int bookno) {
	      int row = 0;
	      
	      String sql = "Delete from Book where bookno = ?";
	      
	      try {
	    	  con = JDBCUtil.getConnection();
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, bookno);
	    	 
	    	  row = ps.executeUpdate();
	    	  
	    	  if(row == 0) {
	        	  throw new Exception("등록실패");
	          }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(con, ps, null);
	      }
	      
	      return row;      
	   }
   
   public int bookUpdate(BookVO vo) {
	      int row = 0;
	      
	      String sql = "update Book set price = ? where bookno = ?";
	      try {
		      con = JDBCUtil.getConnection();
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, vo.getPrice());
	    	  ps.setInt(2, vo.getBookno());
	    	  
	    	  row = ps.executeUpdate();
	    	  
	    	  if(row == 0) {
	        	  throw new Exception("등록실패");
	          }
	    	  
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(con, ps, null);
	      }
	      return row;      
	      
	   }
   
   public List<BookVO> bookSearch(String condition, String keyword) {
	      
	      
	      List<BookVO> list = new ArrayList<BookVO>();
	      
	      String sql = "select * from Book where " + condition + " like ? order by bookno desc ";

	      try {
		      con = JDBCUtil.getConnection();
	    	  ps = con.prepareStatement(sql);
	    	  ps.setString(1, "%" + keyword + "%");
	    	  
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
	    	  e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(con, ps, rs);
	      }
	      return list;      
	      
	   }
   
   public BookVO getBook(int bookno) {
	      
	      String sql = "select * from Book where bookno = ? "; 
	      BookVO vo = null;
	      try {
		      con = JDBCUtil.getConnection();
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, bookno);
	    	  
	    	  rs = ps.executeQuery();
	    	  
	    	  while(rs.next()) {
	    		  vo = new BookVO();
	    		  vo.setBookno(rs.getInt("bookno"));
	    		  vo.setPrice(rs.getInt("price"));
	    		  vo.setPublisher(rs.getString("publisher"));
	    		  vo.setTitle(rs.getNString("title"));
	    	  }
	    	  
//	    	  if(rs == null) {
//	        	  throw new Exception("등록실패");
//	          }
	    	  
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(con, ps, rs);
	      }
		return vo;
	      
	   }
}