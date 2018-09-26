package cn.itcast.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接收用户输入的数据
 */
public class RegServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 
		 *  String getParameter(String name)  			获取请求的参数（文本框，密码框）
		 * 	String[] getParameterValues(String name) 		获取请求的参数（复选框）
		 * 
		 * 	下面这个方法是单独的一组
		 *  Map<String,String[]> getParameterMap() 		获取请求参数（封装数据，使用该方法）
		 *  
		 *  解决中文乱码的问题
		 *  
		 *  	* post请求
		 *  		设置request缓冲区的编码。必须要放在getParameter()方法之前
		 *  		request.setCharacterEncoding("UTF-8");
		 *  	* get请求时
		 *  		GET请求乱码 
					解决方案一：修改server.xml 
					    <Connector port="80" protocol="HTTP/1.1" 
					               connectionTimeout="20000" 
					               redirectPort="8443" URIEncoding="utf-8"/>
					* 必须有修改tomcat服务器配置文件权限 
					
					解决方案二：逆向编解码
					username = URLEncoder.encode(username, "ISO8859-1");
					username = URLDecoder.decode(username, "utf-8");
					
					第三种方式编码(要记住)
					username = new String(username.getBytes("ISO-8859-1"),"utf-8");
					
		 */
		
		// 设置post方式的中文乱码解决
		 req.setCharacterEncoding("UTF-8");
		
		
		
		// 获取用户名
		String username = req.getParameter("username");
		// 解决get方式的中文乱码的问题
//		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		
		// 获取密码
		String password = req.getParameter("password");
		// 获取性别
		String sex = req.getParameter("sex");
		// 获取爱好
		String [] loves = req.getParameterValues("love");
		
		System.out.println("用户名：" + username);
		System.out.println("密码：" + password);
		System.out.println("性别：" + sex);
		System.out.println("爱好：" + Arrays.toString(loves));
		
		System.out.println("===============================");
		
		// 使用map封装数据
		Map<String, String []> values = req.getParameterMap();
		// 遍历有2种
		Set<String> set = values.keySet();
		for (String name : set) {
			// 获取值
			String[] value = values.get(name);
			System.out.println(name + " : " + Arrays.toString(value));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
