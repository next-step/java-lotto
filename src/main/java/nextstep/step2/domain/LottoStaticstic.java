package nextstep.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStaticstic {
	private static final String WRONG_WINNER_NUMBERS = "지난주 로또 당첨번호는 모두 숫자여야 합니다.";
	private String winnerNumbers;
	private LottoPurchase purchase;

	public LottoStaticstic(String winnerNumbers, LottoPurchase purchase) {
		this.winnerNumbers = winnerNumbers;
		this.purchase = purchase;
	}

	public Map<LottoReward, List<WinningLotto>> getLottoRewardMap(List<Lotto> lottoList) {
		Lotto winnerNumbers = getLastWeekWinningLotto();
		List<WinningLotto> winningLottos = lottoList.stream()
				.map(lotto -> new WinningLotto(lotto, winnerNumbers))
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return winningLottos.stream()
				.collect(Collectors.groupingBy(WinningLotto::getLottoReward));
	}


	protected Lotto getLastWeekWinningLotto() {
		String[] winningNumberSplit = winnerNumbers.replaceAll(" ", "").split(",");
		validateLastWinnerNumbers(winningNumberSplit);
		Set<Integer> winningNumbers =  Stream.of(winningNumberSplit)
				.map(Integer::parseInt)
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		return new Lotto(winningNumbers);
	}

	protected void validateLastWinnerNumbers(String[] numbers) {
		boolean isDigit = Stream.of(numbers).allMatch(oddNum -> oddNum.chars().allMatch(Character::isDigit));
		if (!isDigit) {
			throw new IllegalArgumentException(WRONG_WINNER_NUMBERS);
		}
	}

	public float calculateWinningProbability(Map<LottoReward, List<WinningLotto>> lottoResultMap) {
		int totalAmount = lottoResultMap.keySet()
				.stream()
				.map(reward -> reward.getPrice() * lottoResultMap.get(reward).size())
				.reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}
}
