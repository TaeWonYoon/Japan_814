package util;

import dao.BookDAO_Mariadb;
import vo.BookVO;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookDAO_Mariadb b = new BookDAO_Mariadb();
		
		BookVO vo = new BookVO();
		//삽입
		vo.setTitle("taewon");
		vo.setPublisher("명지");
		vo.setPrice(6700);
		b.bookAdd(vo);
		//삭제
//		vo.setBookno(3);
//		b.bookDelete(vo.getBookno());
		//업데이트
//		vo.setPrice(6000);
//		vo.setBookno(5);
//		b.bookUpdate(vo);
		
//		BookVO book = b.getBook(5);
//		if(book != null) {
//		System.out.println(book);
//		book.setPrice(book.getPrice()*2);
//		b.bookUpdate(book);
//		BookVO book2 = b.getBook(book.getBookno());
//		System.out.println(book2);
//		b.bookDelete(book2.getBookno());
//		System.out.println(b.getBook(book2.getBookno()));
//		}
//		
//		b.bookList().forEach(i->{System.out.println(i);});
		
		b.bookSearch("title", "s").forEach(i -> {System.out.println(i);});
		
	}

}
