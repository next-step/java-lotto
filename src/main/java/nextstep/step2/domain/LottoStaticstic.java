package nextstep.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStaticstic {
	private String winnerNumbers;
	private LottoPurchase purchase;

	public LottoStaticstic(String winnerNumbers, LottoPurchase purchase) {
		this.winnerNumbers = winnerNumbers;
		this.purchase = purchase;
	}

	public Map<LottoReward, List<Lotto>> getLottoRewardMap(List<Lotto> lottoList) {
		List<Integer> winnerNumbers = getWinnerNumbers();
		lottoList.forEach(lotto -> lotto.setLottoReward(winnerNumbers));
		return lottoList.stream()
				.collect(Collectors.groupingBy(Lotto::getLottoReward));
	}

	protected List<Integer> getWinnerNumbers() {
		return Stream.of(winnerNumbers.replaceAll(" ", "").split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public float calculateWinningProbability(Map<LottoReward, List<Lotto>> lottoResultMap) {
		int totalAmount = lottoResultMap.keySet()
				.stream()
				.map(reward -> { //
					int lottoCount = lottoResultMap.get(reward).size();
					return reward.getPrice() * lottoCount;
				}).reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}
}
