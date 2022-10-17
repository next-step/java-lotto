package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2"})
    void testAddWith2Ints(String input){
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("세개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2 + 3"})
    void testAddWith3Ints(String input){
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 - 2"})
    void testMinusWith2Ints(String input){
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("세개의 정수를 가진 문자열에 +, -가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2 - 3"})
    void testMinusWith3Ints(String input){
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }
}
