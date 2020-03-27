package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringPlusCalculatorTest {

    @Test
    @DisplayName("빈 문자열을 또는 null 을 넣으면 0 이 나와야 한다.")
    public void calculateTest() {
        assertThat(StringPlusCalculator.calculate(""))
                .isEqualTo(0);

        assertThat(StringPlusCalculator.calculate(null))
                .isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1","2=2","3=3"}, delimiter = '=')
    @DisplayName("숫지 하나를 입력하면 해당 숫자가 나온다.")
    public void calculateOneNumberTest(String input, int number) {
        assertThat(StringPlusCalculator.calculate(input))
                .isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6"}, delimiter = '=')
    @DisplayName("쉼표를 기준으로 분리한 숫자를 더한값이 나와야 한다.")
    public void calculateCommaTokenizedTest(String input, int result) {
        assertThat(StringPlusCalculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3=6", "1,2:3=6"}, delimiter = '=')
    @DisplayName("쉼표 또는 콜론 기준으로 분리한 숫자를 더한값이 나와야 한다.")
    public void calculateCommaOrColonTokenizedTest(String input, int result) {
        assertThat(StringPlusCalculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6", "// \\n1 2 3=6"}, delimiter = '=')
    @DisplayName("커스텀 구분자를 기준으로 분리한 숫자를 더한값이 나와야 한다.")
    public void calculateCustomTokenizedTest(String input, int result) {
        assertThat(StringPlusCalculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "2,t,3"})
    @DisplayName("음수 또는 숫자 의외의 값을 전달하면 RuntimeException 예외가 발생해야 한다.")
    public void negativeSumExceptionTest(String input) {
        assertThatThrownBy(() -> StringPlusCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }
}
