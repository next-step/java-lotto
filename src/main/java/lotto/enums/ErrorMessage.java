package lotto.enums;

public enum ErrorMessage {
	INVALID_PATTERN("형식에 맞게 입력해주세요.\n  예) 1,2:3 혹은 //;\\n1,2:3;4");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}

}
