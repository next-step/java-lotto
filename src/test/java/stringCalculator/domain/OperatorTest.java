package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"*", "/", "+", "-"})
    void create(String validOperator) {
        Operator operator = new Operator(validOperator);

        assertThat(operator.getOperator()).isEqualTo(validOperator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "i", "a", "z"})
    @DisplayName("사칙연산 기호가 아니면 예외가 발생한다.")
    void throwExceptionForInvalidValue(String invalidOperator) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operator(invalidOperator);
        });

    }
}
