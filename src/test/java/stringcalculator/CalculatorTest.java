package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    void 입력값_split_테스트() {
        String input = "2 + 3 * 4 / 2";
        String[] inputs = Calculator.inputSpilt(input);
        assertThat(inputs).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("입력값이 null 이거나 공백이면 IllegalArgumentException")
    void 입력값_exction_test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.inputSpilt("");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.inputSpilt(null);
        });
    }

    @ParameterizedTest
    @DisplayName("입력값이 null 이거나 공백이면 IllegalArgumentException")
    @NullAndEmptySource
    void 입력값_exction_test2(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.inputSpilt(input);
        });
    }

    @Test
    void 사칙연산기호_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.getResult(1, "?", 2);
        });
    }

    @ParameterizedTest
    @CsvSource(
            {"'2 + 3 + 4', 9", "'7 - 3 - 4', 0", "'7 * 3', 21", "'7 / 1', 7", "'2 + 3 * 4 / 2', 10"})
    void 연산_test(String input, int result) {
        String[] inputs = Calculator.inputSpilt(input);
        assertThat(Calculator.calculateString(inputs)).isEqualTo(result);
    }
}
