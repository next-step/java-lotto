package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.type.WinningType;

public class Lottery {
	private final List<Integer> winningNumbers;
	private LotteryResults lotteryResults;

	public Lottery(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public void draw(List<Lotto> lottos) {
		List<LotteryResult> results = new ArrayList<>();
		for (Lotto lotto : lottos) {
			List<Integer> numbers = lotto.getNumbers().stream()
				.map(Number::getValue)
				.collect(Collectors.toList());
			numbers.retainAll(winningNumbers);
			int matchNumber = numbers.size();

			WinningType winningType = WinningType.getWinningType(matchNumber);
			results.add(new LotteryResult(winningType));
		}

		lotteryResults = new LotteryResults(results);
	}

	public LotteryResults getLotteryResults() {
		return lotteryResults;
	}
}
