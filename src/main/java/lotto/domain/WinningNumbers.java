package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.domain.strategy.LottoNumberStrategy.*;

public class WinningNumbers {
	private final LottoNumbers winningNumbers;
	private final int bonusNumber;

	public WinningNumbers(LottoNumbers winningNumbers, int bonusNumber) {
		if(bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
			throw new IllegalArgumentException("보너스 번호는 " + LOTTO_NUMBER_MIN + " 미만 " + LOTTO_NUMBER_MAX + " 초과인 수를 입력할 수 없습니다.");
		}

		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public WinningNumbers(String[] winningNumbers, int bonusNumber) {
		this(new LottoNumbers(Arrays.stream(winningNumbers)
				.map(Integer::parseInt)
				.collect(Collectors.toList())), bonusNumber);
	}

	public Long getMatchedCount(Lotto lotto) {
		return winningNumbers.getLottoNumbers().stream()
				.filter(lotto::isMatched)
				.count();
	}

	public boolean hasBonusNumber(Lotto lotto) {
		return lotto.isMatched(bonusNumber);
	}
}
