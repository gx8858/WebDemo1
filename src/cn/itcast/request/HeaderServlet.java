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
		// �ж�������İ汾
//		String agent = req.getHeader("user-agent");
//		System.out.println(agent);
				
		// ��ͨ��refererͷ��ȡ����
		String referer = req.getHeader("referer");
		// System.out.println(referer);
		// http://localhost:8080/test/my/index.html
		// http://localhost:8080/test/bad/index.html
		
		/*response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");*/
		
		// �ַ��������������
		resp.setContentType("text/html;charset=UTF-8");
		
		if(referer != null && referer.startsWith("http://localhost:8080/test/my")){
			// ��������
			resp.getWriter().write("��Ӱ�Ѿ�������...");
		}else{
			// ��ʾ
			resp.getWriter().write("�ޣ�����Ҫ����...");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
