package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionValidatorTest {

    @Test
    @DisplayName("빈 입력값에 대해 exception 발생")
    public void 빈_입력값_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("      ");
        });
        assertThatCode(() -> {
            ExpressionValidator.validate("abc");
        }).doesNotThrowAnyException();
        assertThatCode(() -> {
            ExpressionValidator.validate("  _ ");
        }).doesNotThrowAnyException();
    }
}
