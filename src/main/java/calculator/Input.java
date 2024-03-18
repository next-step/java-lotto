package calculator;

import java.util.Scanner;

public class Input {

	private final Scanner scanner = new Scanner(System.in);

	public String inputFormulaStr() {
		System.out.print("계산식을 입력하세요 : ");
		return scanner.nextLine();
	}

}
