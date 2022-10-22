package calculator.exception;

public enum ErrorMessage {
	OPERAND_MUST_BE_NUMBER("피연산자 {0}은(는) 숫자이어야 합니다."),
	INVALID_OPERATOR("유효하지 않은 연산자 {0} 입니다."),
	ILLEGAL_ARGUMENT("잘못된 인자 {0} 입니다.");

	String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
