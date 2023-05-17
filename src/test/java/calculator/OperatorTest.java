package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest
    @MethodSource("calculateTest_Arguments")
    void calculateTest(Operator operator, double number1, double number2, double expect) {
        var actual = operator.calculate(number1, number2);

        assertThat(actual).isEqualTo(expect);
    }

    public static Stream<Arguments> calculateTest_Arguments() {
        return Stream.of(
                Arguments.of(Operator.PLUS, 8, 3, 11),
                Arguments.of(Operator.MINUS, 8, 3, 5),
                Arguments.of(Operator.MULTIPLE, 8, 3, 24),
                Arguments.of(Operator.DIVIDE, 8, 3, 2.6666666666666665)
        );
    }

    @ParameterizedTest
    @MethodSource("parsTest_Success_Arguments")
    void parsTest_Success(String operatorInput, Operator expect) {
        var actual = Operator.pars(operatorInput);

        assertThat(actual).isEqualTo(expect);
    }

    public static Stream<Arguments> parsTest_Success_Arguments() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLE),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @ParameterizedTest
    @MethodSource("parsTest_Failure_Arguments")
    void parsTest_Failure(String operatorInput, Exception expect) {
        assertThatThrownBy(() -> Operator.pars(operatorInput))
                .isInstanceOf(expect.getClass());
    }

    public static Stream<Arguments> parsTest_Failure_Arguments() {
        return Stream.of(
                Arguments.of("1", new IllegalArgumentException()),
                Arguments.of("a", new IllegalArgumentException()),
                Arguments.of("B", new IllegalArgumentException()),
                Arguments.of("!", new IllegalArgumentException()),
                Arguments.of("안", new IllegalArgumentException())
        );
    }
}
