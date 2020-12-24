package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lotto.modal.Lotto;
import lotto.modal.LottoNumber;
import lotto.modal.Money;
import lotto.modal.WinnerLotto;

public class UserView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";

	private UserView() {
		throw new AssertionError();
	}

	public static int getMoney() {
		UserOutput.printLine(INPUT_MONEY_MESSAGE);
		return UserInput.getNumber();
	}

	public static int getCount() {
		UserOutput.printLine(INPUT_COUNT_MESSAGE);
		return UserInput.getNumber();
	}

	public static String inputManualCount() {
		UserOutput.printManualLottoCount();
		return userInputString();
	}

	public static String inputGameMoney() {
		UserOutput.getMoney();
		return userInputString();
	}

	public static WinnerLotto inputWinnerLotto() {
		UserOutput.printUserInputWinnerLotto();
		Lotto winnerLotto = Lotto.generateLotto(userInputString());

		UserOutput.printUserInputBonusNumber();
		LottoNumber bonusNumber = new LottoNumber(userInputString());

		return new WinnerLotto(winnerLotto, bonusNumber);
	}

	public static void printLottoPackage(Money condition, List<Lotto> lottoPackage) {
		UserOutput.printLottoCount(condition.getCount(), condition.getRandomCount());
		UserOutput.printLottoPackage(lottoPackage);
	}

	public static void printLottoResultRank(List<String> lottoRanks) {
		UserOutput.printLottoRankResult(lottoRanks);
	}

	public static void printLottoResultYield(BigDecimal yield) {
		UserOutput.printLottoYield(yield);
	}

	public static void printErrorMsg(String message) {
		UserOutput.printUserErrorMsg(message);
	}

	public static List<Lotto> inputManualLotto(int repeatNumber) {
		List<Lotto> manualLotto = new ArrayList<>();
		if (repeatNumber != 0) {
			UserOutput.printUserInputManualLotto();
		}
		for (int i = 0; i < repeatNumber; i++) {
			manualLotto.add(Lotto.generateLotto(userInputString()));
		}
		return manualLotto;
	}

	private static String userInputString() {
		return UserInput.getString();
	}

}
