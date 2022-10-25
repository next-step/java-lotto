package step2.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import step2.exception.IllegalNumberException;

public class InputView {

	private static final String DELIMITER = ",";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int TOTAL_SIZE = 6;
	private static final List<Integer> winNumber = new ArrayList<>();
	private final Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askMoneyForLotto() {
		System.out.println("구입금액을 입력해주세요");
		return scanner.nextInt();
	}

	private String[] askWinNumber() {
		System.out.println("지난 주 당첨 번호를 입력하세요");
		return scanner.next().split(DELIMITER);

	}

	public int askBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요");
		return scanner.nextInt();

	}

	public List<Integer> winNumber() {
		for (String inputNumber : askWinNumber()) {
			isValid(Integer.parseInt(inputNumber));
			winNumber.add(Integer.parseInt(inputNumber));
		}

		if (winNumber.size() != TOTAL_SIZE) {
			throw new IllegalNumberException("6개의 숫자를 입력하세요");
		}

		return winNumber;
	}

	private void isValid(int inputNumber) {
		if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
			throw new IllegalNumberException("1~45안의 숫자를 골라주세요");
		}
	}

}
