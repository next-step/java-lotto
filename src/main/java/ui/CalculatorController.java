package ui;

import domain.Number;
import generate.PlusCalculate;
import generate.Separator;
import util.ConsoleMessage;
import util.ExceptionMessage;
import util.InputValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out; //와! println은 정적필드의 인스턴스 멤버메소드라 static import불가


public class CalculatorController {
	private final Scanner scanner = new Scanner(System.in);
	private final PlusCalculate plusCalculate = new PlusCalculate();

	public void waitForInput(){
		while (true) {
			out.println(ConsoleMessage.WAITING_INPUT_MESSAGE);
			out.println(ConsoleMessage.WAITING_INPUT_COSTOM_SPLIT);
			out.print(ConsoleMessage.WAITING_INPUT);

			final String input = scanner.nextLine().trim();

			if (validateInput(input)) {
				out.println(singleNumber(input));
				continue;
			}
			out.println(plusCalculate.excute(splitNumbers(input)));
		}
	}

	public Boolean validateInput(String input) {
		if (InputValidation.checkNullAndEmpty(input) || InputValidation.checkSingle(input)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Integer singleNumber(String input) {
		if (InputValidation.checkNullAndEmpty(input)) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private List<Integer> splitNumbers(String input){
		List<Integer> numberList = new ArrayList<>();

		for (String number : Separator.split(input)) {
			numberList.add(splitNumber(number));
		}

		return numberList;
	}

	public Integer splitNumber(String input) {
		final Integer intNumber;
		try {
			intNumber = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
		}

		if (intNumber < 0) {
			throw new NumberFormatException(ExceptionMessage.NUMBER_MINUS_EXCEPTION);
		}
		return intNumber;
	}
}
