package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO_Mariadb;
import service.UserService;
import service.UserServiceImpl;
import vo.UserVO;

/**
 * Servlet implementation class LoginOutServlet
 */
@WebServlet({ "/login.do", "/logout.do" })
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
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
	
	
	}

}
