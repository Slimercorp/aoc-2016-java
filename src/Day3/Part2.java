package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		List<Triangle> list = new ArrayList<>();
		for (int i = 0; i < arr.length-2; i = i + 3) {
		    final String regex = "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)$";
		    
		    String str1 = arr[i];
		    String str2 = arr[i+1];
		    String str3 = arr[i+2];
		   
		    int a = Integer.parseInt(str1.replaceAll(regex, "$1"));
		    int b = Integer.parseInt(str2.replaceAll(regex, "$1"));
		    int c = Integer.parseInt(str3.replaceAll(regex, "$1"));
			list.add(new Triangle(a, b, c));
			
			a = Integer.parseInt(str1.replaceAll(regex, "$2"));
		    b = Integer.parseInt(str2.replaceAll(regex, "$2"));
		    c = Integer.parseInt(str3.replaceAll(regex, "$2"));
			list.add(new Triangle(a, b, c));
			
			a = Integer.parseInt(str1.replaceAll(regex, "$3"));
		    b = Integer.parseInt(str2.replaceAll(regex, "$3"));
		    c = Integer.parseInt(str3.replaceAll(regex, "$3"));
			list.add(new Triangle(a, b, c));
		}
		
		int sum = 0;
		for (Triangle tr : list) {
			sum = sum + (tr.isTriangle() ? 1 : 0);
		}
		
		System.out.println(sum);
	}
}

