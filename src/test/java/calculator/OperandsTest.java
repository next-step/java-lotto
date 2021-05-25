package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {

    @ParameterizedTest
    @MethodSource("generateSumArguments")
    @DisplayName("입력받은 숫자들의 합을 구한다.")
    void sum_test(int expectedAnswer, List<Integer> input) {
        //given
        Operands operands = new Operands(input);

        //when
        int sum = operands.sum();

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }

    static Stream<Arguments> generateSumArguments() {
        return Stream.of(
                generateSumArgument(15, 5, 10),
                generateSumArgument(14, 0, 10, 4),
                generateSumArgument(0, 0)
        );
    }

    private static Arguments generateSumArgument(int expectedAnswer, Integer...input) {
        return Arguments.of(expectedAnswer, List.of(input));
    }
}
