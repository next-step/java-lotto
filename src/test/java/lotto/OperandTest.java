package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperandTest {
    @Test
    void whenOperandValueIsNegative() {
        assertThatThrownBy(() -> new Operand(negativeValue()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @MethodSource("notNumericValues")
    void whenOperandValueIsNotNumeric(String value) {
        assertThatThrownBy(() -> new Operand(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        int value = validValue();
        assertThat(new Operand(value)).isEqualTo(new Operand(value));
    }

    private int negativeValue() {
        return Math.negateExact(validValue());
    }

    private int validValue() {
        return Math.abs(new Random().nextInt());
    }

    static Stream<Arguments> notNumericValues() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("*"),
                Arguments.of("?")
        );
    }
}
