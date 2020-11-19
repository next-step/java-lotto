package nextstep.step2.view;

import nextstep.step2.domain.LottoReward;
import nextstep.step2.domain.WinningLotto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LottoResultView {
	private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
	private static final String LOTTO_STATISTICTS = "당첨통계\n---------";
	private static final String LOTTO_STATISTICTS_RESULT = "%d개 일치 (%d원)- %d개";
	private static final String LOTTO_PROBABILITY = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void printLottoPurchase(int lottoCount) {
		System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, lottoCount));
	}

	public void printLottoStaticsic(Map<LottoReward, List<WinningLotto>> lottoRewardListMap) {
		System.out.println(LOTTO_STATISTICTS);
		lottoRewardListMap.keySet().stream()
				.sorted(Comparator.reverseOrder())
				.filter(reward -> reward.getCountOfMatch() > 0)
				.forEach(reward -> System.out.println(
						String.format(
								LOTTO_STATISTICTS_RESULT,
								reward.getCountOfMatch(),
								reward.getWinningMoney(),
								lottoRewardListMap.get(reward).size()
						)
				));
	}

	public void printWinningProbability(float probability) {
		System.out.println(String.format(LOTTO_PROBABILITY, probability));
	}
}
