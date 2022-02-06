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

    @DisplayName("분자를 입력받아 prefix를 제거한다.")
    @ValueSource(strings = {"//s", "///", "//;", "//q"})
    @ParameterizedTest
    void Given_구분자_When_inputDelimiter_Then_Prefix_제거(String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        final String delimiters = InputView.inputDelimiter();

        // then
        assertThat(delimiters).isEqualTo(input.substring(PREFIX_LENGTH));
    }

    @DisplayName("구분자를 입력할 때 공백을 입력하면 그대로 반환한다.")
    @ValueSource(strings = {" ", "   ", "\t"})
    @ParameterizedTest
    void Given_공백_When_구분자_입력받기_Then_그대로_반환(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String delimiters = InputView.inputDelimiter();

        // then
        assertThat(delimiters).isEqualTo(input);
    }

    @DisplayName("구분자를 입력할 때 잘못된 Prefix를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {",", "/a", "::", "a//"})
    @ParameterizedTest
    void Given_잘못된_prefix_When_구분자_입력받기_Then_예외발생(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // then
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> InputView.inputDelimiter());
    }

    @DisplayName("식을 입력할 때 공백을 입력하면 0이 반환된다.")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @ParameterizedTest
    void Given_공백_When_식_입력받기_Then_0을_반환(final String input) {
        // given
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        final String result = InputView.inputExpression();

        // then
        assertThat(result).isEqualTo("0");
    }
}
