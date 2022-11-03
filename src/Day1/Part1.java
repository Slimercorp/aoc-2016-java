package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();
		scan.close();
		String[] strSep = str.split(", ");
		
		getCoord(strSep);
		
	}

	public static void getCoord(String[] strSep) {
		int x = 0;
		int y = 0;
		int yaw = 0;
		for (int i=0; i<strSep.length; i++) {
			switch (strSep[i].charAt(0)) {
				case 'R':
					yaw += 90;
					break;
				case 'L':
					yaw -= 90;
					break;
				default:
					System.out.println("Error1!");
					return;
			}
			
			if (yaw >= 360) {
				yaw = yaw - 360;
			}
			
			if (yaw < 0) {
				yaw = yaw + 360;
			}
			
			int step = Integer.parseInt(strSep[i].substring(1, strSep[i].length()));

			switch (yaw) {
				case 0:
					y += step;
					break;
				case 90:
					x += step;
					break;
				case 180:
					y -= step;
					break;
				case 270:
					x -= step;
					break;
				default:
					System.out.println("Error2! yaw = " + yaw);
					return;
			}
		}
		
		System.out.println("Result = " + (Math.abs(x) + Math.abs(y)) + "; x = " + x + "; y = " + y);
	}
}
