package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String PURCHASE_PRICE_PHRASES = "구입금액을 입력해 주세요.";
	private static final String LAST_WINNING_NUMBER_PHRASES = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_PHRASES = "보너스 볼을 입력해 주세요.";

	private InputView() {}

	public static int inputPrice() {
		System.out.println(PURCHASE_PRICE_PHRASES);
		return scanner.nextInt();
	}

	public static Lotto inputWinningNumbers() {
		scanner.nextLine();
		System.out.println(LAST_WINNING_NUMBER_PHRASES);
		String[] inputValue = scanner.nextLine().split(", ");

		return new Lotto(
				Arrays.stream(inputValue)
						.map(Integer::valueOf)
						.map(LottoNumber::new)
						.sorted()
						.collect(Collectors.toList())
		);
	}

	public static int inputBonusBall() {
		System.out.println(BONUS_NUMBER_PHRASES);
		return scanner.nextInt();
	}
}
