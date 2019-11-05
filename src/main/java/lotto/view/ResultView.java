package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoPrizeStat;

import java.util.List;

public class ResultView {

	public static void printBuyingLotteries(List<LottoDto> lottoDtos) {
		System.out.println(String.format("%s개를 구매했습니다.", lottoDtos.size()));
		for(LottoDto dto : lottoDtos) {
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
