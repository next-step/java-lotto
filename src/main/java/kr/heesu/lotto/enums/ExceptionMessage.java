package kr.heesu.lotto.enums;

public enum ExceptionMessage {
    EXCEPTION_FOR_PURCHASE_AMOUNT("구매 금액이 잘못 되었습니다."),
    EXCEPTION_FOR_LOTTO("로또 번호의 개수가 맞지 않습니다."),
    EXCEPTION_FOR_MANUAL_AMOUNT("수동으로 구매할 개수가 잘못 되었습니다."),
    EXCEPTION_FOR_LOTTO_NUMBER("로또 번호가 잘못 되었습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
