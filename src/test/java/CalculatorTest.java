import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @DisplayName("사칙연산 아닐경우   -> IllegalArgumentException throw")
    @Test
    void not_사칙연산() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> { new Calculator().calculate("1 @ 3"); })
                .withMessage("%s!", "사칙연산으로만 계산이 가능합니다")
                .withNoCause();

    }

    @DisplayName("입력 null,빈 공백 -> IllegalArgumentException throw")
    @Test
    void null_blank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> { new Calculator().calculate(" "); })
                .withMessage("%s!", "공백은 계산처리가 안됩니다")
                .withNoCause();

    }

    @DisplayName("입력 1 + 3 - 3 * 3 / 3 || 출력 1")
    @Test
    void calculator_five_numbers() {
        String input = "1 + 3 - 3 * 3 / 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(1);
    }

    @DisplayName("입력 1 + 3 - 3 * 3 || 출력 3")
    @Test
    void calculator_four_numbers() {
        String input = "1 + 3 - 3 * 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(3);
    }

    @DisplayName("입력 1 + 3 - 3 || 출력 1")
    @Test
    void calculator_three_numbers() {
        String input = "1 + 3 - 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(1);
    }

    @DisplayName("입력 1 + 3 || 출력 4")
    @Test
    void add() {
        String input = "1 + 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(4);
    }

}
