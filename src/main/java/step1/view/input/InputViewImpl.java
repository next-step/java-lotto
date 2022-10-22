package step1.view.input;

import java.util.Scanner;

public class InputViewImpl implements InputView {
	public final Scanner scanner;

	public InputViewImpl(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getOperation() {
		return scanner.nextLine();
	}
}
