package cn.itcast.response;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��Ϥ����
 * @author Administrator
 *
 */
public class CheckcodeDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 1.��ȡ��������
		 * 2.��ȡ���ʶ���
		 * 3.��һЩ����
		 * 4.׼����һЩ����
		 * 5.���ڴ��еĻ���������ͻ�����
		 */
		// ��ȡ��������
		BufferedImage image = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
		// ��ȡ���ʶ���
		Graphics g = image.getGraphics();
		// ���û��ʵ���ɫ
		g.setColor(Color.RED);
		// ��һ������
		g.drawRect(100, 100, 150, 150);
		
		// ��ǰ׼��������
		String str = "abcd";
		
		g.setColor(Color.YELLOW);
		// ���ַ���д��ֽ��
		g.drawString(str, 50, 50);
		
		// ���ڴ��е�ͼƬ����ͻ�����
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}