package lotto.view;

import java.util.stream.Collectors;

import lotto.domain.LottoRank;
import lotto.domain.ProfitOrLoss;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.Roi;

public class OutputView {

	private OutputView() {}

	public static void printPurchaseLottoGroup(PurchaseLottoGroup purchaseLottoGroup) {
		System.out.println(purchaseLottoGroup);
	}

	public static void printPurchaseQuantity(long quantity) {
		System.out.println(quantity + "개를 구매했습니다.");
	}

	public static void printWinningStatistics(RankingResult rankingResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(rankingResult.ranking().keySet().stream()
			.filter(LottoRank::isStatistics)
			.map(rank -> String.format("%d개 일치 (%d원) - %d개", rank.sameQuantity(), rank.amount(), rankingResult.ranking().get(rank)))
			.collect(Collectors.joining("\n")));
	}

	public static void printYield(Roi roi) {
		System.out.printf("총 수익률은 %s 입니다. => (%s)", roi.crop(2), ProfitOrLoss.findByYield(roi).title());
	}
}
