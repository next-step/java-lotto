package lotto.view;

import java.util.Scanner;

public class InputView {

	private String text;

	public int getInputInt(String text) {
		this.text = text;
		String input = getInput();
		return Integer.parseInt(input);
	}

	public String getInputString(String text) {
		this.text = text;
		String input = getInput();
		return input;
	}

	private String getInput() {
		if (!text.isEmpty()) {
			System.out.println(text);
		}
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
