package lotto.model;

import common.NumberElement;
import lotto.exception.OutOfBoundLottoNumberException;

/**
 *
 * NumberElement 를 상속받아 로또 번호에 맞는 경계값 검사 추가
 */

public class LottoNumber extends NumberElement {

	public LottoNumber(String value) {
		super(value);
	}

	public LottoNumber(int value) {
		super(value);
	}

	@Override
	protected void setValue(int value) {
		if(value > LottoRule.MAX_NUMBER){
			throw new OutOfBoundLottoNumberException();
		}

		if(value < LottoRule.MIN_NUMBER){
			throw new OutOfBoundLottoNumberException();
		}

		super.setValue(value);
	}
}
