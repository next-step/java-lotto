package lotto.ui;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.PrizeSituation;

public class ResultView {

	public static void printPurchasedCount(int purchaseCount) {
		System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
	}

	public static void printCurrentSituation(PurchasedLottos purchasedLottos) {
		for (Lotto lotto : purchasedLottos.getLottos()) {
			System.out.println(lotto.getLottoNumbers());
		}
	}

	public static void printPrizeSituations(List<PrizeSituation> prizeSituations) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (PrizeSituation prizeSituation : prizeSituations) {
			int score = prizeSituation.getPrizeType().score.getScore();
			long prizeMoney = prizeSituation.getPrizeType().prizeMoney.getPrizeMoney();
			int prizeCount = prizeSituation.getPrizeCount();
			System.out.printf("%d개 일치 (%d원)- %d개%n", score, prizeMoney, prizeCount);
		}
	}

	public static void printTotalProfitRate(double totalProfitRate, boolean benefit) {
		System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n", totalProfitRate, benefit ? "이익이" : "손해");
	}
}
