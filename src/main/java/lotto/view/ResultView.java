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
	public static void printLottoTickets(List<LottoTicket> lottoTicketList) {
		System.out.println(String.format("%d개를 구매했습니다.", lottoTicketList.size()));
		for (LottoTicket lottoTicket : lottoTicketList) {
			System.out.println(lottoTicket);
		}
	}

	public static void printResult(LottoMatchingResult lottoMatchingResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (LottoWinnerType winnerType : LottoWinnerType.getWinnerList()) {
			Long matchingCount = lottoMatchingResult.getWinnerCountByWinnerType(winnerType);
			System.out.println(String.format("%d개 일치 (%d 원) - %d개",
				winnerType.getMatchNumberCount(), winnerType.getReward(), matchingCount));
		}
		BigDecimal totalProfitRate = lottoMatchingResult.getProfitsRate();
		System.out.println(String.format("총 수익률은 %s입니다.", totalProfitRate.toPlainString()));
	}
}
