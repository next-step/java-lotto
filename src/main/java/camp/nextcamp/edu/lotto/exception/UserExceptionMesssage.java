package camp.nextcamp.edu.lotto.exception;

public enum UserExceptionMesssage {
	IS_NOT_LOTTO_RANGE("Lotto 는 1~46까지만 입력이 가능합니다."),
	MAXIUMUM_SIZE("Lotto 개수는 6개여야 됩니다."),
	SLICE_WITH_COMMA(",  단위로 잘라서 입력해주세요."),
	ONLY_NUMBER("숫자만 입력이 가능합니다."),
	OVERLAP_BONUS_NUMBER("보너스 숫자는 로또번호를 제외한 숫자만 가능합니다"),
	NOT_CONTAINS_IN_WINNING_PRICE("수상에 없는 영역입니다."),
	ILLEGAL_MANUAL_LOTTO_COUNT("수동으로 입력한 로또 갯수가 구입한 로또 금액보다 큽니다.");

	private final String message;

	UserExceptionMesssage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
