package lotto.domain.dto;

import lotto.utils.StringFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoWinningNumber extends LottoNumber {
	private int bonusNumber;

	public LottoWinningNumber(List<Integer> electedNumbers, int bonusNumber) {
		super(electedNumbers);
		this.bonusNumber = bonusNumber;

		if (isInvalidLottoNumbers(electedNumbers, bonusNumber)) {
			throwIllegalException(electedNumbers, bonusNumber);
		}
	}

	private void throwIllegalException(List<Integer> numbers, int bonusNumber) {
		throw new IllegalArgumentException(String.format("Instantiate LottoWinningNumber failed. " +
						"bonus Number cannot be elected numbers : numbers=%s, bonusNumber=%d",
				StringFormatter.listToString(numbers),
				bonusNumber));
	}

	private boolean isInvalidLottoNumbers(List<Integer> numbers, int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
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