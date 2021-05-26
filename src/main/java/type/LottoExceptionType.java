package type;

public enum LottoExceptionType {
	ONLY_NUMBER("숫자만 입력 가능합니다."),
	WRONG_INPUT_TEXT("잘못된 입력입니다."),
	WRONG_LOTTO_NUMBER("잘못된 로또 숫자 입니다."),
	WRONG_LOTTO_PRICE("구입 금액은 0보다 작을 수 없습니다."),
	DUPLICATE_BONUS_NUMBER("보너스 숫자가 당첨 로또 번호와 중복됩니다.")
	;

	private String message;

	LottoExceptionType(final String message) {
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
