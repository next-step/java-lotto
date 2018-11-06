package lotto.view;

import static java.util.Arrays.asList;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningResult;
import lotto.enums.Prize;

public class ResultView {

	public static void printBuyingLottos(LottoTicket lottoTicket) {
		for(Lotto lotto : lottoTicket.getLottos()) {
			System.out.println(lotto.toString());
		}
		System.out.println();
	}

	public static void printResult(WinningResult winningResult) {
		header();
		prizeCount(winningResult);
		profitRate(winningResult);
	}

	private static void header() {
		System.out.println("당첨 통계\n---------");
	}

	private static void prizeCount(WinningResult winningResult) {
		for(Prize prize : getPrintPrizes()) {
			System.out.println(String.format("%d개 일치 (%d원) - %d개",
					prize.getMatchCount(), prize.getMoney(), winningResult.getPrizeCount(prize)));
		}
	}

	private static List<Prize> getPrintPrizes() {
		return asList(Prize.MATCH3, Prize.MATCH4, Prize.MATCH5, Prize.MATCH6);
	}

	private static void profitRate(WinningResult winningResult) {
		System.out.println(String.format("총 수익률은 %.2f입니다.", winningResult.getProfitRate()));
	}

}
