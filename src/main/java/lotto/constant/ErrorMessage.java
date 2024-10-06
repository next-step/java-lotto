package lotto.constant;

public enum ErrorMessage {
    NEED_SIX_NUMBERS("6개 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER("중복된 숫자가 존재합니다."),
    INVALID_LOTTO_PRICE("로또 구입 금액은 1,000원 단위로 입력하셔야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1에서 45 사이 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
