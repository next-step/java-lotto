package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    @DisplayName("주어진 Number list의 합을 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("sumParameter")
    void sumTest(Numbers numbers, int expected) {
        assertThat(numbers.sum()).isEqualTo(expected);
    }

    private static Stream<Arguments> sumParameter() {
        return Stream.of(Arguments.of(new Numbers(Arrays.asList(new Number(1), new Number(2), new Number(3))), 6),
                         Arguments.of(new Numbers(Arrays.asList(new Number(9), new Number(2), new Number(3))), 14));
    }
}
