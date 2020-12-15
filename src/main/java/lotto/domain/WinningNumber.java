package lotto.domain;

public class WinningNumber {
	private final LottoNumber winningNumbers;
	private final int bonusNumber;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	public WinningNumber(LottoNumber winningNumbers, int bonusNumber) {
		validateBonusNumbers(winningNumbers, bonusNumber);
		this.bonusNumber = bonusNumber;
		this.winningNumbers = winningNumbers;
	}

	public LottoRank match(LottoNumber numbers) {
		return LottoRank.valueOfMatchCountAndMatchBonus(this.matchCount(numbers), this.matchBonus(numbers));
	}

	private int matchCount(LottoNumber number) { return number.matchCount(this.winningNumbers); }

	private boolean matchBonus(LottoNumber number) { return number.isContains(this.bonusNumber); }

	private void validateBonusNumbers(LottoNumber winningNumbers, int bonusNumber) {
		checkValidRange(bonusNumber);
		checkAlreadyExist(winningNumbers, bonusNumber);
	}

	private void checkValidRange(int bonusNumber) {
		if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
			throw new IllegalArgumentException(String.format("보너스 번호는 %d 과 %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER));
		}
	}

	private void checkAlreadyExist(LottoNumber winningNumbers, int bonusNumber) {
		if (winningNumbers.isContains(bonusNumber)) {
			throw new IllegalArgumentException("이미 당첨번호에 포함된 숫자는 보너스 번호가 될 수 없습니다.");
		}
	}


}
