package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		ArrayList<String> list = new ArrayList<>();
		while (scan.hasNextLine()) {
			list.add(scan.nextLine());
		}
		
		scan.close();
		
		getCode(list);
	}

	public static void getCode(ArrayList<String> list) {
		int x = 0;
		int y = 2;
		String code = "";
		
		for (int i=0; i<list.size(); i++) {
			String str = list.get(i);
			
			for (int j=0; j<str.length(); j++) {
				char command = str.charAt(j);
				int newX = x;
				int newY = y;
				switch (command) {
					case 'U':
						newY--;
						break;
					case 'D':
						newY++;
						break;
					case 'L':
						newX--;
						break;
					case 'R':
						newX++;
						break;
					default:
						System.out.println("Error");
						return;
				}
				
				boolean oneButtonLineOk = ((newY == 0) || (newY == 4)) && (newX == 2);
				boolean threeButtonLineOk = ((newY == 1) || (newY == 3)) && (newX >= 1 && newX <= 3);
				boolean fiveButtonLineOk = (newY == 2) && (newX >= 0 && newX <= 4);
				boolean coordOk = oneButtonLineOk || threeButtonLineOk || fiveButtonLineOk;
				
				if (coordOk) {
					x = newX;
					y = newY;
				}
			}
			
			String coord = x + ";" + y;
			System.out.println(coord);
			String letter;
			switch (coord) {
				case ("2;0"):
					letter = "1";
					break;
				case ("1;1"):
					letter = "2";
					break;
				case ("2;1"):
					letter = "3";
					break;
				case ("3;1"):
					letter = "4";
					break;
				case ("0;2"):
					letter = "5";
					break;
				case ("1;2"):
					letter = "6";
					break;
				case ("2;2"):
					letter = "7";
					break;
				case ("3;2"):
					letter = "8";
					break;
				case ("4;2"):
					letter = "9";
					break;
				case ("1;3"):
					letter = "A";
					break;
				case ("2;3"):
					letter = "B";
					break;
				case ("3;3"):
					letter = "C";
					break;
				case ("2;4"):
					letter = "D";
					break;
				default:
					letter = "Z";
					System.out.println("Error!");
					break;
			}
			
			code = code + letter;
		}
		
		System.out.println(code);
	}
}
