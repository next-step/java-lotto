package lotto.config;

import java.text.MessageFormat;
import java.util.Arrays;

public enum LottoExceptionMessage {

    LOTTO_NUMBER_MUST_BE_IN_VALID_RANGE("로또 번호는 1이상 45이하의 자연수여야 합니다."),
    LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE("로또 번호는 지정된 개수보다 많거나 적을 수 없습니다."),
    LOTTO_NUMBERS_MUST_NOT_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_QUANTITY_MUST_BE_POSITIVE("로또 구매 개수는 1이상의 자연수여야 합니다."),
    LOTTO_RANK_IS_NOT_FOUND("로또 번호 당첨 개수에 따른 순위가 존재하지 않습니다."),
    LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE("당첨 결과 로또의 개수와 실제 구매 로또의 개수가 일치하지 않습니다."),
    LOTTO_TOTAL_PRICE_MUST_BE_BIGGER_THAN_UNIT_PRICE("총 로또 구매 가격은 1개 당 가격보다 커야합니다."),
    LOTTO_TOTAL_PRICE_MUST_BE_MULTIPLE_OF_UNIT_PRICE("총 로또 구매 가격은 1개 당 가격의 배수여야 합니다."),

    INPUT_TOTAL_PRICE_MUST_FOLLOW_INTEGER_FORMAT("총 로또 구매 가격은 정수형으로 입력해야 합니다."),
    INPUT_WINNING_NUMBERS_MUST_EXIST("로또 당첨 번호는 null 이거나 빈 값일 수 없습니다."),
    INPUT_WINNING_NUMBERS_MUST_FOLLOW_PATTERN("로또 당첨 번호가 형식에 맞지 않습니다."),

    UNEXPECTED_EXCEPTION_MESSAGE("알 수 없는 예외가 발생했습니다."),
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

    public <T> String message(final T[] values) {
        return message(Arrays.toString(values));
    }
}
