package �ͻ���;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ս������.BattleFrame;
import ѡ�����.ChooseFrame;

	 public class Client extends Thread {
		//�����Ĵ���
		public static ChooseFrame chooseFrame = null;
		public static BattleFrame battleFrame = null;
		
		//ָ������
		public static String sendedOrder = "";
		//����ı��־��
		public static boolean sendedOrderIsChanged = false;
		
		//�ӶԷ����ܵ�����
		public static String receivedOrder = "";
		//����ָ���Ƿ����仯
		public static boolean receivedOrderIsChanged = false;
		 
		 
	     //����һ��Socket����
	     Socket socket = null;

	     public Client(String host, int port) {
	         try {
	             //��Ҫ��������IP��ַ�Ͷ˿ںţ����ܻ����ȷ��Socket����
	             socket = new Socket(host, port);
	         } catch (UnknownHostException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }

	     }

	     @Override
	     public void run() {
	         //�ͻ���һ���ӾͿ���д���ݸ���������
	         new sendMessThread().start();
	         super.run();
	         try {
	             // ��Sock���������
	             InputStream s = socket.getInputStream();
	             byte[] buf = new byte[1024];
	             int len = 0;
	             int oneOrderLength;
	             
	             while (receivedOrderIsChanged || (len = s.read(buf)) != -1) {
	            	 if(receivedOrderIsChanged == false) {
	            		 receivedOrder = new String(buf, 0, len);
		            	 receivedOrderIsChanged = true;
	            	 }
	            	 
	            	 if(battleFrame != null) {
	            		//��ֹ��η��͵�ָ��ճ����һ��
	             		//ֻҪ��ָ�����Ҫ���
	             		while(receivedOrder.length() != 0) {
	             			//�ҵ���ָ��ĵ�һ��
	             			oneOrderLength = receivedOrder.indexOf('#');
	             			//�����ָ��ĵ�һ��ָ��
	             			battleFrame.panel.understandOtherRoleOrder(receivedOrder.substring(0, oneOrderLength));
	             			//ɾ��������ִ�е�ָ��
	             			receivedOrder = receivedOrder.substring(oneOrderLength+1,receivedOrder.length());
	             		}
	             		
	             		//�ɹ�����ճ����һ���ָ��
	             		receivedOrderIsChanged = false;
	            	 }
	            	 
	            	 System.out.print("");
	            	 
	             }

	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }

	     //��Socket����д���ݣ���Ҫ�¿�һ���߳�
	     class sendMessThread extends Thread{
	         @Override
	         public void run() {
	             super.run();
	            
	             OutputStream os= null;
	             try {
	            	 chooseFrame = new ChooseFrame();
	            	 
	                 os= socket.getOutputStream();
	                 do {
	                	 System.out.print("");
	                	 
	                     if(sendedOrderIsChanged) {
	                    	 os.write((sendedOrder+"#").getBytes());
	                    	 
	                    	 sendedOrderIsChanged = false;
	                    	 
	                     }
	                	 
	                     os.flush();
	                 } while (!sendedOrder.equals("����"));
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	             
	             try {
	                 os.close();
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
	 }