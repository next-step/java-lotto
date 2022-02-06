package stringcalculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private static final int PREFIX_LENGTH = 2;

    @DisplayName("구분자를 입력받는다. prefix를 제거.")
    @ValueSource(strings = {"//s", "///", "//;", "//q"})
    @ParameterizedTest
    void getDelimiter(String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        final String delimiters = InputView.inputDelimiter();

        // then
        assertThat(delimiters).isEqualTo(input.substring(PREFIX_LENGTH));
    }

    @DisplayName("구분자 입력을 생략한다. 그대로 반환.")
    @ValueSource(strings = {" ", "   ", "\t"})
    @ParameterizedTest
    void getDelimiter_구분자_없음(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String delimiters = InputView.inputDelimiter();

        // then
        assertThat(delimiters).isEqualTo(input);
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
                () -> InputView.inputDelimiter());
    }

    @DisplayName("식을 입력 - 공백 입력.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void getExpression_공백_입력(final String input) {
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        final String result = InputView.inputExpression();

        // then
        assertThat(result).isEqualTo("0");
    }
}
