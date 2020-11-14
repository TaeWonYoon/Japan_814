package dao;

import java.sql.*;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO_Mariadb {

	public UserVO login(UserVO vo) {
		return login(vo.getId(),vo.getPassword());
	}
	
	public UserVO login(String id, String password) {
		UserVO vo = null;
		String sql = "select * from user where id=? and password=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setNString(1, id);
			ps.setNString(2, password);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getNString("id"));
				vo.setName(rs.getNString("name"));
				vo.setPassword(rs.getNString("password"));
				vo.setRole(rs.getNString("role"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return vo;
	}
}
