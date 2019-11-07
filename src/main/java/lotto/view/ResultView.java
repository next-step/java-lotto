package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoDtoCollection;
import lotto.dto.LottoPrizeStat;

public class ResultView {

	public static void printBuyingLotteries(LottoDtoCollection collection) {
		System.out.println();
		System.out.println(String.format("수동으로 %s개 자동으로 %s개를 구매했습니다.", collection.selfLottoCount(),
				collection.autoLottoCount()));

		for(LottoDto dto : collection.getAutoLottoDtos()) {
			System.out.println(dto.printLottoNumbers());
		}
		System.out.println();
	}

	public static void printWinStats(LottoPrizeStat stat, double earningsRatio) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(stat);
		System.out.println(String.format("총 수익률은 %.2f입니다.", earningsRatio));
	}

}
