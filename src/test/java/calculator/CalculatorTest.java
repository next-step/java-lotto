package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-20
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void add_공백_또는_null_입력시_0반환(String input) {
        assertThat(calculator.add(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "100", "0"})
    void add_숫자_하나를_문자열로_입력할경우_해당숫자를_반환(String input) {
        int expected = Integer.valueOf(input);

        assertThat(calculator.add(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1,2:3", "2,3:5", "0,1:1"},
            delimiter = ':')
    void add_콤마구분자(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1,2:3=6", "2,3:5=10", "0,1:1=2"},
            delimiter = '=')
    void add_콤마_또는_콜론_구분자(String input, int expected) {
        assertThat(calculator.add(input)).isEqualTo(expected);
    }


    // TODO “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.

    // TODO 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.
}
