package cn.itcast.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����������������
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
	 * ����ֽ�����
	 * 
	 * �����ֽڵ��Ƿ�����
	 * 1.�����ҳ�����Ƿ�����
	 *   �п������루IE����UTF-8�����룩
	 *   
	 * ������⣺
	 * 
	    *.������������ļ�ʱ���õı��롣������һ��		
	  			response.setHeader("Content-Type", "text/html;charset=UTF-8");
	  	*.��ȡ���ĵ��ֽ�����Ҳ���ù̶��ı��롣���������
	  			"�����ҵ�".getBytes("UTF-8")
	  	*.ֻ��Ҫ����һ�ͱ������֤һ�¾Ͳ������롣
	 */
	public void run1(HttpServletResponse resp) throws IOException {
		// ���������Ĭ�ϴ��ļ�ʱ���ñ���
//		resp.setHeader("Content-Type", "text/html;charset=UTF-8"); ��������䣬Ч����һ��
		resp.setContentType("text/html;charset=UTF-8");
		//��ȡ����Ȼ�����
		resp.getOutputStream().write("��������".getBytes("UTF-8"));
	}
	
	/**
	 * ����ַ�����
	 * 
	   *.����response�������ı��루Ĭ����ISO-8859-1����
	 		response.setCharacterEncoding("UTF-8");
	   *.�����������Ĭ�ϴ��ļ��ı���
	  		response.setHeader("Content-Type", "text/html;charset=UTF-8");
	  		
	   *.�ַ���������������м򵥵�д��
		response.setContentType("text/html;charset=UTF-8");
	 */
	public void run2(HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		// ��
//		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("����");
	}
}
