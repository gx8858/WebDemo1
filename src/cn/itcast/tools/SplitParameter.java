package cn.itcast.tools;

import java.util.Arrays;

public class SplitParameter {

	public static void main(String[] args) {

		/**
		 * ��ֲ��������Ϊ��
		 * username ����
		   password 123
		   sex Ů
		 */
		String str = "username=����&password=123&sex=Ů";
		String[] arr = str.split("&");
//		System.out.println(Arrays.toString(arr));  // [username=����, password=123]
		for (int i = 0; i < arr.length; i++) {
			String[] arr1 = arr[i].split("=");   // arr1 [username, ����]
			System.out.println(arr1[0] + " " + arr1[1]);
		}
	}

}
