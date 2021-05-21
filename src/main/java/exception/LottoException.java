package exception;

public class LottoException extends RuntimeException {

	private LottoException(LottoExceptionType code){
		super(code.getMessage());
	}

	public static LottoException of(LottoExceptionType code){
		return new LottoException(code);
	}
}
