package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

	private static final String INPUT_PURCHASE_LOTTO_PRICE_MESSAGE = "구입금액을 입력해 주세요";
	private static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

	private static Scanner input = new Scanner(System.in);

	private LottoInputView() {

	}

	public static int inputPurchaseLottoPrice() {
		System.out.println(INPUT_PURCHASE_LOTTO_PRICE_MESSAGE);
		return input.nextInt();
	}

	public static String inputWinningLotto() {
		System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE);
		input = new Scanner(System.in);
		return input.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_LOTTO_NUMBER_MESSAGE);
		return input.nextInt();
	}

	public static int inputManualLottoCount() {
		System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
		return input.nextInt();
	}

	public static List<String> inputManualLottoNumber(int manualLottoCount) {
		input = new Scanner(System.in);
		if (manualLottoCount == 0) {
			return Collections.EMPTY_LIST;
		}
		List<String> manualLottoNumbers = new ArrayList<>();
		System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
		for (int count = 0; count < manualLottoCount; count++) {
			manualLottoNumbers.add(input.nextLine());
		}
		return manualLottoNumbers;
	}

}
