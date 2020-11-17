package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;
import vo.UserVO;

@WebServlet("/bookList.do")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			HttpSession session = request.getSession();
			UserVO login = (UserVO)session.getAttribute("login");
			if(login == null) {
				request.setAttribute("msg", "로그인이 필요합니다.");
				getServletContext().
				getRequestDispatcher("/login.jsp").
				forward(request, response);
				return;
				//response.sendRedirect("/web-study/index.jsp");
			}
			
			BookDAO_Mariadb dao = new BookDAO_Mariadb();
			BookService service = new BookServiceImpl(dao);
			List<BookVO> list = service.bookList();
			
			//PrintWriter out = response.getWriter();
			//list.forEach(i -> { out.println("<h3>"+i+"</h3>");});
			request.setAttribute("bookList", list);
			String page = "/bookList.jsp";
			
			getServletContext().
			getRequestDispatcher(page).
			forward(request, response); 
			
			
	}

}
