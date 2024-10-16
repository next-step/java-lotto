package lotto.constant;

public enum ErrorMessage {
    NEED_DISTINCT_SIX_NUMBERS("공백이 아닌 중복되지 않는 6개 숫자를 입력해야 합니다."),
    INVALID_LOTTO_PRICE("로또 구입 금액은 1,000원 단위로 입력하셔야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1에서 45 사이 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다. 당첨번호 %s"),
    INVALID_MANUAL_COUNT("수동 로또 구매 개수는 로또 판매 개수 이상일 수 없습니다."),
    INVALID_MANUAL_LOTTO("수동 로또는 1개 이상 입력되어야 합니다."),
    INVALID_LOTTO_INTEGRATION("로또 간 병합을 위해서는 1개 이상의 로또 번들이 필요합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
