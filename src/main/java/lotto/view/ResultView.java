package lotto.view;

import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
import lotto.model.LottoPrizePolicy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

	public ResultView() {
	}

	public static void printResult(List<LottoMatchResult> lottoResultList, LottoResult lottoResult) {
		printMatch(lottoResultList, lottoResult);
		printEarningRate(lottoResult.getEarningsRate());
	}

	public static void printMatch(List<LottoMatchResult> lottoResultList, LottoResult lottoResult) {
		List<Integer> matchList = lottoResultList.stream().map(LottoMatchResult::getMatchResult).collect(Collectors.toList());
		matchList.removeIf(e -> e < LottoPrizePolicy.getMinMatchCount());
		Collections.sort(matchList);

		for (LottoPrizePolicy lottoPrizePolicy : LottoPrizePolicy.values()){
			int actualMatchCount = hasMatchCount(matchList, lottoPrizePolicy.getMatchCount());
			List<LottoMatchResult> bonusMatchResult = hasBonusNumber(lottoResultList, lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.isBonus());
			printAnalyzeMessage(lottoPrizePolicy, actualMatchCount, bonusMatchResult);

		}
	}

	private static List<LottoMatchResult> hasBonusNumber(List<LottoMatchResult> lottoResultList, int matchCount, boolean bonus) {
		return lottoResultList.stream().filter(r -> r.getMatchResult() == matchCount && bonus == true).collect(Collectors.toList());
	}

	private static void printAnalyzeMessage(LottoPrizePolicy lottoPrizePolicy, int actualMatchCount, List<LottoMatchResult> lottoMatchResults) {
		if(LottoPrizePolicy.SECOND.equals(lottoPrizePolicy)){
			System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d", lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getPrizeMoney(), actualMatchCount, lottoMatchResults.size()));
			return;
		}
		System.out.println(String.format("%d개 일치 (%d원)- %d", lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getPrizeMoney(), actualMatchCount));

	}

	private static int hasMatchCount(List<Integer> lottoResultList, int matchCount) {
		if(lottoResultList.contains(matchCount)){
			return Collections.frequency(lottoResultList, matchCount);
		}
		return 0;
	}

	public static void printEarningRate(double earningRate) {
		System.out.println(String.format("총 수익률은 %.2f입니다.", earningRate));
	}
}
