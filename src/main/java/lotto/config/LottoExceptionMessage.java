package lotto.config;

import java.text.MessageFormat;

public enum LottoExceptionMessage {

    LOTTO_NUMBER_SHOULD_BE_IN_VALID_RANGE("로또 번호는 1이상 45이하의 자연수여야 합니다.");

    private final String message;

    LottoExceptionMessage(final String message) {
        this.message = message;
    }

    public <T> String message(final T value) {
        return MessageFormat.format("{0} [값 : {1}]", this.message, value);
    }
}
