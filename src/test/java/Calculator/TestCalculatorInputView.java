package Calculator;

import Calculator.View.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCalculatorInputView {
    @Test
    @DisplayName("유효하지 않은 방정식일 때 return false")
    public void isValidAlgebra_not_valid() {
        boolean actual = InputView.isValidAlgebra("1 + 2 a".split(" "));
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("유효한 방정식일 때 return true")
    public void isValidAlgebra_valid() {
        boolean actual = InputView.isValidAlgebra("1 + 2 / 3".split(" "));
        assertThat(actual).isEqualTo(true);
    }
}
