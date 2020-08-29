package step4.view;

import step4.domain.Lotto;
import step4.domain.LottoNumber;

import java.util.ArrayList;
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

	public static List<LottoNumber> inputWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBER_PHRASES);
		return inputLottoNumbers();
	}

	public static int inputBonusBall() {
		System.out.println(BONUS_NUMBER_PHRASES);
		return scanner.nextInt();
	}

	public static int inputManualLottoCount() {
		System.out.println(MANUAL_LOTTO_COUNT_PHRASES);
		return scanner.nextInt();
	}

	public static List<Lotto> inputManualLottos(int manualLottoCount) {
		List<Lotto> manualLottos = new ArrayList<>();
		System.out.println(MANUAL_LOTTO_NUMBERS_PHRASES);

		scanner.nextLine();
		for (int i = 0; i < manualLottoCount; i++) {
			manualLottos.add(new Lotto(inputLottoNumbers(), true));
		}
		return manualLottos;
	}

	private static List<LottoNumber> inputLottoNumbers() {
		String[] inputNumbers = scanner.nextLine().split(", ");
		return Arrays.stream(inputNumbers)
				.map(Integer::valueOf)
				.map(LottoNumber::new)
				.sorted()
				.collect(Collectors.toList());
	}
}
