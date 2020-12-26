package lotto.view;

import lotto.LottoMatchResultList;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
import lotto.model.LottoPrizePolicy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

	public ResultView() {
	}

	public static void printResult(LottoMatchResultList lottoResultList, LottoResult lottoResult) {
		printMatch(lottoResultList.getLottoMatchResults(), lottoResult);
		printEarningRate(lottoResult.getEarningsRate());
	}

	public static void printMatch(List<LottoMatchResult> lottoResultList, LottoResult lottoResult) {
		List<Integer> matchList = lottoResultList.stream().map(LottoMatchResult::getMatchResult).collect(Collectors.toList());
		matchList.removeIf(e -> e < LottoPrizePolicy.getMinMatchCount());
		Collections.sort(matchList);


		for (LottoPrizePolicy lottoPrizePolicy : LottoPrizePolicy.values()){
			int actualMatchCount = hasMatchCount(lottoPrizePolicy, lottoResultList);
			List<LottoMatchResult> bonusMatchResult = hasBonusNumber(lottoResultList, lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.isBonus(), lottoPrizePolicy);
			printAnalyzeMessage(lottoPrizePolicy, actualMatchCount, bonusMatchResult);

		}
	}

	private static List<LottoMatchResult> hasBonusNumber(List<LottoMatchResult> lottoResultList, int matchCount, boolean bonus, LottoPrizePolicy lottoPrizePolicy) {
		return lottoResultList.stream().filter(r -> r.getMatchResult() == matchCount && bonus == true && LottoPrizePolicy.SECOND.equals(lottoPrizePolicy)).collect(Collectors.toList());
	}

	private static void printAnalyzeMessage(LottoPrizePolicy lottoPrizePolicy, int actualMatchCount, List<LottoMatchResult> lottoMatchResult) {
		if(LottoPrizePolicy.SECOND.equals(lottoPrizePolicy) && !lottoMatchResult.isEmpty()){
			System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d", lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getPrizeMoney(), actualMatchCount));
			return;
		}
		System.out.println(String.format("%d개 일치 (%d원)- %d", lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getPrizeMoney(), actualMatchCount));
	}

	private static int hasMatchCount(LottoPrizePolicy lottoPrizePolicy, List<LottoMatchResult> lottoResultList) {
		List<Integer> matchList = lottoResultList.stream().filter(r -> r.getMatchResult() == lottoPrizePolicy.getMatchCount() && r.isHasBonusNumber() == lottoPrizePolicy.isBonus() ).map(LottoMatchResult::getMatchResult).collect(Collectors.toList());
		return matchList.size();
	}

	private static void printEarningRate(double earningRate) {
		System.out.println(String.format("총 수익률은 %.2f입니다.", earningRate));
	}
}
