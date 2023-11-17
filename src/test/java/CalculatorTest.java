import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalculatorTest {


    @Test
    @DisplayName("계산식 테스트")
    void calculator_테스트() {
        String text = "2 + 3 * 4 / 2";
        Calculator calcu = new Calculator();
        assertThat(calcu.calculate(text)).isEqualTo(10);
    }


    @Test
    @DisplayName("공백으로 문자열 나누기")
    void splite_공백() {
        String text = "2 + 3 * 4 / 2";
        assertThat(Calculator.splitText(text).length).isEqualTo(7);
    }

    @Test
    @DisplayName("연산자만 필터")
    void filter_Ops() {
        String[] text = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(Calculator.filterOps(text)).contains("+");
        assertThat(Calculator.filterOps(text)).contains("*");
        assertThat(Calculator.filterOps(text)).contains("/");
    }

    @Test
    @DisplayName("숫자만 필터")
    void filter_Number() {
        String[] text = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(Calculator.filterValue(text)).contains(2);
        assertThat(Calculator.filterValue(text)).contains(3);
        assertThat(Calculator.filterValue(text)).contains(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {

        assertTrue(Calculator.isBlank(input));
    }

    @Test
    @DisplayName("더하기: add")
    void add_더하기() {
        Operation.Operator operator = Operation.Operator.fromString("+");
        assertThat(operator.apply(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기: subtract")
    void subtract_빼기() {
        Operation.Operator operator = Operation.Operator.fromString("-");
        assertThat(operator.apply(2, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기: multiply")
    void multiply_곱하기() {
        Operation.Operator operator = Operation.Operator.fromString("*");
        assertThat(operator.apply(2, 2)).isEqualTo(4);
    }

    @Test
    @DisplayName("정수로 떨어지는 나누기: divide")
    void divide_정수() {
        Operation.Operator operator = Operation.Operator.fromString("/");
        assertThat(operator.apply(2, 2)).isEqualTo(1);
    }

}
