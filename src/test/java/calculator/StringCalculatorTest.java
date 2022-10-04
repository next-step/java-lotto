package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void testNullOrEmptyInput(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.getOperations(text));
    }

    @ParameterizedTest
    @MethodSource("getTextArguments")
    void testCalculate(String text, int expected) {
        List<String> operations = StringCalculator.getOperations(text);
        int result = StringCalculator.calculate(operations);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> getTextArguments() {
        return Stream.of(
            Arguments.of("3 + 5", 8),
            Arguments.of("5 - 3", 2),
            Arguments.of("3 * 5", 15),
            Arguments.of("6 / 3", 2),
            Arguments.of("2 + 3 * 4 / 2 - 5", 5)
        );
    }
}
