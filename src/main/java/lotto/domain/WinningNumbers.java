package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.strategy.LottoNumberStrategy.LOTTO_NUMBER_COUNT;

public class WinningNumbers {
	private final Set<Integer> winningNumbers;

	public WinningNumbers(Set<Integer> winningNumbers) {
		if(winningNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("당첨 번호는" + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
		}
		this.winningNumbers = winningNumbers;
	}

	public WinningNumbers(String[] numbers) {
		this(Arrays.stream(numbers)
				.map(Integer::parseInt)
				.collect(Collectors.toSet()));
	}

	public Long getMatchedCount(Lotto lotto) {
		return winningNumbers.stream()
				.filter(lotto::isMatched)
				.count();
	}
}
