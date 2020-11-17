package nextstep.step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
		List<Integer> winnerNumbers = getWinnerNumbers();
		List<WinningLotto> winningLottos = lottoList.stream()
				.map(lotto -> new WinningLotto(lotto, winnerNumbers))
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return winningLottos.stream()
				.collect(Collectors.groupingBy(WinningLotto::getLottoReward));
	}


	protected List<Integer> getWinnerNumbers() {
		validateLastWinnerNumbers(winnerNumbers);
		return Stream.of(winnerNumbers.replaceAll(" ", "").split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	protected void validateLastWinnerNumbers(String winnerNumbers) {
		String[] numbers = winnerNumbers.replaceAll(" ","").split(",");
		boolean isDigit = Arrays.stream(numbers).allMatch(oddNum -> oddNum.chars().allMatch(Character::isDigit));
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
