package lotto.domain;

import lotto.utils.StringFormatter;

import java.util.Objects;

class LottoWinningNumber {
	private LottoNumber electedNumber;
	private LottoNo bonusNumber;

	LottoWinningNumber(LottoNumber electedNumbers, LottoNo bonusNumber) {
		this.electedNumber = electedNumbers;
		this.bonusNumber = bonusNumber;

		if (isInvalidLottoNumbers()) {
			throwIllegalException();
		}
	}

	private void throwIllegalException() {
		throw new IllegalArgumentException(String.format("Instantiate LottoWinningNumber failed. " +
						"bonus Number cannot be elected numbers : numbers=%s, bonusNumber=%d",
				StringFormatter.listToString(electedNumber.getLottoNumbers().getNumbers()),
				bonusNumber.getNumber()));
	}

	private boolean isInvalidLottoNumbers() {
		return electedNumber.containsNumber(bonusNumber);
	}

	LottoRank matchLottoNumber(LottoNumber drawNumber) {
		int correctNumbers = getMatchElectedNumberCount(drawNumber);
		boolean matchBonus = drawNumber.containsNumber(this.bonusNumber);
		return LottoRank.getFromCorrectNumbers(correctNumbers, matchBonus);
	}

	private int getMatchElectedNumberCount(LottoNumber drawNumber) {
		return this.electedNumber.countContainsNumbers(drawNumber);
	}

	@Override
	public String toString() {
		return "LottoWinningNumber{" +
				"electedNumber=" + electedNumber +
				", bonusNumber=" + bonusNumber +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		LottoWinningNumber that = (LottoWinningNumber) o;
		return bonusNumber == that.bonusNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), bonusNumber);
	}
}