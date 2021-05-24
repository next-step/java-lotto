package exception;

import type.LottoExceptionType;

public class LottoException extends RuntimeException {

	private LottoException(LottoExceptionType code){
		super(code.message());
	}

	public static LottoException of(LottoExceptionType code){
		return new LottoException(code);
	}
}
