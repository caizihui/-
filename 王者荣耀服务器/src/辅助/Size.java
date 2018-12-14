package 辅助;

import java.awt.Toolkit;

public class Size {
	//屏幕缩放量,原始量1920*1080
	public final static double WIDTH_SCALING = (Toolkit.getDefaultToolkit().getScreenSize().width+0.0) / 1920;
	public final static double HEIGHT_SCALING = (Toolkit.getDefaultToolkit().getScreenSize().height+0.0) / 1080;
	
	//以下所有大小以及修正
	//角色选择图片
	public final static int CHOSE_ROLE_WIDTH = Function.realWidthOf(159);
	public final static int CHOSE_ROLE_HEIGHT = Function.realHeightOf(250);
	
	//地图选择图片
	public final static int CHOSE_MAP_WIDTH =  Function.realWidthOf(400);
	public final static int CHOSE_MAP_HEIGHT = Function.realHeightOf(160);
	
	//地图元素图片
	public final static int MAP_CELL_WIDTH = Function.realWidthOf(30);
	public final static int MAP_CELL_HEIGHT = Function.realHeightOf(30);
}
