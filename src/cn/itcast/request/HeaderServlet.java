package cn.itcast.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 判断浏览器的版本
//		String agent = req.getHeader("user-agent");
//		System.out.println(agent);
				
		// 先通过referer头获取内容
		String referer = req.getHeader("referer");
		// System.out.println(referer);
		// http://localhost:8080/test/my/index.html
		// http://localhost:8080/test/bad/index.html
		
		/*response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");*/
		
		// 字符中文乱码的问题
		resp.setContentType("text/html;charset=UTF-8");
		
		if(referer != null && referer.startsWith("http://localhost:8080/test/my")){
			// 正常播放
			resp.getWriter().write("电影已经播放了...");
		}else{
			// 提示
			resp.getWriter().write("呸，臭不要脸的...");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
