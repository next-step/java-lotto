package lotto.exception;

public enum ErrorMessage {
	MONEY_MUST_BE_POSITIVE("돈은 양수이어야 합니다."),
	LOTTO_NUMBERS_QUANTITY_MUST_BE_SIX("로또 숫자 갯수는 6개이어야 합니다."),
	INVALID_MATCH_COUNT("유효하지 않은 일치 갯수 입니다."),
	LOTTO_NUMBERS_MUST_NOT_BE_DUPLICATED("로또 숫자는 중복되면 안됩니다."),
	BONUS_NUMBER_MUST_NOT_BE_DUPLICATED("보너스 숫자는 중복되면 안됩니다."),
	LOTTO_NUMBER_MUST_BE_BETWEEN_1_AND_45("로또 숫자는 1~45 사이이어야 합니다.");

	String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
