package autolotto;

public enum LottoExceptionCode {
    INVALID_WINNING_NUMBER_COUNT("당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_TYPE("당첨 번호는 1~45 사이 숫자만 가능합니다."),
    DUPLICATED_WINNING_NUMBER("당첨 번호는 중복된 숫자가 없어야 합니다.");

    LottoExceptionCode(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
