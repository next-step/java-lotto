package lotto.exception;

public enum ErrorMessage {
	MONEY_MUST_BE_POSITIVE("돈은 양수이어야 합니다.");

	String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
