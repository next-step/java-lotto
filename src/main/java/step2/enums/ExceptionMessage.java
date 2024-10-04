package step2.enums;

public enum ExceptionMessage {
    MINIMUM_LOTTO_PRICE("로또의 가격은 1000원입니다."),
    MINIMUM_LOTTO_NUM("로또는 최소 1장이상부터 생성이 가능합니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
