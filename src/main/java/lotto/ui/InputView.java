package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static final String INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_WIN_BONUS = "보너스 볼을 입력해 주세요.";
	public static final String DELIMITER = ",";

	private Scanner sc = new Scanner(System.in);

	public long askAmount() {
		System.out.println(INPUT_BUY_AMOUNT);
		long amount = sc.nextLong();
		sc.nextLine();
		return amount;
	}

	public List<Integer> askPrizeNumbers() {
		System.out.println(INPUT_WIN_NUMBERS);
		String line = sc.nextLine();
		String[] splits = line.split(DELIMITER);
		List<Integer> numbers = new ArrayList<>();
		for (String e : splits) {
			numbers.add(Integer.parseInt(e.trim()));
		}
		return numbers;
	}

	public int askBonusNumber() {
		System.out.println(INPUT_WIN_BONUS);
		int bonus = sc.nextInt();
		sc.nextLine();
		return bonus;
	}
}
