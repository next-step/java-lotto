import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException 예외를 던진다.")
    @NullAndEmptySource
    @ParameterizedTest
    void input_null_of_empty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 예외를 던진다. ")
    @Test
    void invalid_operator() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("1 & 2"));
    }

    @DisplayName("연산 결과를 반환한다.")
    @MethodSource("calculateData")
    @ParameterizedTest
    void plus_success(String calculationFormula, Integer result) {
        assertThat(Calculator.calculate(calculationFormula)).isEqualTo(result);
    }

    private static Stream<Arguments> calculateData() {
        return Stream.of(
          Arguments.of("1 + 2", 3),
          Arguments.of("1 - 2", -1),
          Arguments.of("2 * 3", 6),
          Arguments.of("4 / 2", 2),
          Arguments.of("3 / 2", 1),
          Arguments.of("2 + 3 * 4 / 2", 10)
        );
    }
}
