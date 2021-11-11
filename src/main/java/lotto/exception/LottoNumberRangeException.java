package lotto.exception;

import lotto.domain.LottoNumber;

public class LottoNumberRangeException extends IllegalArgumentException {
	private static final long serialVersionUID = -5783158223883818816L;

	public LottoNumberRangeException() {
		super(String.format("당첨번호는 %d ~ %d 사이만 가능합니다.", LottoNumber.MIN_OF_LOTTO_NUMBERS,
			LottoNumber.MAX_OF_LOTTO_NUMBERS));
	}
}
