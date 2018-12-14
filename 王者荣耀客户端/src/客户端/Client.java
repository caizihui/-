package 客户端;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import 战斗界面.BattleFrame;
import 选择界面.ChooseFrame;

	 public class Client extends Thread {
		//依附的窗体
		public static ChooseFrame chooseFrame = null;
		public static BattleFrame battleFrame = null;
		
		//指定命令
		public static String sendedOrder = "";
		//命令改变标志符
		public static boolean sendedOrderIsChanged = false;
		
		//从对方接受的命令
		public static String receivedOrder = "";
		//接受指令是否发生变化
		public static boolean receivedOrderIsChanged = false;
		 
		 
	     //定义一个Socket对象
	     Socket socket = null;

	     public Client(String host, int port) {
	         try {
	             //需要服务器的IP地址和端口号，才能获得正确的Socket对象
	             socket = new Socket(host, port);
	         } catch (UnknownHostException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }

	     }

	     @Override
	     public void run() {
	         //客户端一连接就可以写数据个服务器了
	         new sendMessThread().start();
	         super.run();
	         try {
	             // 读Sock里面的数据
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
	            		//防止多次发送的指令粘合在一起
	             		//只要有指令就需要解读
	             		while(receivedOrder.length() != 0) {
	             			//找到总指令的第一条
	             			oneOrderLength = receivedOrder.indexOf('#');
	             			//解读总指令的第一个指令
	             			battleFrame.panel.understandOtherRoleOrder(receivedOrder.substring(0, oneOrderLength));
	             			//删除该条已执行的指令
	             			receivedOrder = receivedOrder.substring(oneOrderLength+1,receivedOrder.length());
	             		}
	             		
	             		//成功读完粘合在一起的指令
	             		receivedOrderIsChanged = false;
	            	 }
	            	 
	            	 System.out.print("");
	            	 
	             }

	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }

	     //往Socket里面写数据，需要新开一个线程
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
	                 } while (!sendedOrder.equals("结束"));
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