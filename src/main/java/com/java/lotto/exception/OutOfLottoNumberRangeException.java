package com.java.lotto.exception;

public class OutOfLottoNumberRangeException extends RuntimeException {
	private static final long serialVersionUID = -1670157149822532465L;

	public OutOfLottoNumberRangeException() {
        super("로또 번호는 1에서 45사이만 입력이 가능합니다.");
    }
}
