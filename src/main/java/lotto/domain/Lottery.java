package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.type.WinningType;

public class Lottery {
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public Lottery(List<Integer> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public LotteryResults draw(Lottos lottos) {
		List<LotteryResult> results = new ArrayList<>();
		for (Lotto lotto : lottos.getLottos()) {
			WinningType winningType = getDrawResult(lotto.getNumbers());
			results.add(new LotteryResult(winningType));
		}
		return new LotteryResults(results);
	}

	private WinningType getDrawResult(List<Number> lottoNumbers) {
		List<Integer> numbers = convertNumberValue(lottoNumbers);
		numbers.retainAll(winningNumbers);
		int matchNumber = numbers.size();
		boolean matchBonus = numbers.contains(bonusNumber);
		return WinningType.getWinningType(matchNumber, matchBonus);
	}

	private List<Integer> convertNumberValue(List<Number> numbers) {
		return numbers.stream()
			.map(Number::getValue)
			.collect(Collectors.toList());
	}
}
