package lotto.view.in;

import java.util.Scanner;

public class ConsoleDialog implements InputDialog {

	@Override
	public String execute(String message) {

		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
