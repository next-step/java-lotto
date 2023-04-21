package Calculator;

import Calculator.View.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean actual = InputView.isNumeric("abc");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean actual = InputView.isNumeric("1");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("oprator가 아닐 때 IllegalArgumentException")
    public void isOperator_not_opreator() {
        boolean actual = InputView.isOperator("a");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("oprator일 때 return true")
    public void isOperator_opreator() {
        boolean actual = InputView.isOperator("+");
        assertThat(actual).isEqualTo(true);
    }

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
