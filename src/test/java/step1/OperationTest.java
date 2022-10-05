package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    static Stream<Arguments> castOperationParam() {
        return Stream.of(
                Arguments.arguments("+", Operation.ADD),
                Arguments.arguments("-", Operation.SUBTRACT),
                Arguments.arguments("*", Operation.MULTIPLY),
                Arguments.arguments("/", Operation.DIVIDE)
        );
    }

    @DisplayName("올바른 연산자 문자열을 받아서 변환에 성공케이스")
    @ParameterizedTest(name = "{displayName} {index} 변환할문자열: {0}")
    @MethodSource("castOperationParam")
    void castOperation(String input, Operation expectedOperation) {
        Operation operation = Operation.castOperation(input);
        assertThat(operation).isEqualTo(expectedOperation);
    }

    @DisplayName("정해진 값 이외의 문자열을 받은 경우 IllegalArgumentException 발생")
    @Test
    void castOperation() {
        Throwable thrown = catchThrowable(() -> Operation.castOperation("="));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> workParam() {
        return Stream.of(
                Arguments.arguments(Operation.ADD, 3, 6, 9),
                Arguments.arguments(Operation.SUBTRACT, 10, 3, 7),
                Arguments.arguments(Operation.MULTIPLY, 3, 2, 6),
                Arguments.arguments(Operation.DIVIDE, -10, 2, -5)
        );
    }

    @DisplayName("Operation에 정의된 연산함수 성공케이스")
    @ParameterizedTest(name = "{displayName} {index} 연산자: {0}")
    @MethodSource("workParam")
    void work(Operation operation, int operand1, int operand2, int expect) {
        assertThat(operation.work(operand1, operand2)).isEqualTo(expect);
    }

}