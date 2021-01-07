package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lotto.domain.LottoCount;
import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.Message;

public class OutputView {

	public static void printLottoLotteries(LottoLotteries lottoLotteries) {
		printLottoLotteries(lottoLotteries.getLottoLotteries());
		System.out.println();
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
		System.out.println(Message.RESULT_STATS);
		System.out.println("---------");
		Arrays.stream(LottoRank.values())
			.sorted(Comparator.comparingInt(LottoRank::getPrize))
			.filter(LottoRank::isNotNone)
			.forEach(lottoRank -> printLottoResult(lottoResults.findLottoResult(lottoRank)));
	}

	private static void printLottoResult(LottoResult lottoResult) {
		LottoRank lottoRank = lottoResult.getLottoRank();

		System.out.printf(Message.LOTTO_RESULT_FORMAT, lottoRank.getText(), lottoRank.getPrize(),
			lottoResult.getWinnerCount());
	}

	private static void printReturnRate(LottoResults lottoResults) {
		System.out.printf(Message.LOTTO_RETURN_RATE_FORMAT, lottoResults.calculateReturnRate());
	}

	public static void printLottoCounts(LottoCount lottoCount) {
		System.out.printf(Message.LOTTO_COUNTS_FORMAT, lottoCount.getManualCount(), lottoCount.getAutoCount());
	}
}
