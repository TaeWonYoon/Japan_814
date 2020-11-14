package service;

import dao.BookDAO_Mariadb;
import dao.UserDAO_Mariadb;
import vo.UserVO;

public class UserServiceImpl implements UserService {

	private UserDAO_Mariadb dao = null;
	
	public UserServiceImpl() { }
	public UserServiceImpl(UserDAO_Mariadb dao) {
		this.dao = dao;
	}
	public UserDAO_Mariadb getDao() {
		return dao;
	}
	public void setDao(UserDAO_Mariadb dao) {
		this.dao = dao;
	}
	
	

	@Override
	public UserVO login(String id, String password) {
		// TODO Auto-generated method stub
		return dao.login(id, password);
	}

	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

}
