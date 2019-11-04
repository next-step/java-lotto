package calc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    void 빈문자열_null_입력시_0을_반환테스트() {
        assertThat(calculator.add(null)).isEqualTo(0);
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 숫자_하나를_문자열로_입력하면_해당_숫자를_반환테스트(String input) {
        assertThat(calculator.add(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7", "1,3:4", "100,10:110"}, delimiter = ':')
    void 숫자_두개를_컴마_구분자로_입력하면_두_숫자의_합을_반환테스트(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2;3", "3:4;7", "1:3;4", "100:10;110"}, delimiter = ';')
    void 숫자_두개를_콜론_구분자로_입력하면_두_숫자의_합을_반환테스트(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2;3", "3,4:1;8", "1:3,1;5", "1,100:10;111"}, delimiter = ';')
    void 숫자_두개를_컴마콜론_구분자로_입력하면_두_숫자의_합을_반환테스트(String input, int result) {
        assertThat(calculator.add(input)).isEqualTo(result);
    }

    @Test
    void 커스텀_구분자로_입력해도_두_숫자의_합을_반환테스트() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
    }
}
