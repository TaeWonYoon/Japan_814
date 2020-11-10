package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		BookService service = new BookServiceImpl(dao);
		
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVO vo = new BookVO();
		vo.setPrice(price);
		vo.setTitle(title);
		vo.setPublisher(publisher);
		
		service.bookAdd(vo);
		
		response.sendRedirect("bookList.do");
	}

}
