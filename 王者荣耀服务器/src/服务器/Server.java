package ������;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ս������.BattleFrame;
import ѡ�����.ChooseFrame;


public  class  Server extends Thread{
	//�����Ĵ���
	public static ChooseFrame chooseFrame = null;
	public static BattleFrame battleFrame = null;
	
	//���͸��Է�������
	public static String sendedOrder = "";
	//����ָ���Ƿ����仯
	public static boolean sendedOrderIsChanged = false;
	
	//�ӶԷ����ܵ�����,ȫ�������������Է����ٹ�����ɲ�ͬ��
	public static String receivedOrder = "";
	//����ָ���Ƿ����仯
	public static boolean receivedOrderIsChanged = false;
	
	
    ServerSocket server = null;
    Socket socket = null;
    
    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        super.run();
        try{
            System.out.println("�ȴ��ͻ�������...");
            socket = server.accept();
            new sendMessThread().start();//���Ӳ�����socket�������÷�����Ϣ�߳�
            System.out.println(socket.getInetAddress().getHostAddress()+"�ɹ����ӣ�");
            InputStream in = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            int oneOrderLength;
            
            while (receivedOrderIsChanged || (len=in.read(buf))!=-1){
            	//���µ��ַ�������
            	if(receivedOrderIsChanged == false) {
            		receivedOrder = new String(buf,0,len);
            		//Ϊ����һ��ѭ����֪������ɹ�����
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
            	
            	//��֪��
            	System.out.print("");	
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //������Ϣ
    class sendMessThread extends Thread{
        @Override
        public void run(){
            super.run();
            OutputStream out = null;
            try{
            	//���ӳɹ�
                if(socket != null){
                	//��������
                	chooseFrame = new ChooseFrame();
                	
                    out = socket.getOutputStream();
                    
                    do {
                    	//��֪��ΪʲôҪ���
                    	System.out.print("");
                    	
                    	if(sendedOrderIsChanged) {
                    		//����ǰ��ӽ�����
                    		out.write((sendedOrder+"#").getBytes());
                    		sendedOrderIsChanged = false;
                    	}
                        out.flush();//��ջ�����������
                    }while(!sendedOrder.equals("����"));
                    
                    try{
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}