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
import bean.Song;
import dao.ArtistDAO;
import dao.CdDAO;
import dao.CdEditionDAO;
import dao.SongDAO;

@WebServlet("/servlet/Search")
public class Search extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ジャンルごとの検索
		request.setCharacterEncoding("UTF-8");
		
		String junle = request.getParameter("junle");
		String keyword = request.getParameter("keyword");
		int possession = Integer.parseInt(request.getParameter("possession"));
		
		if (junle.equals("artist")) {
			try{
				ArtistDAO dao = new ArtistDAO();
				List<Artist> list = dao.search(keyword);
				// アーティスト名が入ったリストがかえってくる
				request.setAttribute("list", list);
				
				request.getRequestDispatcher(
						"/WEB-INF/resultRoom/artistResult.jsp").forward(request, response);
			
			} catch (Exception e) {
				e.printStackTrace(out);
			}
		}
		if (junle.equals("cd")) {
			try{
				
				if (possession == 2) {
					// 所持指定なしなのでそのまま名前順で一覧表示
					CdDAO dao = new CdDAO();
					List<Cd> list = dao.search(keyword);
					request.setAttribute("list", list);
					request.getRequestDispatcher(
							"/WEB-INF/resultRoom/cdResult.jsp").forward(request, response);
				} else {
					// 所持指定ありなので、エディションごとの表示
					CdEditionDAO dao = new CdEditionDAO();
					List<Cd> list = dao.possSearch(keyword, possession);
					request.setAttribute("list", list);
					request.getRequestDispatcher(
							"/WEB-INF/resultRoom/cdPossList.jsp").forward(request, response);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace(out);
			}
		} 
		if (junle.equals("song")){
			try{
				SongDAO dao = new SongDAO();
				List<Song> songlist = dao.search(keyword);
				request.setAttribute("songlist", songlist);
				request.getRequestDispatcher(
						"/WEB-INF/resultRoom/songResult.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace(out);
			}
		}
	}
}
