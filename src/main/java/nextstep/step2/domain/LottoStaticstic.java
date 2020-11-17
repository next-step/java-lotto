package nextstep.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStaticstic {
	private String winnerNumbers;
	private LottoPurchase purchase;

	public LottoStaticstic(String winnerNumbers, LottoPurchase purchase) {
		this.winnerNumbers = winnerNumbers;
		this.purchase = purchase;
	}

	public Map<LottoReward, List<WinningLotto>> getLottoRewardMap(List<Lotto> lottoList) {
		List<Integer> winnerNumbers = getWinnerNumbers();
		List<WinningLotto> winningLottos = lottoList.stream()
				.map(lotto -> new WinningLotto(lotto, winnerNumbers))
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return winningLottos.stream()
				.collect(Collectors.groupingBy(WinningLotto::getLottoReward));
	}

	protected List<Integer> getWinnerNumbers() {
		return Stream.of(winnerNumbers.replaceAll(" ", "").split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public float calculateWinningProbability(Map<LottoReward, List<WinningLotto>> lottoResultMap) {
		int totalAmount = lottoResultMap.keySet()
				.stream()
				.map(reward -> reward.getPrice() * lottoResultMap.get(reward).size())
				.reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}
}
