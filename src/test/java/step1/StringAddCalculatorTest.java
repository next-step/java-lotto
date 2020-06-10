package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideSplitAndSunTestTestCase() {
        return Stream.of(
            Arguments.of(null, 0),
            Arguments.of("1", 1),
            Arguments.of("1,2", 3),
            Arguments.of("1,2:3", 6),
            Arguments.of("//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSplitAndSunTestTestCase")
    public void splitAndSunTest(String numberString, int expected) {
        assertThat(StringAddCalculator.splitAndSum(numberString)).isEqualTo(expected);
    }
}
