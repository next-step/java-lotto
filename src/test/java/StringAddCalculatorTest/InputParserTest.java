package StringAddCalculatorTest;

import StringAddCalculator.InputParser;
import StringAddCalculator.Operand;
import StringAddCalculator.Operands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    InputParser inputParser;

    @BeforeEach
    void initInputParser() {
    }

    @ParameterizedTest
    @MethodSource("provideInputString")
    void Given_Inputs_When_GetOperands_Then_ReturnsExpected(String input, Operands expected) {
        //given
        inputParser = new InputParser(input);

        //when
        Operands actual = inputParser.getOperands();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputString() {
        return Stream.of(
                Arguments.of("1,2", new Operands(new String[]{"1", "2"})),
                Arguments.of("1,2,3", new Operands(new String[]{"1", "2", "3"})),
                Arguments.of("//:\n1:2", new Operands(new String[]{"1", "2"})),
                Arguments.of("//@\n1@2", new Operands(new String[]{"1", "2"})),
                Arguments.of("//@\n1@2@3", new Operands(new String[]{"1", "2", "3"})),
                Arguments.of("//@\n1@2@3@4@5", new Operands(new String[]{"1", "2", "3", "4", "5"}))
        );
    }

    @Test
    void Given_Empty_When_GetOperands_Then_OperandsWith0() {
        //given
        inputParser = new InputParser("");

        //when
        Operands actual = inputParser.getOperands();

        //then
        assertThat(actual).isEqualTo(new Operands(new String[]{"0"}));
    }

    @Test
    void Given_Null_When_GetOperands_Then_OperandsWith0() {
        //given
        inputParser = new InputParser(null);

        //when
        Operands actual = inputParser.getOperands();

        //then
        assertThat(actual).isEqualTo(new Operands(new String[]{"0"}));
    }


    @ParameterizedTest
    @MethodSource("provideInvalidInput")
    void Given_InvalidInput_When_New_Then_RuntimeException(String input) {
        assertThatThrownBy(() -> new InputParser(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideInvalidInput() {
        return Stream.of(
                Arguments.of("A,B,C"),
                Arguments.of("//,\n1:2:3"),
                Arguments.of("//,\t1:2:3"),
                Arguments.of("//,\na,b")
        );
    }
}
