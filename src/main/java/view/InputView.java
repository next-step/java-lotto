package view;

import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public String askFormula() {
		System.out.println("계산식을 입력해주세요");
		return scanner.nextLine();
	}
}
