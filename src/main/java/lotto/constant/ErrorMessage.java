package lotto.constant;

public enum ErrorMessage {
    NEED_DISTINCT_SIX_NUMBERS("공백이 아닌 중복되지 않는 6개 숫자를 입력해야 합니다."),
    INVALID_LOTTO_PRICE("로또 구입 금액은 1,000원 단위로 입력하셔야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1에서 45 사이 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다. 당첨번호 %s");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
