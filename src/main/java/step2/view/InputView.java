package step2.view;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import step2.exception.IllegalNumberException;
import step2.model.LottoNumbers;

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

	public int askForHand() {
		System.out.println("수동으로 구매할 로또 수를 입력해주세요");
		return scanner.nextInt();
	}

	public void askHandNumber() {
		System.out.println("수동으로 구매할 로또 번호를 입력해주세요");
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
			isRangeValid(parseInt(inputNumber));
			winNumber.add(parseInt(inputNumber));
		}

		isCountValid(winNumber.size());
		return winNumber;
	}

	private List<Integer> handNumber() {
		List<Integer> handNumber = new ArrayList<>();
		for (String inputNumber : scanner.next().split(DELIMITER)) {
			isRangeValid(parseInt(inputNumber));
			handNumber.add(parseInt(inputNumber));
		}
		isCountValid(handNumber.size());

		return handNumber;
	}

	public List<LottoNumbers> handNumbers(int handTicket) {
		List<LottoNumbers> handNumbers = new ArrayList<>();
		for (int i = 0; i < handTicket; i++) {
			handNumbers.add(
				LottoNumbers.handNumbers(handNumber()));
		}
		return handNumbers;
	}

	private void isRangeValid(int inputNumber) {
		if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
			throw new IllegalNumberException("1~45안의 숫자를 골라주세요");
		}
	}

	private void isCountValid(int inputSize) {
		if (inputSize != TOTAL_SIZE) {
			throw new IllegalNumberException("6개의 숫자를 입력하세요");
		}
	}

}
