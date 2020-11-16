package nextstep.step2.view;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoReward;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResultView {
	private static final String LOTTO_STATISTICTS = "당첨통계\n---------";

	public void printLottoStaticsic(Map<LottoReward, List<Lotto>> lottoMap) {
		System.out.println(LOTTO_STATISTICTS);
		addLottoEmptyReward(lottoMap); //로또번호가 3개 이상 맞지 않아도 출력하기 위해서 추가한다.
		lottoMap.keySet().stream()
				.sorted(Comparator.reverseOrder())
				.forEach(lottoReward -> {
					if (lottoReward.getCount() > 0) { //2개 이하 맞았을 경우는 제외하고 출력하기
						System.out.println(String.format("%d개 일치 (%d원)- %d개", lottoReward.getCount(), lottoReward.getPrice(), lottoMap.get(lottoReward).size()));
					}
				});
	}

	private void addLottoEmptyReward(Map<LottoReward, List<Lotto>> lottoMap) {
		Stream.of(LottoReward.values()).forEach(lottoReward -> {
			if (!lottoMap.keySet().contains(lottoReward)) {
				lottoMap.put(lottoReward, new ArrayList<>());
			}
		});
	}

	public void printWinningProbability(float probability) {
		System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", probability));
	}
}
