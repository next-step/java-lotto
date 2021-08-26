package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.type.WinningType;

public class Lottery {
	private final Numbers winningNumbers;
	private final Number bonusNumber;

	public Lottery(Numbers winningNumbers, Number bonusNumber) {
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

	private WinningType getDrawResult(Numbers lottoNumbers) {
		int bonusNumberValue = bonusNumber.getValue();
		List<Integer> winningNumberValues = winningNumbers.getNumbers()
			.stream()
			.map(Number::getValue)
			.collect(Collectors.toList());

		List<Integer> numbers = convertNumberValue(lottoNumbers.getNumbers());
		boolean matchBonus = numbers.contains(bonusNumberValue);
		numbers.retainAll(winningNumberValues);
		int matchNumber = numbers.size();
		return WinningType.getWinningType(matchNumber, matchBonus);
	}

	private List<Integer> convertNumberValue(List<Number> numbers) {
		return numbers.stream()
			.map(Number::getValue)
			.collect(Collectors.toList());
	}
}
