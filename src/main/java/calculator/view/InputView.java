package calculator.view;

import java.util.Scanner;

public class InputView {
	private final Scanner scanner = new Scanner(System.in);

	public String getInput() {
		System.out.print("사칙연산을 수행할 값과 연산자를 입력하세요 : ");
		return scanner.nextLine();
	}
}
