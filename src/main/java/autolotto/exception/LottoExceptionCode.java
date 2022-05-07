package autolotto.exception;

public enum LottoExceptionCode {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_TYPE("로또 번호는 1~45 사이 숫자만 가능합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복이 없어야 합니다. 보너스볼 포함. 입력 번호"),
    INVALID_QUANTITY_NUMBER_TYPE("로또 구매 수는 0 이상이어야 합니다.");

    LottoExceptionCode(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
