package lotto.view;

import lotto.domain.ProfitOrLoss;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.Yield;

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
		System.out.println(rankingResult.toString());
	}

	public static void printYield(Yield yield) {
		System.out.printf("총 수익률은 %f 입니다. (%s) => %n", yield.crop(2), ProfitOrLoss.findByYield(yield).title());
	}
}
