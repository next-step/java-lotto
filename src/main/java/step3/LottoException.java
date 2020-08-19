package step3;

public class LottoException extends RuntimeException{

	public LottoException(String message) {
		super(message);
	}

	public LottoException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
