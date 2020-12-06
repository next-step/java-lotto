package lotto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.LottoMachine;

public final class WinningNumbersValidator extends Validator {

    static final String NOT_NUMBER_OR_COMMA_MESSAGE = "숫자,콤마, 공백만 입력할 수 있습니다!";

    static final String SIZE_NOT_MATCH = "입력한 숫자가 6개보다 많습니다. 콤마의 개수를 확인해주세요!";

    private static final Pattern NUMBER_AND_COMMA_PATTERN = Pattern.compile("([0-9]?,?)+");

    @Override
    protected void validate(final String input) {
        super.validate(input);
        checkNumberAndComma(input);
        checkSize(input);
    }

    private void checkNumberAndComma(final String input) {
        Matcher matcher = NUMBER_AND_COMMA_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_COMMA_MESSAGE);
        }
    }

    private void checkSize(final String input) {
        if (input.split(InputView.DELIMITER).length != LottoMachine.LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_NOT_MATCH);
        }
    }
}
