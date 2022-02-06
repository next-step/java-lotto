package stringcalculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Delimiters;

public class InputViewTest {

    private static final int PREFIX_LENGTH = 2;
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    @DisplayName("구분자를 입력받는다.")
    @ValueSource(strings = {"//s", "///", "//;", "//q"})
    @ParameterizedTest
    void getDelimiter(String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        input = input.substring(PREFIX_LENGTH);

        final Delimiters expected = new Delimiters(Arrays.asList(input));

        // when
        final Delimiters delimiters = InputView.getDelimiters();

        // then
        assertThat(delimiters).isEqualTo(expected);
    }

    @DisplayName("구분자 입력을 생략한다.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void getDelimiter_구분자_없음(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        final Delimiters expected = new Delimiters(
            Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));

        // when
        final Delimiters delimiters = InputView.getDelimiters();

        // then
        assertThat(delimiters).isEqualTo(expected);
    }

    @DisplayName("잘못된 Prefix ")
    @ValueSource(strings = {",", "/a", "::", "a//"})
    @ParameterizedTest
    void getDelimiter_잘못된_Prefix(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // then
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
            () -> InputView.getDelimiters());
    }

    @DisplayName("식을 입력 - 공백 입력.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void getExpression_공백_입력(final String input) {
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        final String result = InputView.getExpression();

        // then
        assertThat(result).isEqualTo("0");
    }
}
