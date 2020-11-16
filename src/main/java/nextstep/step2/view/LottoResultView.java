package nextstep.step2.view;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoReward;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResultView {
	private static final String LOTTO_STATISTICTS = "\n당첨통계\n---------";

	public void printLottoPercentage(Map<LottoReward, List<Lotto>> lottoRewardListMap) {
		System.out.println(LOTTO_STATISTICTS);
		//groupby ------------>
		printLottoPersentage(lottoRewardListMap);
	}

	private void printLottoPersentage(Map<LottoReward, List<Lotto>> lottoMap) {
		addLottoEmptyReward(lottoMap);
		lottoMap.keySet().stream().sorted(Comparator.reverseOrder()).forEach(lottoReward -> {
			if (lottoReward.getCount() > 0) {
				System.out.println(String.format("%d개 일치 (%s)- %d개", lottoReward.getCount(), lottoReward.getPrice(), lottoMap.get(lottoReward).size()));
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
}
