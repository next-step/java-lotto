package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {

    @ParameterizedTest
    @MethodSource("stringToOperation")
    void 연산자_검색(String operationValue, Operation operation) {
        assertThat(Operation.from(operationValue)).isEqualTo(operation);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 4 + 9", "5 4 - 1", "3 4 / 0", "4 4 * 16"}, delimiter = ' ')
    void 연산자_계산(int operand1, int operand2, String operationValue, int result) {
        Operation operation = Operation.from(operationValue);
        assertThat(operation.apply(operand1, operand2)).isEqualTo(result);
    }

    static Stream<Arguments> stringToOperation() {
        return Stream.of(
                Arguments.arguments("+", Operation.PLUS),
                Arguments.arguments("-", Operation.SUBTRACT),
                Arguments.arguments("/", Operation.DIVIDE),
                Arguments.arguments("*", Operation.MULTIPLY));
    }
}
