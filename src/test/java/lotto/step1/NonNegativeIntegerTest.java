package lotto.step1;

import lotto.step1.model.NonNegativeInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NonNegativeIntegerTest {

    @Test
    public void createTest() {
        assertThat(new NonNegativeInteger()).isEqualTo(new NonNegativeInteger("0"));
        assertThat(new NonNegativeInteger(7)).isEqualTo(new NonNegativeInteger("7"));
    }

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @ValueSource(strings = {"-1", "-3"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> new NonNegativeInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "sumTest")
    @MethodSource("stringArrayProvider")
    public void sumTest(String[] input) {
        NonNegativeInteger Integer1 = new NonNegativeInteger(input[0]);
        NonNegativeInteger Integer2 = new NonNegativeInteger(input[1]);
        NonNegativeInteger Integer3 = new NonNegativeInteger(input[2]);
        assertThat(new NonNegativeInteger(input[3])).isEqualTo(Integer1.sum(Integer2).sum(Integer3));
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"5", "7", "34", "46"}),
                Arguments.of((Object) new String[]{"25", "11", "2", "38"})
        );
    }

}
