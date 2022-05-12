package lotto.view;

import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;

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
		System.out.println("총 수익률은 " + String.format("%.2f", rankingResult.yield()) + "입니다.");
	}
}
