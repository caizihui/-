package ����;

import javax.swing.JLabel;

/**
 * ��дJLabel��
 * <p>Label�Ĵ�С��ͼƬ�Ĵ�СΨһȷ��</p>
 * @author ���ӻ�
 *
 */
public class MyLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -356872413153021197L;
	
	public MyImageIcon img;
	
	public MyLabel(MyImageIcon img) {
		super(img);
		
		this.img = img;
		
		this.setSize(img.getIconWidth(), img.getIconHeight());
	}
	
	public void setIcon(MyImageIcon img) {
		super.setIcon(img);
		
		this.img = img;
		this.setSize(img.getIconWidth(), img.getIconHeight());
	}
}
