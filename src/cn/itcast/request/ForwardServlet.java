package cn.itcast.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 转发和重定向的区别
		 * 1.重定向的地址栏发生变化，转发地址栏不会发生变化。
		 * 2.重定向是两次请求和响应，转发是一次请求和响应。
		 * 3.重定向不能使用request域对象传值，转发可以使用request域对象传值。
		 * 4.重定向的路径（/test/forwardTo），转发的路径（/forwardTo）
		 * 5.重定向可以定向到任何页面（网络上的资源），转发只能在web应用内部。
		 */
		
		// 向request域中存入点值(转发可以使用request域对象传值)
		req.setAttribute("msg", "小凤");
		// 重定向的操作
		// resp.sendRedirect("/test/forwardTo");
		
		// 一访问forward的话，使用转发的代码，转发到forwardTo中
		
		// 获取RequestDispatcher对象
		RequestDispatcher dispatcher = req.getRequestDispatcher("/forwardTo");
		// 一个forward方法就是转发
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
