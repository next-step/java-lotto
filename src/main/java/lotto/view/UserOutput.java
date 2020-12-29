package lotto.view;

import java.math.BigDecimal;
import java.util.List;

import lotto.modal.Lotto;

public class UserOutput {

	private static final String NEXT_LINE = "\n";
	private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계" + NEXT_LINE + "---------";
	private static final String OUTPUT_BUY_MESSAGE = "개를 구매했습니다.";
	private static final String OUTPUT_YIELD_LOSE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	private static final String OUTPUT_YIELD_WIN_MESSAGE = "(기준이 1이기 떄문에 결과적으로 이익이라는 의미임)";

	public static void print(final String message) {
		System.out.print(message);
	}

	public static void printLine(final String message) {
		System.out.println(message);
	}

	public static void printLottoCount(int manualCount, int randomCount) {
		print(NEXT_LINE);
		print("수동으로 " + manualCount + "장, 자동으로 " + randomCount + OUTPUT_BUY_MESSAGE + NEXT_LINE);
	}

	public static void printLottos(List<Lotto> lottoPackage) {
		lottoPackage.forEach(lotto -> print(lotto.toString() + NEXT_LINE));
	}

	public static void printLottoResult(List<String> lottoRanks) {
		print(NEXT_LINE + OUTPUT_RESULT_MESSAGE + NEXT_LINE);
		lottoRanks.forEach(UserOutput::print);
	}

	public static void printLottoYield(BigDecimal yield) {
		String resultMsg = OUTPUT_YIELD_LOSE_MESSAGE;

		if (yield.intValue() > 1) {
			resultMsg = OUTPUT_YIELD_WIN_MESSAGE;
		}
		print("총 수익률은 " + yield + "입니다." + resultMsg + NEXT_LINE);
	}
}
