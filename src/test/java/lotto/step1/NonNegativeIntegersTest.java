package lotto.step1;

import lotto.step1.model.NonNegativeInteger;
import lotto.step1.model.NonNegativeIntegers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NonNegativeIntegersTest {
    @ParameterizedTest(name = "sumTest")
    @MethodSource("stringArrayProvider")
    public void sumTest(String[] array, String result) {
        NonNegativeIntegers nonNegativeIntegers = new NonNegativeIntegers(array);
        assertThat(new NonNegativeInteger(result)).isEqualTo(nonNegativeIntegers.sum());
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"5", "7", "34"},"46"),
                Arguments.of((Object) new String[]{"25", "11", "2"}, "38")
        );
    }
}
