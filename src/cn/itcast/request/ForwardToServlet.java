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
		
		// ��request�����л�ȡֵ
		String msg = (String) req.getAttribute("msg");
		
		// ��ҳ�����һ������
		resp.setContentType("text/html;charset=UTF-8");
		// �������
		resp.getWriter().write("�Ѿ����ʵ��ˣ�" + msg);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
