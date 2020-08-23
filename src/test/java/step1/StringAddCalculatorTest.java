package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @Test
    @DisplayName("값이 유효하지 않으면 0 return")
    void empty_null_return0() {
        stringAddCalculator = new StringAddCalculator("");
        assertThat(stringAddCalculator.startAddCalculation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "1", "8"})
    @DisplayName("숫자 한개 입력시 그대로 return")
    void 숫자_그대로_자반환(String expression) {
        stringAddCalculator = new StringAddCalculator(expression);
        assertThat(stringAddCalculator.startAddCalculation()).isEqualTo(Integer.parseInt(expression));
        
    }

    @ParameterizedTest
    @DisplayName("콤마,콜론 덧셈 결과")
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1,2:3=6", "//;\\n1;2;3=6"}, delimiter = '=')
    void result_sum(String expression, int expectResult) {
        stringAddCalculator = new StringAddCalculator(expression);

        assertThat(stringAddCalculator.startAddCalculation()).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("음수 입력시 Exception")
    void toInt() {
        String expression = "-1,3,5";
        stringAddCalculator = new StringAddCalculator(expression);

        assertThatThrownBy(() -> stringAddCalculator.startAddCalculation()).isInstanceOf(IllegalArgumentException.class);
    }
}
