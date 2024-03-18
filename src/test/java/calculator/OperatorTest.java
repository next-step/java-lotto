package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "3:5:8", "10:25:35", "220:531:751"}, delimiter = ':')
    @DisplayName("Operator.PLUS의 calculate 호출 시 덧셈 결과 반환")
    void calculate_plus(int augend, int addend, int expected) {
        assertThat(Operator.PLUS.calculate(augend, addend)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:2:3", "3:5:-2", "50:25:25", "531:111:420"}, delimiter = ':')
    @DisplayName("Operator.MINUS의 calculate 호출 시 뺄셈 결과 반환")
    void calculate_minus(int augend, int addend, int expected) {
        assertThat(Operator.MINUS.calculate(augend, addend)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:2", "10:5:2", "150:5:30", "168:8:21"}, delimiter = ':')
    @DisplayName("Operator.DIVIDE의 calculate 호출 시 나눗셈 결과 반환")
    void calculate_divide(int augend, int addend, int expected) {
        assertThat(Operator.DIVIDE.calculate(augend, addend)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:8", "10:5:50", "150:5:750", "168:8:1344"}, delimiter = ':')
    @DisplayName("Operator.MULTIPLY의 calculate 호출 시 곱셈 결과 반환")
    void calculate_multiply(int augend, int addend, int expected) {
        assertThat(Operator.MULTIPLY.calculate(augend, addend)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("operatorStringAndOperatorEnum")
    @DisplayName("findOperationByValue의 매개변수 연산자(*,/,+,-)에 따라 해당하는 Operator 반환")
    void findOperationByValue_success(String operatorStr, Operator operatorEnum) {
        assertThat(Operator.findOperationByValue(operatorStr)).isEqualTo(operatorEnum);
    }

    static Stream<Arguments> operatorStringAndOperatorEnum() {
        return Stream.of(
                Arguments.arguments("*", Operator.MULTIPLY),
                Arguments.arguments("/", Operator.DIVIDE),
                Arguments.arguments("+", Operator.PLUS),
                Arguments.arguments("-", Operator.MINUS)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", ",", "]", "q"})
    @DisplayName("findOperationByValue의 매개변수가 연산자(*,/,+,-)가 아닌 경우 IllegalArgumentException")
    void findOperationByValue_illegalArgumentException(String input) {
        assertThatThrownBy(() -> Operator.findOperationByValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}