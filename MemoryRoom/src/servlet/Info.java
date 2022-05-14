package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Artist;
import bean.Cd;
import dao.ArtistDAO;
import dao.CdDAO;

@WebServlet("/servlet/Info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		// インスタンスを渡してArtist型に戻したかったけど無理だったのでString型のname経由で進めます
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String junle = request.getParameter("junle");
		if (junle.equals("artist")) {
			try{
				ArtistDAO dao = new ArtistDAO();
			
				Artist artistInfo = dao.info(name);
				// アーティスト情報がつまったartistInfoが返ってくる
				request.setAttribute("artist", artistInfo);
				request.getRequestDispatcher(
						"/WEB-INF/referenceRoom/artistInfo.jsp").forward(request, response);
			} catch (Exception e){
				e.printStackTrace(out);
			}
		} else {
			try {
				CdDAO dao = new CdDAO();
				List<Cd> cdsInfo = dao.info(name);
				// CD情報が詰まったCDインスタンスがリストの入って返ってくる
				request.setAttribute("cdsInfo", cdsInfo);
				request.getRequestDispatcher(
						"/WEB-INF/referenceRoom/cdInfo.jsp").forward(request, response);
			} catch (Exception e){
				e.printStackTrace(out);
			}
		}
	}
}
