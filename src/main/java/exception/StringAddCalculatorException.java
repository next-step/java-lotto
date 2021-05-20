package exception;

public class StringAddCalculatorException extends RuntimeException {

	private StringAddCalculatorException(StringAddCalculatorExceptionCode code){
		super(code.getMessage());
	}

	public static StringAddCalculatorException of(StringAddCalculatorExceptionCode code){
		return new StringAddCalculatorException(code);
	}
}
