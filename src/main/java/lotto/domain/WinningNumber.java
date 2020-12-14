package lotto.domain;

import java.util.List;

public class WinningNumber {
	private final LottoNumber winningNumbers;
	private final int bonusNumber;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
		checkValidBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
		this.winningNumbers = new LottoNumber(winningNumbers);
	}

	public LottoRank match(LottoNumber numbers) {
		return LottoRank.valueOfMatchCount(this.getMatchCount(numbers));
	}

	private int getMatchCount(LottoNumber number) {
		return this.winningNumbers.matchCount(number);
	}

	private void checkValidBonusNumber(int bonusNumber) {
		if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
			throw new IllegalArgumentException(String.format("보너스 번호는 %d 과 %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER));
		}
	}
}
