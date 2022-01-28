package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @Test
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환해야_한다(final String text) {
        assertThat(calculator.add(text)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @Test
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    @Test
    void 숫자_두개를_쉼표구분자로_입력할경우_두숫자의_합을_반환한다(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    @Test
    void 구분자를_쉼표_이외에_콜론을_사용할_수_있다(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    @Test
    void customDelimiter(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void negative() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.add("-1"));
    }
}