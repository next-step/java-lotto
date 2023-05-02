package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("수식 연산 테스트")
    @ParameterizedTest
    @MethodSource("sampleParams")
    public void 수식_연산(List<Integer> numbers, List<Operator> operators, int result) throws Exception {
        assertThat(stringCalculator.calculate(new Numbers(numbers), new Operations(operators))).isEqualTo(result);
    }

    static Stream<Arguments> sampleParams() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(Operator.toOperation("+")), 3),
                Arguments.of(Arrays.asList(3, 6), Arrays.asList(Operator.toOperation("+")), 9)
        );
    }

    @DisplayName("둘 이상의 연산자 계산 테스트")
    @ParameterizedTest
    @MethodSource("operationMoreThanTwo")
    public void 둘_이상의_연산자_계산_테스트(List<Integer> numbers, List<Operator> operators, int result) throws Exception {
        stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(new Numbers(numbers), new Operations(operators))).isEqualTo(result);
    }

    static Stream<Arguments> operationMoreThanTwo() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)
                        , Arrays.asList(Operator.PLUS, Operator.PLUS, Operator.PLUS, Operator.PLUS), 15),
                Arguments.of(Arrays.asList(3, 6, 7, 3)
                        , Arrays.asList(Operator.PLUS, Operator.SUBTRACT, Operator.MULTIPLY), 6),
                Arguments.of(Arrays.asList(123, 9, 3, 2)
                        , Arrays.asList(Operator.SUBTRACT, Operator.SUBTRACT, Operator.SUBTRACT), 109),
                Arguments.of(Arrays.asList(36, 6, 5, 3)
                        , Arrays.asList(Operator.DIVIDE, Operator.SUBTRACT, Operator.PLUS), 4),
                Arguments.of(Arrays.asList(84, 12, 75, 9)
                        , Arrays.asList(Operator.DIVIDE, Operator.SUBTRACT, Operator.PLUS), -59)
        );
    }
}

