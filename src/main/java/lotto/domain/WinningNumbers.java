package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.strategy.LottoNumberStrategy.*;

public class WinningNumbers {
	private final Set<Integer> winningNumbers;

	public WinningNumbers(Set<Integer> winningNumbers) {
		if(winningNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
		}

		if(winningNumbers.stream().anyMatch(x -> x < LOTTO_NUMBER_MIN || x > LOTTO_NUMBER_MAX)) {
			throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_MIN + " 미만 " + LOTTO_NUMBER_MAX + " 초과인 수를 입력할 수 없습니다.");
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
