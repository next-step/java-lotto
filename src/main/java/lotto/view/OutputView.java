package lotto.view;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.RewardType;

public class OutputView {

	public static void printNumberOfPurchasedTickets(LottoTickets lottoTickets) {
		System.out.println(lottoTickets.numberOfLottoTickets() + "개를 구매했습니다.");
		lottoTickets.getLottoTickets()
			.forEach(ticket -> System.out.println(ticket.toString()));
	}

	public static void printResult(LottoResult lottoResult, LottoTickets lottoTickets) {
		System.out.println("당첨통계");
		System.out.println("--------");
		System.out.printf(
			"3개 일치(5000원) - %d개 " + System.lineSeparator(), lottoResult.countTicketsByRewardType(RewardType.THIRD));
		System.out.printf(
			"4개 일치(50000원) - %d개 \n", lottoResult.countTicketsByRewardType(RewardType.FOURTH));
		System.out.printf(
			"5개 일치(1500000원) - %d개 \n", lottoResult.countTicketsByRewardType(RewardType.FIFTH));
		System.out.printf(
			"5개 일치, 보너스 볼 일치(30000000원) - %d개 \n", lottoResult.countTicketsByRewardType(RewardType.FIFTH_BONUS));
		System.out.printf("6개 일치(2000000000원) - %d개 \n",
			lottoResult.countTicketsByRewardType(RewardType.SIXTH));
		System.out.println("총 수익률은 " + getRateOfProfit(lottoResult, lottoTickets) + "입니다.");
		System.out.println("기준이 1이기 때문에 1 미만인 경우에는 결과적으로 손해라는 의미입니다.");
	}

	private static double getRateOfProfit(LottoResult lottoResult, LottoTickets lottoTickets) {
		return lottoResult.getLottoProfitRate(lottoTickets.numberOfLottoTickets());
	}
}
