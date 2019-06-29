package lotto.model;

import common.NumberElement;
import lotto.exception.OutOfBoundLottoNumberException;

public class LottoNumber extends NumberElement {

	public LottoNumber(String value) {
		super(value);
	}

	public LottoNumber(int value) {
		super(value);

		if(value > LottoRule.MAX_NUMBER){
			throw new OutOfBoundLottoNumberException();
		}

		if(value < LottoRule.MIN_NUMBER){
			throw new OutOfBoundLottoNumberException();
		}

	}
}
