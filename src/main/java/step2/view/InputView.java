package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private final Scanner scanner;
	private final List<Integer> winNum = new ArrayList<>();

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askMoneyForLotto() {
		System.out.println("로또 장수를 입력하세요");
		return scanner.nextInt();
	}

	public String[] askWinnerNum() {
		System.out.println("우승 번호를 입력하세요");
		return scanner.next().split(",");

	}

	public List<Integer> winnerNumList() {
		for (String num : askWinnerNum()) {
			winNum.add(Integer.parseInt(num));
		}

		return winNum;
	}
}
