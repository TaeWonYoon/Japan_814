package service;

import java.util.List;

import vo.BookVO;

public interface BookService {

	
	List<BookVO> bookList();
	
	public void bookAdd(BookVO vo);
	
	void bookDelete(int bookno);
	
	void bookUpdate(BookVO vo);
	
	BookVO getBook(int bookno);
	
	List<BookVO> searchBook(String condition, String keyword);

}
