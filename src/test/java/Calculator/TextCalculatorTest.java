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

    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    void manyNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//#\n1#2", "//@\n1@2"})
    void manyNumberUseSomeSeperator(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "ㄱㅈㅇ"})
    void TestRuntimeExcpetion(final String text) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add(text));
    }
}
