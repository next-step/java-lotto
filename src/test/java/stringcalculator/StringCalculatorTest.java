package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private static final int INT_SIX = 6;
    private static final int INT_ZERO = 0;

    @DisplayName("문자열 계산기 정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void calculate(String expression, int expected) {
        StringCalculator stringCalculator = new StringCalculator();

        int actual = stringCalculator.calculate(expression);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName(" “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3", "//-\n1-2-3"})
    void customDelimiterCalculate(String expression) {
        StringCalculator stringCalculator = new StringCalculator();

        int actual = stringCalculator.calculate(expression);

        assertThat(actual).isEqualTo(INT_SIX);
    }

    @DisplayName("빈 문자열 또는 null값 입력 시 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateFailByNullAndEmptyString(String expression) {
        StringCalculator stringCalculator = new StringCalculator();

        int actual = stringCalculator.calculate(expression);

        assertThat(actual).isEqualTo(INT_ZERO);
    }

    @DisplayName("숫자 이외의 값이 전달 될 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,adf,2", "adb,1"})
    void calculateFailByInvalidString(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator().calculate(expression));
    }

    @DisplayName("음수를 전달하는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,-1", "-1,2"})
    void calculateFailByNegative(String expression) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new StringCalculator().calculate(expression));
    }
}
