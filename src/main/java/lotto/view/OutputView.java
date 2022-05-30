package lotto.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.ProfitOrLoss;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.Roi;

public class OutputView {

	private static final String ENTER = "\n";
	private static final String LOTTO_OPEN = "[";
	private static final String LOTTO_CLOSE = "]";

	private OutputView() {}

	public static void printPurchaseLottoGroup(PurchaseLottoGroup purchaseLottoGroup) {
		StringBuilder builder = new StringBuilder();

		purchaseLottoGroup.values()
			.forEach(lotto -> builder
				.append(LOTTO_OPEN)
				.append(lotto.values()
					.stream()
					.map(LottoNumber::value)
					.collect(Collectors.joining(", ")))
				.append(LOTTO_CLOSE)
				.append(ENTER));

		System.out.println(builder);
	}

	public static void printPurchaseQuantity(long manualQuantity, long autoQuantity) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualQuantity, autoQuantity));
	}

	public static void printWinningStatistics(RankingResult rankingResult) {
		StringBuilder builder = new StringBuilder();

		builder.append("당첨 통계").append(ENTER);
		builder.append("---------").append(ENTER);

		Arrays.stream(LottoRank.values())
			.filter(LottoRank::isStatistics)
			.forEach(rank -> builder
				.append(String.format("%d개 일치%s (%d원) - %d개", rank.sameQuantity(), isSecond(rank), rank.amount(), rankingResult.matchQuantity(rank)))
				.append(ENTER));

		System.out.println(builder);
	}

	public static void printYield(Roi roi) {
		System.out.printf("총 수익률은 %s 입니다. => (%s)", roi.crop(2), ProfitOrLoss.findByYield(roi).title());
	}

	private static String isSecond(LottoRank lottoRank) {
		if (lottoRank == LottoRank.SECOND) {
			return ", 보너스볼 일치";
		}
		return "";
	}
}
