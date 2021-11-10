package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("입력값이 null이나 비어있다면 0을 반환한다.")
    @ParameterizedTest(name = "[{index}] 입력값이 [{0}] 이면 0을 반환한다.")
    @NullAndEmptySource
    void calculate_emptyInput(String stringNum) {
        int resultNum = Calculator.calculate(stringNum);

        assertThat(resultNum).isEqualTo(Calculator.DEFAULT_RESULT);
    }

}
