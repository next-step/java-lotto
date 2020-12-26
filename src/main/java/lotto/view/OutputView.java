package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.Message;

public class OutputView {

	public static void printLottoLotteries(LottoLotteries lottoLotteries) {
		printLottoCount(lottoLotteries.getCount());
		printLottoLotteries(lottoLotteries.getLottoLotteries());
		System.out.println();
	}

	private static void printLottoCount(int count) {
		System.out.printf(Message.PRINT_NUMBER_OF_LOTTO_PURCHASED, count);
	}

	private static void printLottoLotteries(List<LottoLottery> lottoLotteries) {
		for (LottoLottery lottoLottery : lottoLotteries) {
			System.out.println(lottoLottery.getLottoNumbers());
		}
	}

	public static void printLottoResults(LottoResults lottoResults) {
		printLottoResultsStats(lottoResults);
		printReturnRate(lottoResults);
	}

	private static void printLottoResultsStats(LottoResults lottoResults) {
		System.out.println("\n당첨 통계");
		System.out.println("---------");
		Arrays.stream(LottoRank.values())
			.sorted(Comparator.comparingInt(LottoRank::getPrize))
			.filter(LottoRank::isNotNone)
			.forEach(lottoRank -> printLottoResult(lottoResults.findLottoResult(lottoRank)));
	}

	private static void printLottoResult(LottoResult lottoResult) {
		LottoRank lottoRank = lottoResult.getLottoRank();

		System.out.printf("%s (%d원)- %d개\n", lottoRank.getText(), lottoRank.getPrize(), lottoResult.getWinnerCount());
	}

	private static void printReturnRate(LottoResults lottoResults) {
		System.out.printf("총 수익률은 %.2f입니다.", lottoResults.calculateReturnRate());
	}
}
