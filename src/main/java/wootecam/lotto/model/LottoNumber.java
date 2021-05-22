package wootecam.lotto.model;

import wootecam.lotto.exception.LottoException;
import wootecam.util.StringUtils;

public class LottoNumber {
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;
	private final int number;

	public LottoNumber(String numberInput) {
		if (!StringUtils.isNumeric(numberInput)) {
			throw new LottoException("정수형이 아닙니다.");
		}
		int number = Integer.parseInt(numberInput);
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new LottoException("로또 번호는 1~45만 가능합니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
