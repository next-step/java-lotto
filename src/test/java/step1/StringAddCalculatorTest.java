package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step1.StringAddCalculator.*;

/**
 * <pre>
 * * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 * </pre>
 */
public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @DisplayName("널을 입력받으면 예외가 발생한다.")
    @Test
    void nullInput() {
        assertThatThrownBy(() -> calculator.calculate(null)) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage(PLEASE_ENTER_A_STRING);
    }

    @DisplayName("empty string 을 입력하면 0 을 반환한다.")
    @Test
    void emptyString() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @DisplayName("숫자를 입력하면 그 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "9999,9999"})
    void oneNumber(String stringType, Long longType) {
        assertThat(calculator.calculate(stringType)).isEqualTo(longType);
    }

    @DisplayName("숫자 이외의 값을 입력하면 RuntimeException 을 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"A", "가"})
    void noNumericStrings(String noNumeric) {
        assertThatThrownBy(() -> calculator.calculate(noNumeric)) //
                .isInstanceOf(RuntimeException.class) //
                .hasMessage(NOT_A_STRING_OF_NUMERIC, noNumeric);
    }

    @DisplayName("음수를 입력하면 RuntimeException 을 방샐한다.")
    @Test
    void negativeNumericString() {
        assertThatThrownBy(() -> calculator.calculate("-1")) //
                .isInstanceOf(RuntimeException.class) //
                .hasMessage(String.format(CANNOT_ACCEPT_A_NEGATIVE_NUMBER, -1));
    }

    @DisplayName("콤마와 콜론을 기준으로 더한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2:3=6"}, delimiter = '=')
    void addWithCommaOrColon(String formula, Long result) {
        assertThat(calculator.calculate(formula)).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 입력 받을 수 있다")
    @Test
    void acceptCustomDelimiter() {
        assertThat(calculator.calculate("//;\n1,1")).isEqualTo(2L);
    }

    @DisplayName("커스텀 구분자를 통해 덧셈이 가능하다")
    @Test
    void addWithCustomDelimiter() {
        assertThat(calculator.calculate("//;\n1;1")).isEqualTo(2L);
    }
}
