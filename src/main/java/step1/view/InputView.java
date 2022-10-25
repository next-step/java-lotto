package step1.view;

import java.util.Scanner;

public class InputView {
	public final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getOperation() {
		return scanner.nextLine();
	}
}
