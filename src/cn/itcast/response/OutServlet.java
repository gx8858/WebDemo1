package cn.itcast.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理中文乱码问题
 */
public class OutServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332255458341406801L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		run1(resp);
		run2(resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	/**
	 * 解决字节乱码
	 * 
	 * 测试字节的是否乱码
	 * 1.输出到页面上是否乱码
	 *   有可能乱码（IE调成UTF-8即乱码）
	 *   
	 * 解决问题：
	 * 
	    *.设置浏览器打开文件时采用的编码。（编码一）		
	  			response.setHeader("Content-Type", "text/html;charset=UTF-8");
	  	*.获取中文的字节数组也采用固定的编码。（编码二）
	  			"哈罗我的".getBytes("UTF-8")
	  	*.只需要编码一和编码二保证一致就不会乱码。
	 */
	public void run1(HttpServletResponse resp) throws IOException {
		// 设置浏览器默认打开文件时采用编码
//		resp.setHeader("Content-Type", "text/html;charset=UTF-8"); 或下面这句，效果都一样
		resp.setContentType("text/html;charset=UTF-8");
		//获取中文然后输出
		resp.getOutputStream().write("测试乱码".getBytes("UTF-8"));
	}
	
	/**
	 * 解决字符乱码
	 * 
	   *.设置response缓冲区的编码（默认是ISO-8859-1）。
	 		response.setCharacterEncoding("UTF-8");
	   *.设置浏览器的默认打开文件的编码
	  		response.setHeader("Content-Type", "text/html;charset=UTF-8");
	  		
	   *.字符的中文乱码可以有简单的写法
		response.setContentType("text/html;charset=UTF-8");
	 */
	public void run2(HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 或
//		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("乱码");
	}
}
