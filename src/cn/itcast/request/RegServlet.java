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
 * �����û����������
 */
public class RegServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 
		 *  String getParameter(String name)  			��ȡ����Ĳ������ı��������
		 * 	String[] getParameterValues(String name) 		��ȡ����Ĳ�������ѡ��
		 * 
		 * 	������������ǵ�����һ��
		 *  Map<String,String[]> getParameterMap() 		��ȡ�����������װ���ݣ�ʹ�ø÷�����
		 *  
		 *  ����������������
		 *  
		 *  	* post����
		 *  		����request�������ı��롣����Ҫ����getParameter()����֮ǰ
		 *  		request.setCharacterEncoding("UTF-8");
		 *  	* get����ʱ
		 *  		GET�������� 
					�������һ���޸�server.xml 
					    <Connector port="80" protocol="HTTP/1.1" 
					               connectionTimeout="20000" 
					               redirectPort="8443" URIEncoding="utf-8"/>
					* �������޸�tomcat�����������ļ�Ȩ�� 
					
					�������������������
					username = URLEncoder.encode(username, "ISO8859-1");
					username = URLDecoder.decode(username, "utf-8");
					
					�����ַ�ʽ����(Ҫ��ס)
					username = new String(username.getBytes("ISO-8859-1"),"utf-8");
					
		 */
		
		// ����post��ʽ������������
		 req.setCharacterEncoding("UTF-8");
		
		
		
		// ��ȡ�û���
		String username = req.getParameter("username");
		// ���get��ʽ���������������
//		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		
		// ��ȡ����
		String password = req.getParameter("password");
		// ��ȡ�Ա�
		String sex = req.getParameter("sex");
		// ��ȡ����
		String [] loves = req.getParameterValues("love");
		
		System.out.println("�û�����" + username);
		System.out.println("���룺" + password);
		System.out.println("�Ա�" + sex);
		System.out.println("���ã�" + Arrays.toString(loves));
		
		System.out.println("===============================");
		
		// ʹ��map��װ����
		Map<String, String []> values = req.getParameterMap();
		// ������2��
		Set<String> set = values.keySet();
		for (String name : set) {
			// ��ȡֵ
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
