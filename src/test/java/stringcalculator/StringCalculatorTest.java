package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    @MethodSource
    private static Stream<Arguments> providesCalculate() {
        return Stream.of(
                Arguments.of(new Number("6"), new Operator("+"), new Number("2"), new Number("8")),
                Arguments.of(new Number("6"), new Operator("-"), new Number("2"), new Number("4")),
                Arguments.of(new Number("6"), new Operator("*"), new Number("2"), new Number("12")),
                Arguments.of(new Number("6"), new Operator("/"), new Number("2"), new Number("3"))
        );
    }

    @ParameterizedTest
    @MethodSource("providesCalculate")
    void calculate(Number front, Operator operator, Number back, Number result) {
        Assertions.assertThat(StringCalculator.calculate(front, operator, back)).isEqualTo(result);
    }

}
