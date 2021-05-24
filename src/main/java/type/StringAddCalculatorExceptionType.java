package type;

public enum StringAddCalculatorExceptionType {
	NEGATIVE_TEXT("문자열에 음수는 포함될 수 없습니다."),
	;

	private String message;

	StringAddCalculatorExceptionType(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}
