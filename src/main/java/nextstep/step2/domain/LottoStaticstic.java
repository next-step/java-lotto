package nextstep.step2.domain;

import java.util.*;
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
		Map<LottoReward, List<WinningLotto>> lottoRewardListMap = getLottoRewardGroupingMap(lottoList);
		addLottoEmptyReward(lottoRewardListMap);  //로또번호가 3개 이상 맞지 않아도 출력하기 위해서 추가한다.
		return lottoRewardListMap;
	}

	private Map<LottoReward, List<WinningLotto>> getLottoRewardGroupingMap(List<Lotto> lottoList) {
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
				.map(reward -> reward.getWinningMoney() * lottoResultMap.get(reward).size())
				.reduce(0, Integer::sum);
		return (float) totalAmount / (purchase.getLottoCount() * purchase.LOTTO_PRICE);
	}

	private void addLottoEmptyReward(Map<LottoReward, List<WinningLotto>> lottoRewardListMap) {
		Stream.of(LottoReward.values()).forEach(lottoReward -> {
			if (!lottoRewardListMap.keySet().contains(lottoReward)) {
				lottoRewardListMap.put(lottoReward, new ArrayList<>());
			}
		});
	}
}
