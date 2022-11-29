package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		List<Triangle> list = new ArrayList<>();
		for (String str : arr) {
		    final String regex = "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)$";
		    final int a = Integer.parseInt(str.replaceAll(regex, "$1"));
		    final int b = Integer.parseInt(str.replaceAll(regex, "$2"));
		    final int c = Integer.parseInt(str.replaceAll(regex, "$3"));
			list.add(new Triangle(a, b, c));
		}
		
		int sum = 0;
		for (Triangle tr : list) {
			sum = sum + (tr.isTriangle() ? 1 : 0);
		}
		
		System.out.println(sum);
	}
}

