package nextstep.step2.view;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoCount;
import nextstep.step2.domain.LottoReward;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LottoResultView {
	private static final String LOTTO_PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	private static final String LOTTO_STATISTICTS = "당첨통계\n---------";
	private static final String LOTTO_STATISTICTS_RESULT = "%d개 일치 (%d원)- %d개";
	private static final String LOTTO_STATISTICTS_BONUS_RESULT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
	private static final String LOTTO_PROBABILITY = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void printLottoPurchase(LottoCount lottoCount) {
		System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, lottoCount.getManual(), lottoCount.getAuto()));
	}

	public void printLottoStaticsic(Map<LottoReward, List<Lotto>> lottoRewardListMap) {
		System.out.println(LOTTO_STATISTICTS);
		lottoRewardListMap.keySet().stream()
				.sorted(Comparator.reverseOrder())
				.filter(reward -> reward.getCountOfMatch() > 0)
				.forEach(reward -> System.out.println(
						String.format(
								getPrintLottoStatisticsMessage(reward),
								reward.getCountOfMatch(),
								reward.getWinningMoney(),
								lottoRewardListMap.get(reward).size()
						)
				));
	}

	protected String getPrintLottoStatisticsMessage(LottoReward lottoReward) {
		if (lottoReward == LottoReward.SECOND) {
			return LOTTO_STATISTICTS_BONUS_RESULT;
		}
		return LOTTO_STATISTICTS_RESULT;
	}

	public void printWinningProbability(float probability) {
		System.out.println(String.format(LOTTO_PROBABILITY, probability));
	}
}
