package lotto.view;

import java.util.Scanner;

public class InputView {

	public InputView(String text) {
		System.out.println(text);
	}

	public int getInputInt() {
		String input = getInput();
		return Integer.parseInt(input);
	}

	public String getInputString() {
		String input = getInput();
		return input;
	}

	private String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
