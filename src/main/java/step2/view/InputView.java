package step2.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import step2.exception.IllegalNumberException;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askMoneyForLotto() {
		System.out.println("구입금액을 입력해주세요");
		return scanner.nextInt();
	}

	private String[] askWinnerNum() {
		System.out.println("지난 주 당첨 번호를 입력하세요");
		return scanner.next().split(",");

	}

	public List<Integer> winnerNumList() {
		List<Integer> winNumList = new ArrayList<>();

		for (String num : askWinnerNum()) {
			isValid(Integer.parseInt(num));
			winNumList.add(Integer.parseInt(num));
		}

		if (winNumList.size() != 6) {
			throw new IllegalNumberException("6개의 숫자를 입력하세요");
		}

		return winNumList;
	}

	private void isValid(int num) {

		if (1 >= num || num >= 45) {
			throw new IllegalNumberException("1~45안의 숫자를 골라주세요");
		}

	}

}
