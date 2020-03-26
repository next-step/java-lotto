package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("문자열 계산기 정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void calculate(String expression, int expected) {
        StringCalculator stringCalculator = new StringCalculator();

        int actual = stringCalculator.calculate(expression);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("빈 문자열 또는 null값 입력 시 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateFailByNullAndEmptyString(String expression) {
        StringCalculator stringCalculator = new StringCalculator();

        int actual = stringCalculator.calculate(expression);

        assertThat(actual).isEqualTo(0);
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
        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator().calculate(expression));
    }
}
