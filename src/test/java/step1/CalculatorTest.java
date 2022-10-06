package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Stream<Arguments> oneOperationParam() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of(Operation.ADD)), new ArrayList<>(List.of(4, 7)), 11),
                Arguments.arguments(new ArrayList<>(List.of(Operation.SUBTRACT)), new ArrayList<>(List.of(4, 7)), -3),
                Arguments.arguments(new ArrayList<>(List.of(Operation.MULTIPLY)), new ArrayList<>(List.of(4, 7)), 28),
                Arguments.arguments(new ArrayList<>(List.of(Operation.DIVIDE)), new ArrayList<>(List.of(10, 7)), 1)
        );
    }

    @DisplayName("연산자를 한개만 사용한경우 성공케이스")
    @ParameterizedTest(name = "{displayName} {index} 연산자: {0} |연산대상: {1}")
    @MethodSource("oneOperationParam")
    void getResultByOneOperation(List<Operation> operations, List<Integer> operands, int expected) {
        Calculator calculator = new Calculator(operations, operands);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(expected);
    }


    static Stream<Arguments> multiOperationParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(List.of(Operation.SUBTRACT, Operation.MULTIPLY)),
                        new ArrayList<>(List.of(14, 7, 3)),
                        21),
                Arguments.arguments(
                        new ArrayList<>(List.of(Operation.DIVIDE, Operation.ADD)),
                        new ArrayList<>(List.of(14, 7, 3)),
                        5),
                Arguments.arguments(
                        new ArrayList<>(List.of(Operation.SUBTRACT, Operation.DIVIDE, Operation.ADD, Operation.MULTIPLY)),
                        new ArrayList<>(List.of(3, 7, 2, -5, 3)),
                        -21)
        );
    }

    @DisplayName("연산자를 두개 이상 사용한경우 성공케이스")
    @ParameterizedTest(name = "{displayName} {index} 연산자: {0} |연산대상: {1}")
    @MethodSource("multiOperationParam")
    void getResultByMultiOperations(List<Operation> operations, List<Integer> operands, int expected) {
        Calculator calculator = new Calculator(operations, operands);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(expected);
    }

}