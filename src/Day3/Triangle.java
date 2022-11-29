package Day3;

public class Triangle {
	int a;
	int b;
	int c;
	
	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean isTriangle() {
		return (a + b) > c && (a + c) > b && (b + c) > a;
	}
}
