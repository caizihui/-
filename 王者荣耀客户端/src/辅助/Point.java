package 辅助;

import 战斗界面.BattlePanel;

/**
 * 点类
 * @author 蔡子辉
 *
 */
public class Point {
	public static BattlePanel panel = null;
	
	private int x = 0;
	private int y = 0;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(String str) {
		int i;
		String xStr,yStr;
		char temp;
		
		xStr = yStr = "";
		
		for(i=0 ; i<str.length() ; i++) {
			temp = str.charAt(i);
			
			if(temp == '_') {
				break;
			}
			
			xStr += temp;
		}
		
		for(i++ ; i<str.length() ; i++) {
			yStr += str.charAt(i);
		}
		
		this.x = Integer.valueOf(xStr);
		this.y = Integer.valueOf(yStr);
	}
	
	public Point() {}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public Point setXY(int x,int y) {
		return new Point(x,y);
	}
	
	public Point setX(int x) {
		return new Point(x,this.y);
	}
	
	public Point setY(int y) {
		return new Point(this.x,y);
	}
	
	public String getRelationWith(Point anotherPoint) {
		String result = "";
		
		if(anotherPoint.y < this.y) {
			result += "左";
		}
		
		else {
			result += "右";
		}
		
		if(anotherPoint.x < this.x) {
			result += "上";
		}
		
		else {
			result += "下";
		}
		
		return result;
	}
	
	public boolean isSameWith(Point anotherPoint) {
		if(this.x==anotherPoint.x && this.y==anotherPoint.y) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return String.valueOf(this.x)+"_"+String.valueOf(this.y);
	}
	
}
