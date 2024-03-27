package lotto.config;

import java.text.MessageFormat;

public enum LottoExceptionMessage {

    LOTTO_NUMBER_MUST_BE_IN_VALID_RANGE("로또 번호는 1이상 45이하의 자연수여야 합니다."),
    LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE("로또 번호는 지정된 개수보다 많거나 적을 수 없습니다."),
    LOTTO_QUANTITY_MUST_BE_POSITIVE("로또 구매 개수는 1이상의 자연수여야 합니다."),
    LOTTO_RANK_IS_NOT_FOUND("로또 번호 당첨 개수에 따른 순위가 존재하지 않습니다."),
    LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE("당첨 결과 로또의 개수와 실제 구매 로또의 개수가 일치하지 않습니다."),
    ;

    private final String message;

    LottoExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public <T> String message(final T value) {
        return MessageFormat.format("{0} [값 : {1}]", this.message, value);
    }
}
