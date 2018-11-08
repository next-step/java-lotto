package lotto.view;

import lotto.domain.LottoMatchingResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class ResultView {
	public static void printLottoTickets(List<LottoTicket> lottoNumberList) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%d개를 구매했습니다.\n", lottoNumberList.size()));
		for (LottoTicket lottoNumber : lottoNumberList) {
			sb.append(lottoNumber + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void printResult(LottoMatchingResult lottoMatchingResult) {
		StringBuilder sb = new StringBuilder();
		sb.append("당첨 통계\n");
		sb.append("---------\n");
		for (LottoWinnerType winnerType : LottoWinnerType.getWinnerList()) {
			Long matchingCount = lottoMatchingResult.getWinnerCountByWinnerType(winnerType);

			sb.append(String.format("%d개 일치", winnerType.getMatchCount()));
			if (winnerType.isBonusGame()) {
				sb.append(", 보너스 볼 일치");
			}
			sb.append(String.format("(%d 원) - %d개\n", winnerType.getReward(), matchingCount));

		}
		BigDecimal totalProfitRate = lottoMatchingResult.getProfitsRate();
		sb.append(String.format("총 수익률은 %s입니다.\n", totalProfitRate.toPlainString()));
		System.out.println(sb.toString());
	}
}
