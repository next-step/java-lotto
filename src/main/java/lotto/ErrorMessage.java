package lotto;

public enum ErrorMessage {

    ERR_MONEY_INSUFFICIENT("로또를 구매하기에 부족한 금액입니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return this.message;
    }
}
