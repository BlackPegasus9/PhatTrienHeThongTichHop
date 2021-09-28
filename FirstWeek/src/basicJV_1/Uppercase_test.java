package basicJV_1;

import java.util.Scanner;

public class Uppercase_test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input the string: ");
			String s = sc.nextLine().toUpperCase();
			System.out.println(s);
		}
	}

}
