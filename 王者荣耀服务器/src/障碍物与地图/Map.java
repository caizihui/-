package 障碍物与地图;

import 战斗界面.BattlePanel;
import 辅助.PictureName;
import 辅助.Point;
import 辅助.Size;
import 辅助.Function;
import 辅助.MyImageIcon;
import 辅助.MyLabel;

/**
 * 地图类
 * @author 蔡子辉
 *
 */
public class Map {
	/**
	 * 地图的面板载体
	 */
	public static BattlePanel panel = null;
	/**
	 * 标签,内含图片
	 */
	public MyLabel mapCellLabel[][];
	
	/**
	 * 为地图增加单个障碍物
	 * @param barrier 障碍物
	 */
	private void addBarrier(Barrier barrier) {
		int i,j;
		int beginX,beginY;
		
		beginX = barrier.position.getX();
		beginY = barrier.position.getY();
		
		for(i=0 ; i<barrier.height && beginX+i<mapCellLabel.length ; i++) {
			for(j=0 ; j<barrier.width && beginY+j<mapCellLabel[i].length ; j++) {
				//转换size的事交给了MyImageIcon的构造函数
				mapCellLabel[beginX+i][beginY+j].setIcon(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
			}
		}
	}
	
	/**
	 * 构造地图
	 * @param width 地图宽
	 * @param height 地图高
	 * @param barrier 地图上所有的障碍物
	 */
	public Map(int width,int height,Barrier barrier[]) {
		int i,j;
		
		mapCellLabel = new MyLabel[height][width];
		
		for(i=0 ; i<mapCellLabel.length ; i++) {
			//第一行与最后一行特殊，全是墙
			if(i==0 || i==mapCellLabel.length-1) {
				for(j=0 ; j<mapCellLabel[i].length ; j++) {
					mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					
					panel.add(mapCellLabel[i][j]);
					mapCellLabel[i][j].setLocation(j*Size.MAP_CELL_WIDTH, i*Size.MAP_CELL_HEIGHT);
				}
			}
			
			else {
				for(j=0 ; j<mapCellLabel[i].length ; j++) {
					if(j==0 || j==mapCellLabel[i].length-1) {
						mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.WALL,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					}
					
					else {
						mapCellLabel[i][j] = new MyLabel(new MyImageIcon(PictureName.SPACE,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
					}
					
					panel.add(mapCellLabel[i][j]);
					mapCellLabel[i][j].setLocation(j*Size.MAP_CELL_WIDTH, i*Size.MAP_CELL_HEIGHT);
				}
			}
		}
		
		//处理障碍物
		for(i=0 ; i<barrier.length ; i++) {
			this.addBarrier(barrier[i]);
		}
	}
	
	/**
	 * 判断一个点是否在地图上
	 * @param position 点的位置
	 * @return boolean
	 */
	public boolean contains(Point position) {
		if(position.getX() >= 0 && position.getX() < mapCellLabel.length 
		&& position.getY() >= 0 && position.getY() < mapCellLabel[0].length) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取指定点的图片描述
	 * @param position 指定点
	 * @return String 该点的图片描述
	 */
	public String get(Point position) {
		if(contains(position)) {
			return mapCellLabel[position.getX()][position.getY()].img.getDescription();
		}
		
		return null;
	}
	
	/**
	 * 更改地图上指定点的图片，只能更改空白格
	 * @param position 指定点
	 * @param description 图片描述
	 * @return boolean 更改是否成功的信息
	 */
	public boolean replace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//不是墙、英雄
			if(tempDescription.equals(PictureName.WALL)==false && Function.isRole(tempDescription)==false) {
				
				mapCellLabel[position.getX()][position.getY()].setIcon(new MyImageIcon(description,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 更改地图上指定点的图片，除了墙，其他的都能更改
	 * @param position 指定点
	 * @param description 图片描述
	 * @return boolean 更改是否成功的信息
	 */
	public boolean sharpReplace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//不是墙
			if(tempDescription.equals(PictureName.WALL)==false) {
				mapCellLabel[position.getX()][position.getY()].setIcon(new MyImageIcon(description,Size.MAP_CELL_WIDTH,Size.MAP_CELL_HEIGHT));
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 获取地图上的一个空格点
	 * @return Point 空格点
	 */
	public Point getASpacePoint() {
		Point result;
		
		while(true) {
			result = new Point((int)(Math.random()*this.mapCellLabel.length),(int)(Math.random()*this.mapCellLabel[0].length));
			
			if(this.get(result).equals(PictureName.SPACE)) {
				return result;
			}
		}
	}
}
