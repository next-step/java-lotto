package lotto.view.in;

import java.util.Scanner;

public class ConsoleReader implements InputReader {

	Scanner scanner;

	public ConsoleReader(){
		scanner = new Scanner(System.in);
	}

	@Override
	public String read() {
		return scanner.nextLine();
	}
}
