package lotto.view;

import lotto.domain.result.*;
import lotto.model.BonusPolicy;
import lotto.model.LottoPrizePolicy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

	public ResultView() {
	}

	public static void printResult(LottoMatchResultList lottoResultList, LottoPrizeAnalysisResult lottoPrizeAnalysisResult) {
		printMatch(lottoResultList);
		printEarningRate(lottoPrizeAnalysisResult.getEarningsRate());
	}

	public static void printMatch(LottoMatchResultList lottoResultList) {
		MatchCountList matchCountList = new MatchCountList(lottoResultList.getLottoMatchResults().stream().map(MatchResultPerLotto::getMatchCount).collect(Collectors.toList()));
		matchCountList.getMatchCounts().removeIf(e -> e.getMatchCount() < LottoPrizePolicy.getMinMatchCount().getMatchCount());

		for (LottoPrizePolicy lottoPrizePolicy : LottoPrizePolicy.values()){
			MatchCountList actualMatchCount = hasMatchCount(lottoPrizePolicy, lottoResultList);
			LottoMatchResultList bonusMatchResult = hasBonusNumber(lottoResultList, lottoPrizePolicy.getMatchCount(), lottoPrizePolicy.getBonusPolicy(), lottoPrizePolicy);
			printAnalyzeMessage(lottoPrizePolicy, actualMatchCount, bonusMatchResult);

		}
	}

	private static LottoMatchResultList hasBonusNumber(LottoMatchResultList lottoResultList, MatchCount matchCount, BonusPolicy bonus, LottoPrizePolicy lottoPrizePolicy) {
		return new LottoMatchResultList(lottoResultList.getLottoMatchResults().stream().filter(r -> r.getMatchCount().getMatchCount() == matchCount.getMatchCount() && bonus.isBonusPolicy() == true && LottoPrizePolicy.SECOND.equals(lottoPrizePolicy)).collect(Collectors.toList()));
	}

	private static void printAnalyzeMessage(LottoPrizePolicy lottoPrizePolicy, MatchCountList actualMatchCount, LottoMatchResultList matchResultPerLotto) {
		if(LottoPrizePolicy.SECOND.equals(lottoPrizePolicy) && !matchResultPerLotto.getLottoMatchResults().isEmpty()){
			System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d", lottoPrizePolicy.getMatchCount().getMatchCount(), lottoPrizePolicy.getPrizeMoney().getMoney(), actualMatchCount.getMatchCountSize()));
			return;
		}
		System.out.println(String.format("%d개 일치 (%d원)- %d", lottoPrizePolicy.getMatchCount().getMatchCount(), lottoPrizePolicy.getPrizeMoney().getMoney(), actualMatchCount.getMatchCountSize()));
	}

	private static MatchCountList hasMatchCount(LottoPrizePolicy lottoPrizePolicy, LottoMatchResultList lottoResultList) {
		MatchCountList matchCountList = new MatchCountList(lottoResultList.getLottoMatchResults().stream().filter(r -> r.getMatchCount().getMatchCount() == lottoPrizePolicy.getMatchCount().getMatchCount() && r.isHasBonusNumber().isHasBonusNumber() == lottoPrizePolicy.getBonusPolicy().isBonusPolicy() ).map(MatchResultPerLotto::getMatchCount).collect(Collectors.toList()));
		return matchCountList;
	}

	private static void printEarningRate(EarningsRate earningRate) {
		System.out.println(String.format("총 수익률은 %.2f입니다.", earningRate.getEarningsRate()));
	}
}
