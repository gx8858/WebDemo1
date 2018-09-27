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
		 * ת�����ض��������
		 * 1.�ض���ĵ�ַ�������仯��ת����ַ�����ᷢ���仯��
		 * 2.�ض����������������Ӧ��ת����һ���������Ӧ��
		 * 3.�ض�����ʹ��request�����ֵ��ת������ʹ��request�����ֵ��
		 * 4.�ض����·����/test/forwardTo����ת����·����/forwardTo��
		 * 5.�ض�����Զ����κ�ҳ�棨�����ϵ���Դ����ת��ֻ����webӦ���ڲ���
		 */
		
		// ��request���д����ֵ(ת������ʹ��request�����ֵ)
		req.setAttribute("msg", "С��");
		// �ض���Ĳ���
		// resp.sendRedirect("/test/forwardTo");
		
		// һ����forward�Ļ���ʹ��ת���Ĵ��룬ת����forwardTo��
		
		// ��ȡRequestDispatcher����
		RequestDispatcher dispatcher = req.getRequestDispatcher("/forwardTo");
		// һ��forward��������ת��
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
