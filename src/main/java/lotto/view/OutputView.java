package lotto.view;

import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.ProfitOrLoss;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.Roi;

public class OutputView {

	private static final String ENTER = "\n";

	private OutputView() {}

	public static void printPurchaseLottoGroup(PurchaseLottoGroup purchaseLottoGroup) {
		System.out.println(purchaseLottoGroup.values().stream()
			.map(Lotto::toString)
			.collect(Collectors.joining("\n")));
	}

	public static void printPurchaseQuantity(long quantity) {
		System.out.println(quantity + "개를 구매했습니다.");
	}

	public static void printWinningStatistics(RankingResult rankingResult) {
		StringBuffer printBuffer = new StringBuffer();

		printBuffer.append("당첨 통계").append(ENTER);
		printBuffer.append("---------").append(ENTER);
		printBuffer.append(rankingResult.ranking().keySet().stream()
			.filter(LottoRank::isStatistics)
			.map(rank -> String.format("%d개 일치 %s (%d원) - %d개", rank.sameQuantity(), checkBonus(rank.checkBonus()), rank.amount(), rankingResult.ranking().get(rank)))
			.collect(Collectors.joining(ENTER)));

		System.out.println(printBuffer);
	}

	public static void printYield(Roi roi) {
		System.out.printf("총 수익률은 %s 입니다. => (%s)", roi.crop(2), ProfitOrLoss.findByYield(roi).title());
	}

	private static String checkBonus(boolean checkBonus) {
		if (checkBonus) {
			return ", 보너스볼 일치";
		}
		return "";
	}
}
