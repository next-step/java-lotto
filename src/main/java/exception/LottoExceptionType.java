package exception;

public enum LottoExceptionType {
	NEGATIVE_TEXT("문자열에 음수는 포함될 수 없습니다."),
	ONLY_NUMBER("숫자만 입력 가능합니다."),
	WRONG_INPUT_TEXT("잘못된 입력입니다."),
	WRONG_LOTTO_NUMBER("잘못된 로또 숫자 입니다.")
	;

	private String message;

	LottoExceptionType(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}
