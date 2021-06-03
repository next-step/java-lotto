package lotto;

public class ResultView {
	public static final String LOTTO_PURCHASE_OUTPUT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	public static final String LOTTO_RESULT = "당첨 통계 \n ---------";
	public static final String TOTAL_REVENUE = "총 수익률은 %.2f입니다.";

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static void print(String msg, int num1, int num2) {
		System.out.println(String.format(msg, num1, num2));
	}

	public static void print(String msg, float num) {
		System.out.println(String.format(msg, num));
	}

	public static void print(String msg, long num1, int num2, long num3) {
		System.out.println(String.format(msg, num1, num2, num3));
	}

	public static void printResult(LottoMatchResult lottoMatchResult) {
		ResultView.print(ResultView.LOTTO_RESULT);
		lottoMatchResult.getResult().forEach((lottoPrize, count) ->
			ResultView.print(matchingCountMessage(lottoPrize), lottoPrize.getMatchCount(), lottoPrize.getWinningAmount(), count));
		ResultView.print(ResultView.TOTAL_REVENUE, lottoMatchResult.getProfit());
	}

	public static void printPurchaseResult(Lottos auto, Lottos manual) {
		ResultView.print(ResultView.LOTTO_PURCHASE_OUTPUT, auto.lottoCount(), manual.lottoCount());
		ResultView.print(auto.toString());
		ResultView.print(manual.toString());
	}

	private static String matchingCountMessage(LottoPrize lottoPrize) {
		String msg = "%d개 일치";
		if(lottoPrize.isSecond()) {
			msg += ", 보너스 볼 일치";
		}
		msg += " (%d원) - %d개";
		return msg;
	}
}
