package ui;

import generate.PlusCalculate;
import util.ConsoleMessage;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out; //와! println은 정적필드의 인스턴스 멤버메소드라 static import불가


public class CalculatorController {
	private final Scanner scanner = new Scanner(System.in);
	private final PlusCalculate plusCalculate = new PlusCalculate();

	public void waitForInput(){
		while (true) {
			out.println(ConsoleMessage.WAITING_INPUT_MESSAGE);
			out.println(ConsoleMessage.WAITING_INPUT_COSTOM_SPLIT);
			out.print(ConsoleMessage.WAITING_INPUT);

			String input = scanner.nextLine().trim();

			checkInput(input);

			out.println(plusCalculate.excute(input));
		}
	}

	private Boolean checkInput(String inputs) {
		return null;
	}
}
