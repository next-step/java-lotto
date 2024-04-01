package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.strategy.LottoNumberStrategy.*;

public class WinningNumbers {
	private final Set<Integer> winningNumbers;
	private final int bonusNumber;

	public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
		if(winningNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
		}

		if(winningNumbers.stream().anyMatch(x -> x < LOTTO_NUMBER_MIN || x > LOTTO_NUMBER_MAX)) {
			throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_MIN + " 미만 " + LOTTO_NUMBER_MAX + " 초과인 수를 입력할 수 없습니다.");
		}

		if(bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
			throw new IllegalArgumentException("보너스 번호는 " + LOTTO_NUMBER_MIN + " 미만 " + LOTTO_NUMBER_MAX + " 초과인 수를 입력할 수 없습니다.");
		}

		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public WinningNumbers(String[] winningNumbers, int bonusNumber) {
		this(Arrays.stream(winningNumbers)
				.map(Integer::parseInt)
				.collect(Collectors.toSet()), bonusNumber);
	}

	public Long getMatchedCount(Lotto lotto) {
		return winningNumbers.stream()
				.filter(lotto::isMatched)
				.count();
	}

	public boolean hasBonusNumber(Lotto lotto) {
		return lotto.isMatched(bonusNumber);
	}
}
