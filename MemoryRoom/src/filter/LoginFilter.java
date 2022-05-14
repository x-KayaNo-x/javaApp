package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
@WebFilter("/WEB-INF/*")
public class LoginFilter implements Filter {
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain
	) throws IOException, ServletException {
		// (前処理)侵入者の確認
		// セッションスコープからユーザー情報を取得
		// Filterの引数とSeavletの引数が親子関係なのでダウンキャストしてあげます
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			// 侵入者はリダイレクトでおかえりいただく
			res.sendRedirect("/entrance/");
		} else {
			// お客様にはフォワードしていただく
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/searchRoom/search.jsp");
			dispatcher.forward(req, res);
		}
		
		chain.doFilter(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {}

}
