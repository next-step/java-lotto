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

    @DisplayName("구분자를 입력받는다.")
    @ValueSource(strings = {"//s", "///", "//;", "//q"})
    @ParameterizedTest
    void getDelimiter(String input) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        input = input.substring(InputView.PREFIX_LENGTH);

        Delimiters expected = new Delimiters(Arrays.asList(input));

        // when
        Delimiters delimiters = InputView.getDelimiters();

        // then
        assertThat(delimiters).isEqualTo(expected);
    }

    @DisplayName("구분자 입력을 생략한다.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void getDelimiter_구분자_없음(String input) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Delimiters expected = new Delimiters(Arrays.asList(InputView.DEFAULT_DELIMITER_COMMA,
                InputView.DEFAULT_DELIMITER_COLON));

        // when
        Delimiters delimiters = InputView.getDelimiters();

        // then
        assertThat(delimiters).isEqualTo(expected);
    }

    @DisplayName("잘못된 Prefix ")
    @ValueSource(strings = {",", "/a", "::", "a//"})
    @ParameterizedTest
    void getDelimiter_잘못된_Prefix(String input) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // then
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> InputView.getDelimiters());
    }

    @DisplayName("식을 입력 받는다")
    @Test
    void getExpression() {
        String expected = "1;2;3";
        InputStream inputStream = new ByteArrayInputStream(expected.getBytes());
        System.setIn(inputStream);

        // when
        String result = InputView.getExpression();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("식을 입력 - 공백 입력.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void getExpression_공백_입력(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String result = InputView.getExpression();

        // then
        assertThat(result).isEqualTo("0");
    }
}
