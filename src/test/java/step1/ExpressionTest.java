package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {
    @Test
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException을 던져야한다.")
    void 빈_값_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(" ");
        });
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException을 던져야한다.")
    void null_값_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(null);
        });
    }
}
