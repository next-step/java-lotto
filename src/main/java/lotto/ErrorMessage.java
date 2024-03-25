package lotto;

public enum ErrorMessage {

    ERR_MONEY_INSUFFICIENT("로또를 구매하기에 부족한 금액입니다."),
    ERR_INVALID_MANUAL_COUNT("수동구매 횟수가 구매가능 횟수보다 크게 설정되었습니다."),
    ERR_INVALID_COUNT("유효하지 않은 구매횟수가 설정되었습니다."),

    ERR_NOT_ENOUGH_NUMBER("로또 숫자 개수가 잘못되었습니다."),
    ERR_NUMBER_OUT_OF_BOUNDARY("로또 숫자의 범위를 벗어났습니다."),
    ERR_OVER_COUNT("시행횟수가 예산을 초과했습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return this.message;
    }
}
