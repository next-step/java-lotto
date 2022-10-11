package step2;

import java.util.Scanner;

public class InputView {
	private static final Scanner sc = new Scanner(System.in);

	public static int input() {
		return Integer.parseInt(sc.nextLine());
	}
}
