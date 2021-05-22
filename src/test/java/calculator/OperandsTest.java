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
    @MethodSource("generateSumParameter")
    @DisplayName("입력받은 숫자들의 합을 구한다.")
    void sum_test(List<Integer> input, int expectedAnswer) {
        //given
        Operands operands = new Operands(input);

        //when
        int sum = operands.sum();

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }

    static Stream<Arguments> generateSumParameter() {
        return Stream.of(
                Arguments.of(List.of(5, 10), 15),
                Arguments.of(List.of(0, 10, 4), 14),
                Arguments.of(List.of(0), 0)
        );
    }
}
