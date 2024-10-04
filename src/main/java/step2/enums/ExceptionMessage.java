package step2.enums;

public enum ExceptionMessage {
    MINIMUM_LOTTO_PRICE("로또의 가격은 1000원입니다."),
    MINIMUM_LOTTO_NUM("로또는 최소 1장이상부터 생성이 가능합니다."),
    RANGE_LOTTO_NUM("로또번호는 1~45범위안에 포함되야 합니다."),
    NOT_MATCH_PRIZE("로또 당첨번호를 맞춰보지 않았습니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
