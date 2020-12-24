package lotto.view;

import java.math.BigDecimal;
import java.util.List;

import lotto.modal.Lotto;

public class UserOutput {

	private static final String NEXT_LINE_FLAG = "\n";
	private static final String PRINT_LOTTO_RANK_RESULT = "당첨 통계" + NEXT_LINE_FLAG + "---------";
	private static final String PRINT_LOTTO_USER_BUY_NUMBER = "개를 구매했습니다.";
	private static final String PRINT_LOTTO_WINNER_NUMBER = "지난 주 담청 번호를 입력해 주세요.";
	private static final String PRINT_LOTTO_RESULT_FAIL = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	private static final String PRINT_LOTTO_RESULT_SUCCESS = "(기준이 1이기 떄문에 결과적으로 이익이라는 의미임)";
	private static final String PRINT_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

	private static final String PRINT_LOTTO_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

	public static void print(final String message) {
		System.out.print(message);
	}

	public static void printLine(final String message) {
		System.out.println(message);
	}

	public static void printUserErrorMsg(String msg) {
		print(msg + NEXT_LINE_FLAG);
	}

	public static void printLottoCount(int manualCount, int randomCount) {
		print("수동으로 " + manualCount + "장, 자동으로 " + randomCount + PRINT_LOTTO_USER_BUY_NUMBER + NEXT_LINE_FLAG);
	}

	public static void printUserInputBonusNumber() {
		print(PRINT_LOTTO_BONUS_NUMBER + NEXT_LINE_FLAG);
	}

	public static void printUserInputWinnerLotto() {
		print(NEXT_LINE_FLAG + PRINT_LOTTO_WINNER_NUMBER + NEXT_LINE_FLAG);
	}

	public static void printUserInputManualLotto() {
		print(PRINT_LOTTO_MANUAL_NUMBER + NEXT_LINE_FLAG);
	}

	public static void printLottoPackage(List<Lotto> lottoPackage) {
		lottoPackage.forEach(lotto -> print(lotto.toString() + NEXT_LINE_FLAG));
	}

	public static void printLottoRankResult(List<String> lottoRanks) {
		print(NEXT_LINE_FLAG + PRINT_LOTTO_RANK_RESULT + NEXT_LINE_FLAG);
		lottoRanks.forEach(UserOutput::print);
	}

	public static void printLottoYield(BigDecimal yield) {
		String resultMsg = PRINT_LOTTO_RESULT_FAIL;

		if (yield.intValue() > 1) {
			resultMsg = PRINT_LOTTO_RESULT_SUCCESS;
		}
		print("총 수익률은 " + yield + "입니다." + resultMsg + NEXT_LINE_FLAG);
	}
}
