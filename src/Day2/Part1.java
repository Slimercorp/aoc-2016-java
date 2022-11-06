package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

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
		int x = 1;
		int y = 1;
		int[] code = new int[5];
		
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
				
				if (newX >= 0 && newX <= 2 && newY >= 0 && newY <= 2) {
					x = newX;
					y = newY;
				}
			}
			
			String coord = x + ";" + y;
			System.out.println(coord);
			switch (coord) {
				case ("0;0"):
					code[i] = 1;
					break;
				case ("1;0"):
					code[i] = 2;
					break;
				case ("2;0"):
					code[i] = 3;
					break;
				case ("0;1"):
					code[i] = 4;
					break;
				case ("1;1"):
					code[i] = 5;
					break;
				case ("2;1"):
					code[i] = 6;
					break;
				case ("0;2"):
					code[i] = 7;
					break;
				case ("1;2"):
					code[i] = 8;
					break;
				case ("2;2"):
					code[i] = 9;
					break;
				default:
					System.out.println("Error!");
					break;
			}
		}
		
		System.out.println(Arrays.toString(code));
	}
}
