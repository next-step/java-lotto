package lotto.view;

import lotto.modal.Count;
import lotto.modal.LottoResult;
import lotto.modal.Lottos;
import lotto.modal.Money;

public class UserView {
	private static final String NEXT_LINE = "\n";
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String INPUT_WINNER_MESSAGE = "지난 주 담청 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";

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

	public static void printInputLottos() {
		UserOutput.printLine(INPUT_LOTTO_MESSAGE);
	}

	public static String getLotto() {
		return UserInput.getString();
	}

	public static String getWinnerLotto() {
		UserOutput.printLine(NEXT_LINE + INPUT_WINNER_MESSAGE);
		return UserInput.getString();
	}

	public static int getBonusNumber() {
		UserOutput.printLine(INPUT_BONUS_MESSAGE);
		return UserInput.getNumber();
	}

	public static void printLottos(Lottos lottos, Count count) {
		UserOutput.printLottoCount(count.manualCount(), count.randomCount());
		UserOutput.printLottos(lottos.getLottos());
	}

	public static void printResult(LottoResult result, Money money) {
		UserOutput.printLottoResult(result.reportRank());
		UserOutput.printLottoYield(result.reportYield(money));
	}

	public static void printError(String message) {
		UserOutput.printLine(message);
	}
}
