package cn.itcast.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardToServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 从request的域中获取值
		String msg = (String) req.getAttribute("msg");
		
		// 向页面输出一句内容
		resp.setContentType("text/html;charset=UTF-8");
		// 输出中文
		resp.getWriter().write("已经访问到了：" + msg);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
