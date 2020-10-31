package util;

import dao.BookDAO_Mariadb;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookDAO_Mariadb b = new BookDAO_Mariadb();
		b.bookList().forEach(i->{System.out.println(i);});
		
	}

}
