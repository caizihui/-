package ����;

import java.awt.Toolkit;

public class Size {
	//��Ļ������,ԭʼ��1920*1080
	public final static double WIDTH_SCALING = (Toolkit.getDefaultToolkit().getScreenSize().width+0.0) / 1920;
	public final static double HEIGHT_SCALING = (Toolkit.getDefaultToolkit().getScreenSize().height+0.0) / 1080;
	
	//�������д�С�Լ�����
	//��ɫѡ��ͼƬ
	public final static int CHOSE_ROLE_WIDTH = Function.realWidthOf(159);
	public final static int CHOSE_ROLE_HEIGHT = Function.realHeightOf(250);
	
	//��ͼѡ��ͼƬ
	public final static int CHOSE_MAP_WIDTH =  Function.realWidthOf(400);
	public final static int CHOSE_MAP_HEIGHT = Function.realHeightOf(160);
	
	//��ͼԪ��ͼƬ
	public final static int MAP_CELL_WIDTH = Function.realWidthOf(30);
	public final static int MAP_CELL_HEIGHT = Function.realHeightOf(30);
}
