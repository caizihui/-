package ����;

import �ͻ���.Client;

/**
 * ����
 * @author ���ӻ�
 *
 */
public class Main {
	@SuppressWarnings("unused")
	public static void main(String [] args) {
		
		//��Ҫ����������ȷ��IP��ַ�Ͷ˿ں�
        Client clientTest=new Client("172.29.17.214", 1234);
        clientTest.start();
	}
}
