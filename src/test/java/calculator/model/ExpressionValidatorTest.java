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

    @Test
    @DisplayName("사칙연산 기호가 아닌 기호가 있는 경우 exception 발생 - 괄호 비허용")
    public void 사칙연산_기호_확인() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("(1+2)-3");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("1%3+1");
        });
        assertThatCode(() -> {
            ExpressionValidator.validate("1+2-3");
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사칙연산 기호가 연속해서 있는 경우 exception 발생")
    public void 사칙연산_연속_확인() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("1++3+1");
        });
        assertThatCode(() -> {
            ExpressionValidator.validate("1+2-3");
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사칙연산 기호로 시작하거나 끝나는 경우 exception 발생")
    public void 가장자리_연산자_확인() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("+1+3+1-");
        });
        assertThatCode(() -> {
            ExpressionValidator.validate("1+2-3");
        }).doesNotThrowAnyException();
    }
}
