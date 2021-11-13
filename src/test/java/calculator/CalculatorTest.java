package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("입력값이 null이나 비어있다면 0을 반환한다.")
    @ParameterizedTest(name = "[{index}] {0} = 0")
    @NullAndEmptySource
    void calculate_emptyInput(String expression) {
        int resultNum = Calculator.calculate(expression);

        assertThat(resultNum).isEqualTo(Calculator.DEFAULT_RESULT);
    }

    @DisplayName("입력값이 하나면 그대로 반환한다.")
    @ParameterizedTest(name = "[{index}] {0} = {0}")
    @ValueSource(ints = {1, 100, 1000})
    void calculate_OneNumber(int number) {
        //given
        String StringNum = String.valueOf(number);

        //when
        int resultNum = Calculator.calculate(StringNum);

        //then
        assertThat(resultNum).isEqualTo(number);
    }

}
