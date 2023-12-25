package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void printPriceInput() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static int inputInt() {
		return Integer.parseInt(validate(SCANNER.nextLine()));
	}

	public static String inputText() {
		return validate(SCANNER.nextLine());
	}

	private static String validate(String text) {
		if (text == null || text.isBlank()) {
			throw new InputMismatchException("입력해 주세요.");
		}

		return text;
	}

	public static int printPrice(int price){
		int number = price / 1000;
		System.out.printf("%d개를 구매했습니다.\n", number);

		return number;
	}

	public static void printWinningNumber(){
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
	}

	public static int[] winningNumbers(String text){
		String[] numbers = text.split(",");
    	int[] winningNumbers = new int[numbers.length];
    	for (int i = 0; i < numbers.length; i++) {
    		winningNumbers[i] = Integer.parseInt(numbers[i].trim());
    	}
    	return winningNumbers;
	}
}
