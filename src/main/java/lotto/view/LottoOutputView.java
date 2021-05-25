package lotto.view;

import java.util.Arrays;

import lotto.domain.LottoRank;
import lotto.domain.LottoRankCount;
import lotto.domain.Lottos;

public class LottoOutputView {

	private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String WINNING_STATISTICS = "당첨 통계";
	private static final String LINE = "---------";
	private static final String MATCHES_RESULT_MESSAGE = "%d개 일치 %s(%d원)- %d개\n";
	private static final String YIELD_MESSAGE = "총 수익률은 %f 입니다.\n";
	private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
	private static final String NOT_BONUS_BALL_MESSAGE = "";

	private LottoOutputView() {

	}

	public static void printLottos(Lottos lottos) {
		System.out.println(lottos.toString());
	}

	public static void printPurchaseLottoCount(int lottoCount) {
		System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, lottoCount);
	}

	public static void printWinningStatistics(LottoRankCount lottoRankCount) {
		System.out.println(WINNING_STATISTICS);
		System.out.println(LINE);
		Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank != LottoRank.UNRANKED)
			.forEach(lottoRank -> {
				System.out.printf(MATCHES_RESULT_MESSAGE, lottoRank.getMatches(),
					getBonusBallMessage(lottoRank.hasBonusBall()),
					lottoRank.getReward(),
					lottoRankCount.getCount(lottoRank));
			});
	}

	public static void printYield(double yield) {
		System.out.printf(YIELD_MESSAGE, yield);
	}

	private static String getBonusBallMessage(boolean hasBonusBall) {
		if (hasBonusBall) {
			return BONUS_BALL_MESSAGE;
		}
		return NOT_BONUS_BALL_MESSAGE;
	}

}
