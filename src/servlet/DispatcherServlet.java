package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO_Mariadb;
import dao.UserDAO_Mariadb;
import service.BookService;
import service.BookServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import vo.BookVO;
import vo.UserVO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf('/'));
		System.out.printf("요청 : %s\n", action);
		
		if(action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			
			UserDAO_Mariadb dao = new UserDAO_Mariadb();
			UserService service = new UserServiceImpl(dao);
			
			UserVO login = service.login(id, pw);
			
			if(login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				
				getServletContext().
				getRequestDispatcher("/index.jsp").
				forward(request, response); 
			} else {
				request.setAttribute("msg", "로그인 실패, 로그인정보를다시 입력하세요");
				getServletContext().
				getRequestDispatcher("/login.jsp").
				forward(request, response);
			}
			return;
		}
		
		if(action.equals("/logout.do")) {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
			}
			response.sendRedirect("index.jsp");		
			return;
		}
		
		if(action.equals("/add.do")) {
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
			return;
		}
		
		if(action.equals("/bookList.do")) {
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
			return;
		}
		
		if(action.equals("/viewBook.do")) {
			int bookno = Integer.parseInt(request.getParameter("bookno"));
			
			BookDAO_Mariadb dao = new BookDAO_Mariadb();
			BookService service = new BookServiceImpl(dao);
			BookVO vo = service.getBook(bookno);
			
			//PrintWriter out = response.getWriter();
			//list.forEach(i -> { out.println("<h3>"+i+"</h3>");});
			request.setAttribute("book", vo);
			String page = "/bookView.jsp";
			
			getServletContext().
			getRequestDispatcher(page).
			forward(request, response); 
			return;
		}
		
		if(action.equals("/delete.do")) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			BookDAO_Mariadb dao = new BookDAO_Mariadb();
			BookService service = new BookServiceImpl(dao);
			
			String[] bookno = request.getParameterValues("bookno");
			
			for(String no : bookno) {
				service.bookDelete(Integer.parseInt(no));
			}
			
			response.sendRedirect("bookList.do");
			return;
		}
		
		if(action.equals("/bookSearch.do")) {
			String condition = request.getParameter("condition");
			String keyword = request.getParameter("keyword");
			
			BookDAO_Mariadb dao = new BookDAO_Mariadb();
			BookService service = new BookServiceImpl(dao);
			List<BookVO> list = service.searchBook(condition, keyword);
			
			request.setAttribute("bookList", list);
			String page = "/bookList.jsp";
			
			getServletContext().
			getRequestDispatcher(page).
			forward(request, response); 
			return;
		}
	}
}
