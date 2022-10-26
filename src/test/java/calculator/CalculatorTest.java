package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2"})
    void testAddWith2Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("세개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2 + 3"})
    void testAddWith3Ints(String input){
        int result = calculator.execute(input);

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 +가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 - 2"})
    void testMinusWith2Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("세개의 정수를 가진 문자열에 +, -가 있는 경우 덧셈 연산하는지 확인")
    @ValueSource(strings = {"1 + 2 - 3"})
    void testMinusWith3Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 *가 있는 경우 곱하기 연산하는지 확인")
    @ValueSource(strings = {"1 * 2"})
    void testMultiplyWith2Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("세개의 정수를 가진 문자열에 *, -가 있는 경우 곱하기 연산하는지 확인")
    @ValueSource(strings = {"1 * 2 - 3"})
    void testMultiplyWith3Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("두개의 정수를 가진 문자열에 /가 있는 경우 나누기 연산하는지 확인")
    @ValueSource(strings = {"3 / 1"})
    void testDivideWith2Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("네개의 정수를 가진 문자열에 *, -, /가 있는 경우 나누기 연산하는지 확인")
    @ValueSource(strings = {"1 * 2 / 2 - 1"})
    void testDivideWith3Ints(String input){
        int result = calculator.execute(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null 이 입력값인 경우 Exception 확인")
    void testNullInput(){
        assertThatThrownBy(() -> calculator.execute(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("input cannot be empty");
    }

    @ParameterizedTest
    @DisplayName("입력값이 공백인 경우 Exception 확인")
    @ValueSource(strings = {""})
    void testEmptyInput(String input){
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("input cannot be empty");
    }

    @ParameterizedTest
    @DisplayName("연산자 중 사친연산 기호가 아닌 경우")
    @ValueSource(strings = {"1 * 2 / 2 ! 1"})
    void testWrongOperator(String input){
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong operator type");
    }
}
