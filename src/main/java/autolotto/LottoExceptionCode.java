package autolotto;

public enum LottoExceptionCode {
    WINNING_NUMBER_LENGTH_HAVE_TO_BE_SIX("당첨 번호는 6자리여야 합니다.");

    LottoExceptionCode(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
