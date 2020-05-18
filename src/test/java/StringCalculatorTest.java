import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(String value) {
        assertThat(calculator.calculate(value)).isZero();
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 발생")
    @Test
    void negative() {
        assertThatThrownBy(() -> calculator.calculate("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName(value = "숫자 이외의 값을 전달할 경우 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = { "a,1", "//\\;\n1;a;3", "b", "*", "1:c,2", "1,^" })
    void notNumeric(String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(value));
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = { "1", "100000" })
    void oneNumber(final String value) {
        assertThat(calculator.calculate(value)).isEqualTo(Integer.parseInt(value));
    }

    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = { "1,2=3", "1,2,3=6", "10,100=110", "0,0=0" }, delimiter = '=')
    void twoNumbers(final String value, final int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }
}
