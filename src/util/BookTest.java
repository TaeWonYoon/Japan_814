package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

class BookTest {

BookService service = null;
	
	@BeforeEach
	void setUp() throws Exception {
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		service = new BookServiceImpl(dao);
	}

	@Test
	void list() {
		//service.bookList().forEach(i -> {System.out.println(i);});
		List<BookVO> list = service.bookList();
		for(BookVO data : list) {
			System.out.println("-------");
			System.out.printf("%d %d %s %s %n", data.getBookno(), data.getPrice(), data.getPublisher(), data.getTitle() );
		}
		
	}

//	@Test
	void add() {
		BookVO vo = new BookVO();
		vo.setTitle("jsp");
		vo.setPublisher("묭지");
		vo.setPrice(1100);
		service.bookAdd(vo);
		
	}
	
//	@Test
	void update() {
		BookVO vo = service.getBook(7);
		if(vo != null) {
			System.out.println(vo);
			vo.setPrice(0);
			service.bookUpdate(vo);
			System.out.println(service.getBook(vo.getBookno()));
		}
	}
	//@Test
	void getBook() {
		System.out.println(service.getBook(7));
	}
	//@Test
	void delete() {
		BookVO vo = service.getBook(7);
		if(vo != null) {
			System.out.println(vo);
			service.bookDelete(vo.getBookno());
			System.out.println("삭제되었습니다.");
		}
	}
	//@Test
	void search() {
		System.out.println("=== 검색 ===");
		
		List<BookVO> list = service.searchBook("title" , "j");
		for(BookVO data : list) {
			System.out.printf("%s:%d:%s %n",data.getTitle(),data.getPrice(),data.getPublisher());
		}
 	}
}
