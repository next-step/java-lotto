package autolotto.exception;

public enum LottoExceptionCode {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_TYPE("로또 번호는 1~45 사이 숫자만 가능합니다.");

    LottoExceptionCode(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
