package Calculator;

import Calculator.TextCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TextCalculatorTest {
    private TextCalculator calculator = new TextCalculator();

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName(value = "숫자 하나만 들어올 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "쉼표 또는 콜론을 구분자로 숫자가 들어온 경우 해당 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2","1:2"})
    void manyNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "//와 \\n 사이에 위치하는 문자가 들어온 경우 해당 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//#\n1#2", "//@\n1@2"})
    void manyNumberUseSomeSeperator(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }
}
