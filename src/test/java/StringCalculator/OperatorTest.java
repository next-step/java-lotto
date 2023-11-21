package StringCalculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {
    @DisplayName("정상적이지 않은 입력에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2  3", "1 +/ 2", "a + 2"})
    void validateOperator(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.from(input));
    }
}
