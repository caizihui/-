package 辅助;

import javax.swing.JLabel;

/**
 * 重写JLabel类
 * <p>Label的大小由图片的大小唯一确定</p>
 * @author 蔡子辉
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
