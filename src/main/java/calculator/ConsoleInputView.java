package calculator;

import java.util.Scanner;

public class ConsoleInputView {
	private final String GUIDE = "계산할 문자열을 입력해주세요.";
	public String input(){
		System.out.println(GUIDE);
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		return input;
	}
}
