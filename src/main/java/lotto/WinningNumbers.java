package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
	private final Set<Integer> winningNumbers;

	public WinningNumbers(Set<Integer> winningNumbers) {
		if(winningNumbers.size() != 6) {
			throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
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
