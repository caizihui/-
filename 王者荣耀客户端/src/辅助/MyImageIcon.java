package ����;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MyImageIcon extends ImageIcon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7524191862386305136L;
	
	public MyImageIcon(String description,int width,int height) {
		//����ͼƬ����ʱ���ֻȡ����ͼƬ�����С
		super(description);
		
		Image img = this.getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		this.setImage(img);
	}
}
