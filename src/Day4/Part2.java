package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		for (String s : arr) {
			String regexpr = "^([a-z-]+)\\-(\\d{3})\\[(\\w+)]$";
			String name = s.replaceAll(regexpr, "$1");
			int sector = Integer.parseInt(s.replaceAll(regexpr, "$2"));
			String checkSum = s.replaceAll(regexpr, "$3");
			
			char[] nameChar = name.toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for (char c : nameChar) {
				if (c == '-') {
					continue;
				}
				
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			
			TreeSet<ValuedCharacter> set = new TreeSet<>();
			for (char c : map.keySet()) {
				set.add(new ValuedCharacter(c, map.get(c)));
			}
			
			String myCheckSum = "";
			for (int i=0; i<5; i++) {
				myCheckSum = myCheckSum + String.valueOf(set.last().getChar());
				set.remove(set.last());
			}
			
			if (!myCheckSum.equals(checkSum)) {
				continue;
			}
			
			int minCharValue = 97;
			int maxCharValue = 122;
			for (int i=0; i<nameChar.length; i++) {
				if (nameChar[i] == '-') {
					nameChar[i] = ' ';
					continue;
				}
				
				int numberOfChar = (int) nameChar[i];
				numberOfChar += sector;
				while ((numberOfChar < minCharValue) || (numberOfChar > maxCharValue)) {
					numberOfChar -= (maxCharValue - minCharValue + 1);
				}
				nameChar[i] = (char)numberOfChar;
			}
			
			System.out.println(String.valueOf(nameChar) + " sector = " + sector);
		}
		
	}
}