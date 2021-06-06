package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
	public static final String INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_BUY_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String INPUT_BUY_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

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
	public List<List<Integer>> askManual() {
		System.out.println(INPUT_BUY_MANUAL_COUNT);
		int manualCount = sc.nextInt();
		sc.nextLine();

		if (manualCount > 0) {
			return askManualNumbers(manualCount);
		}
		return new ArrayList<>();
	}

	private List<List<Integer>> askManualNumbers(int count) {
		System.out.println(INPUT_BUY_MANUAL_NUMBERS);
		return IntStream.range(0, count)
			.mapToObj(i -> sc.nextLine())
			.map(line -> line.split(DELIMITER))
			.map(this::createNumbers)
			.collect(Collectors.toList());
	}

	private List<Integer> createNumbers(String[] numberArray) {
		List<Integer> numbers = new ArrayList<>();
		for (String e : numberArray) {
			numbers.add(Integer.parseInt(e.trim()));
		}
		return numbers;
	}
}
