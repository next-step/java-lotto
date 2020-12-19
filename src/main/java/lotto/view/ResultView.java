package lotto.view;

import lotto.domain.LottoResult;
import lotto.model.LottoPrizePolicy;

import java.util.Collections;
import java.util.List;

public class ResultView {

	public ResultView() {
	}

	public static void printResult(List<Integer> lottoResultList, LottoResult lottoResult) {
		printMatch(lottoResultList, lottoResult);
		printEarningRate(lottoResult.getEarningsRate());
	}

	public static void printMatch(List<Integer> lottoResultList, LottoResult lottoResult) {
		Collections.sort(lottoResultList);
		lottoResultList.removeIf(e -> e < LottoPrizePolicy.getMinMatchCount());
		for (LottoPrizePolicy lottoPrizePolicy : LottoPrizePolicy.values()){
			int actualMatchCount = hasMatchCount(lottoResultList, lottoPrizePolicy.getMatchCount());
			System.out.println(String.format("%d개 일치 (%d원)- %d", lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getPrizeMoney(), actualMatchCount));
		}
	}

	private static int hasMatchCount(List<Integer> lottoResultList, int matchCount) {
		if(lottoResultList.contains(matchCount)){
			return Collections.frequency(lottoResultList, matchCount);
		}
		return 0;
	}

	public static void printEarningRate(double earningRate) {
		if (earningRate < 1) {
			System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate));
		}
	}
}
