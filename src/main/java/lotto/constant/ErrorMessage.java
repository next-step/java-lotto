package lotto.constant;

public enum ErrorMessage {
    LOTTO_NUMBER_NUMERIC_ERROR("당첨 번호는 숫자만 입력할 수 있습니다."),
    LOTTO_NUMBER_LENGTH_ERROR("로또 번호의 길이는 여섯 자리입니다."),
    LOTTO_NUMBER_BOUND_ERROR("로또 번호의 범위는 1부터 45까지 입니다."),
    PURCHASE_SINGULAR_PRICE_ERROR("구매 금액 단위가 잘못되었습니다."),
    NEGATIVE_PURCHASE_PRICE_ERROR("구매 금액은 음수가 될 수 없습니다."),
    NOT_FOUND_PRODUCT("찾을 수 없는 상품명입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
