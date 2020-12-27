package lotto.domain;

import lotto.domain.result.LottoMatchResultList;
import lotto.domain.input.Money;
import lotto.domain.result.HasBonusNumber;
import lotto.domain.result.MatchCount;
import lotto.domain.result.MatchResultPerLotto;
import lotto.domain.result.LottoPrizeAnalysisResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeAnalysisResultTest {

	@Test
	public void 본전케이스_당첨금_계산_테스트() {
		LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(3), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(3), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));

		lottoPrizeAnalysisResult.arrangePrize(lottoMatchResultList, new Money(1000));
		assertThat(lottoPrizeAnalysisResult.getEarningsRate().getEarningsRate()).isEqualTo(1);
		assertThat(lottoPrizeAnalysisResult.getTotalPrizeMoney().getMoney()).isEqualTo(10000);
	}

	@Test
	public void 손해케이스_당첨금_계산_테스트_손해() {
		LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(3), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoPrizeAnalysisResult.arrangePrize(lottoMatchResultList, new Money(1000));
		assertThat(lottoPrizeAnalysisResult.getEarningsRate().getEarningsRate()).isEqualTo(0.5);
		assertThat(lottoPrizeAnalysisResult.getTotalPrizeMoney().getMoney()).isEqualTo(5_000);
	}

	@Test
	public void 이익케이스_당첨금_계산_테스트() {
		LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(6), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoMatchResultList.add(new MatchResultPerLotto(new MatchCount(1), new HasBonusNumber(false)));
		lottoPrizeAnalysisResult.arrangePrize(lottoMatchResultList, new Money(1000));
		assertThat(lottoPrizeAnalysisResult.getEarningsRate().getEarningsRate()).isEqualTo(200000);
		assertThat(lottoPrizeAnalysisResult.getTotalPrizeMoney().getMoney()).isEqualTo(2_000_000_000);
	}
}