package step4.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String PURCHASE_PRICE_PHRASES = "구입금액을 입력해 주세요.";
	private static final String MANUAL_LOTTO_COUNT_PHRASES = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MANUAL_LOTTO_NUMBERS_PHRASES = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String LAST_WINNING_NUMBER_PHRASES = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_PHRASES = "보너스 볼을 입력해 주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {}

	public static int inputPrice() {
		System.out.println(PURCHASE_PRICE_PHRASES);
		return scanner.nextInt();
	}

	public static List<Integer> inputWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBER_PHRASES);
		return Arrays.stream(scanner.nextLine().split(", "))
				.map(Integer::valueOf)
				.sorted()
				.collect(Collectors.toList());
	}

	public static int inputBonusBall() {
		System.out.println(BONUS_NUMBER_PHRASES);
		return scanner.nextInt();
	}

	public static int inputManualLottoCount() {
		System.out.println(MANUAL_LOTTO_COUNT_PHRASES);
		return scanner.nextInt();
	}

	public static String[] inputManualLottos(int manualLottoCount) {
		scanner.nextLine();

		if(manualLottoCount == 0) {
			return new String[0];
		}

		System.out.println(MANUAL_LOTTO_NUMBERS_PHRASES);
		String[] manuals = new String[manualLottoCount];
		for (int i = 0; i < manualLottoCount; i++) {
			manuals[i] = scanner.nextLine();
		}
		return manuals;
	}

}
