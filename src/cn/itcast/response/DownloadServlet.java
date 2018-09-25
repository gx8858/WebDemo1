package cn.itcast.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ļ����غ�̨����
 */
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 4626987070464637076L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * ������ô����
		 * 	1.��ȡ�ļ���������
		 * 	2.��ͻ����������
		 * 	3.��д
		 */
		// ����ͷ��Ϣ����������ʽ�򿪸��ļ�
		resp.setHeader("Content-Disposition", "attachment;filename=girl7.jpg");
		
		// ͨ�������ȡ�ļ��ľ��Դ���·��
		String path = getServletContext().getRealPath("/img/girl7.jpg");
		// System.out.println(path);
		// ��ȡimgͼƬ�µ��ļ���·��
		InputStream in = new FileInputStream(path);
		// ��ͻ������
		OutputStream os = resp.getOutputStream();
		// ��д
		byte [] b = new byte[1024];
		int len = 0;
		while((len = in.read(b)) != -1){
			os.write(b, 0, len);
		}
		in.close();
		os.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
