package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;

public class ResultView {

	public static void printTicketCount(int ticketCount) {
		System.out.println(ticketCount + "개를 구매했습니다.");
	}

	public static void printLottoTickets(LottoTickets lottoTickets) {
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			System.out.println(lottoTicket.getTicketNumbers());
		}
	}

	public static void printWinningNumbers(WinningNumbers winningNumbers) {
		System.out.println(winningNumbers.getWinningNumbers());
	}

	public static void printResult(LottoResult lottoResult) {
		System.out.println("3개 일치 (5000원) - " + lottoResult.getFourthRankCount() +"개");
		System.out.println("4개 일치 (50000원) - " + lottoResult.getThirdRankCount() +"개");
		System.out.println("5개 일치 (1500000원) - " + lottoResult.getSecondRankCount() +"개");
		System.out.println("6개 일치 (2000000000원) - " + lottoResult.getFirstRankCount() +"개");
		System.out.printf("총 수익률은 %.2f입니다.", lottoResult.getEarningsRate());
	}
}
