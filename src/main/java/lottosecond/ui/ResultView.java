package lottosecond.ui;

import lottosecond.domain.*;

import java.util.Map;

public class ResultView {

	private static final String TICKET_RESULT = "개를 구매했습니다.";
	private static final String MATCH_RESULT = "\n당첨 통계";
	private static final String DIVISION_LINE = "--------";
	private static final String MATCH_FOR_EACH_MESSAGE = "%d개 일치 (%d원) - %d개%n";
	private static final String MATCH_FOR_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개%n";
	private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

	public static void printLottos(Lottos lottos) {
		System.out.printf("%d%s%n", lottos.size(), TICKET_RESULT);
		for (Lotto lotto : lottos.toList()) {
			System.out.println(lotto);
		}
		System.out.println();
	}

	public static void printResult(Lottos lottos, String winningNumbers, int bonusNumber) {
		System.out.println(MATCH_RESULT);
		System.out.println(DIVISION_LINE);

		LottoResult lottoResult = new LottoResult(lottos);
		lottoResult.match(winningNumbers, bonusNumber);

		printResultEach(lottoResult.value());
		printResultRate(lottoResult);
	}

	private static void printResultRate(LottoResult lottoResult) {
		double rate = lottoResult.rate();
		System.out.printf(PROFIT_RATE_MESSAGE, String.format("%.2f", rate));
	}

	private static void printResultEach(Map<LottoProfit, Integer> match) {
		for (Map.Entry<LottoProfit, Integer> profit : match.entrySet()) {
			printNotZero(profit);
		}
	}

	private static void printNotZero(Map.Entry<LottoProfit, Integer> profit) {
		if (profit.getKey() != LottoProfit.ZERO) {
			System.out.printf(messageTemplate(profit), profit.getKey().getQuantity(), profit.getKey().getProfitUnit(), profit.getValue());
		}
	}

	private static String messageTemplate(Map.Entry<LottoProfit, Integer> profit) {
		if (profit.getKey().equals(LottoProfit.FIVE_BONUS)) {
			return MATCH_FOR_BONUS_MESSAGE;
		}
		return MATCH_FOR_EACH_MESSAGE;
	}

}
