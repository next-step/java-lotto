package lotto;

import exception.LottoException;
import type.LottoExceptionType;

import java.util.Objects;

public class WinningLottoNumbers {

	private final LottoNumbers winningLottoNumbers;
	private final LottoNumber bonusNumber;

	public WinningLottoNumbers(final LottoNumbers winningLottoNumbers, final LottoNumber bonusNumber) {
		checkParameter(winningLottoNumbers, bonusNumber);

		this.winningLottoNumbers = winningLottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	private void checkParameter(final LottoNumbers winningLottoNumbers, final LottoNumber bonusNumber) {
		checkNull(winningLottoNumbers, bonusNumber);
		checkDuplicate(winningLottoNumbers, bonusNumber);
	}

	private void checkNull(final LottoNumbers winningLottoNumbers, final LottoNumber bonusNumber) {
		if (Objects.isNull(winningLottoNumbers) || Objects.isNull(bonusNumber)) {
			throw LottoException.of(LottoExceptionType.NULL_PARAMETER);
		}
	}

	private void checkDuplicate(final LottoNumbers winningLottoNumbers, final LottoNumber bonusNumber) {
		if (winningLottoNumbers.contains(bonusNumber)) {
			throw LottoException.of(LottoExceptionType.DUPLICATE_BONUS_NUMBER);
		}
	}

	public LottoNumbers winningLottoNumbers(){
		return this.winningLottoNumbers;
	}

	public LottoNumber bonusNumber(){
		return this.bonusNumber;
	}
}
