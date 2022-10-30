package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void 생성자_벨리데이션_실패(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator(str);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "2 + 3 * 4 & 2", "2 @ 3 * 4 / 2", "2 + 3 % 4 / 2 ^ 5", "2 $ 3"})
    public void 잘못된_사칙연산기호_실패(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator(str);
            calculator.calculate();
        });
    }

    @ParameterizedTest
    @MethodSource("calculateParams")
    public void calculate_성공(String str, int expectedResult) {
        StringCalculator calculator = new StringCalculator(str);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> calculateParams() {
        return Stream.of(
            Arguments.of("2 + 3 * 4 / 2", 10),
            Arguments.of("5 - 6 * 4", -4),
            Arguments.of("2 + 3 + 4 / 2 / 5", 0),
            Arguments.of("2 + 3", 5),
            Arguments.of("5 / 3 + 2 * 3", 9)
        );
    }
}
