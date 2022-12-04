package Day4;

import java.util.Objects;

public class ValuedCharacter implements Comparable<ValuedCharacter> {
	char c;
	int value;
	
	ValuedCharacter(char c, int value) {
		this.c = c;
		this.value = value;
	}
	
	char getChar() {
		return c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValuedCharacter other = (ValuedCharacter) obj;
		return c == other.c && value == other.value;
	}

	@Override
	public int compareTo(ValuedCharacter o) {
		// 1 -> bigger
		// 0 -> equals
		// -1 -> lesser
		
		if (this.value > o.value) {
			return 1;
		} else if (this.value == o.value) {
			return o.c - this.c;
		} else {
			return -1;
		}
	}
	
	
}