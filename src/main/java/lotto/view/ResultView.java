package lotto.view;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.LottoTickets;
import lotto.domain.Prize;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningStatistics;

/**
 * @author : byungkyu
 * @date : 2020/12/15
 * @description :
 **/
public class ResultView {
	private static final BigDecimal ONE = new BigDecimal(1);

	public static void printWinningStatistics(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		winningStatistics.getPrizeResult().entrySet().stream().forEach(prize -> printWinningOne(prize));
		printWinningAverage(winningStatistics.getWinningSummary());
	}

	private static void printWinningAverage(BigDecimal winningSummary) {
		StringBuilder sb = new StringBuilder("총 수익률은 " + winningSummary + "입니다.");
		if (winningSummary.compareTo(ONE) < 0) {
			sb.append("(기준이 1이기 때문에 결과적으로는 손해라는 의미임)");
		}
		System.out.println(sb);
	}

	private static void printWinningOne(Map.Entry<Prize, Integer> prize) {
		if (prize.getKey() == Prize.NONE)
			return;
		Prize prizeKey = prize.getKey();
		System.out.println(
			prizeKey.getMatchCount() + "개 일치 (" + prizeKey.getReward() + "원)- " + prize.getValue() + "개");
	}
}
