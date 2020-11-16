package nextstep.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStaticstic {
	private String winnerNumbers;

	public LottoStaticstic(String winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public Map<LottoReward, List<Lotto>> getLottoRewardMap(List<Lotto> lottoList) {
		List<Integer> winnerNumbers = getWinnerNumbers();
		lottoList.forEach(lotto -> lotto.setLottoReward(winnerNumbers));
		return lottoList.stream()
				.collect(Collectors.groupingBy(Lotto::getLottoReward));
	}

	protected List<Integer> getWinnerNumbers() {
		return Stream.of(winnerNumbers.replaceAll(" ","").split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
