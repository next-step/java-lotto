package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.enums.Prize;

public class ResultView {

	public static void printBuyingLottos(LottoTicket manualPickLottoTicket, LottoTicket quickPickLottoTicket) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
				manualPickLottoTicket.getLottos().size(), quickPickLottoTicket.getLottos().size()));
		printLottos(manualPickLottoTicket);
		printLottos(quickPickLottoTicket);
		System.out.println();
	}

	private static void printLottos(LottoTicket lottoTicket) {
		for(Lotto lotto : lottoTicket.getLottos()) {
			System.out.println(lotto.toString());
		}
	}

	public static void printResult(Money money, WinningResult winningResult) {
		header();
		prizeCount(winningResult);
		profitRate(money.calculateProfitRate(winningResult.getTotalPrizeMoney()));
	}

	private static void header() {
		System.out.println("당첨 통계\n---------");
	}

	private static void prizeCount(WinningResult winningResult) {
		for(Prize prize : Prize.values()) {
			if(prize.equals(Prize.NO_MATCH)) {
				continue;
			}

			String output = "%d개 일치 (%d원) - %d개";
			if(prize.equals(Prize.SECOND)) {
				output = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
			}
			System.out.println(String.format(output,
					prize.getMatchCount(), prize.getMoney(), winningResult.getPrizeCount(prize)));
		}
	}

	private static void profitRate(double profitRate) {
		System.out.println(String.format("총 수익률은 %.2f입니다.", profitRate));
	}
}
