package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열이 비어있는 경우 exception을 발생한다.")
    void 문자열_null_또는_공백() {
        assertThatThrownBy(() -> StringCalculator.getInstance().split(""))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> StringCalculator.getInstance().split(null))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("문자열을 공백 기준으로 split 한다.")
    void 문자열_split() {
        String[] result = StringCalculator.getInstance().split("3 + 5");
        assertThat(result).hasSize(3);
    }
}
