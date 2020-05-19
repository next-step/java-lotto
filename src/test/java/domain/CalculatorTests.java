package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTests {
    @DisplayName("숫자 콜렉션을 입력 받아서 전체 합산을 진행한다.")
    @ParameterizedTest
    @MethodSource("numberCollections")
    void sumTest(List<Integer> numbers, int expected) {
        int result = Calculator.sum(numbers);
        assertThat(expected).isEqualTo(result);
    }
    public static Stream<Arguments> numberCollections() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 15),
                Arguments.of(Arrays.asList(1, 2, 3, 4), 10),
                Arguments.of(Arrays.asList(1, 2, 3), 6)
        );
    }
}
