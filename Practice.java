package test;

import java.util.Arrays;
import java.util.List;

class Mine{
	int width;
	int height;
	double percent;
	String[][] map;
	
	Mine(int width, int height, double percent){
		this.width = width;
		this.height = height;
		this.percent = percent;
		this.map = new String[height][width];
	}
	
	public void init() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				map[i][j] = "-";
			}
		}
	}
	
	public void setMine() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if((int)(Math.random() * 10.0) <= (int)(percent * 10.0)) {
					map[i][j] = "*";
				}
			}
		}
	}
	
	public void setNumOfMine(){
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				int num = 0;
				if(map[i][j] != "*") {
					if(i - 1 >= 0) { num += map[i-1][j].equals("*") ? 1 : 0; } // 바로 위
					if(i - 1 >= 0 && j - 1 >= 0) { num += map[i-1][j-1] == "*" ? 1 : 0; }
					if(j - 1 >= 0) { num += map[i][j-1] == "*" ? 1 : 0; }
					if(i + 1 < height && j - 1 >= 0) { num += map[i+1][j-1] == "*" ? 1 : 0; }
					
					if(i + 1 < height) { num += map[i+1][j] == "*" ? 1 : 0; }
					if(i + 1 < height && j + 1 < width) { num += map[i+1][j+1] == "*" ? 1 : 0; }
					if(j + 1 < width) { num += map[i][j+1] == "*" ? 1 : 0; }
					if(j + 1 < width && i - 1 >= 0) { num += map[i-1][j+1] == "*" ? 1 : 0; }
					map[i][j] = String.valueOf(num);
				}
			}
		}
	}
	
	
	
	public void print() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
public class Practice {
	public static void main(String[] args) {
		Mine m = new Mine(10,5,0.3);
		m.init();
		m.setMine();
		m.setNumOfMine();
		m.print();
	}
}
