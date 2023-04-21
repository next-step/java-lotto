package Calculator;

import Calculator.View.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    @DisplayName("oprator가 아닐 때 IllegalArgumentException")
    public void isOperator_not_opreator() {
        boolean expected = false;

        boolean actual = InputView.isOperator("a");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("oprator일 때 return true")
    public void isOperator_opreator() {
        boolean expected = true;

        boolean actual = InputView.isOperator("+");
        assertThat(actual).isEqualTo(expected);
    }

//    @Test
//    @DisplayName("유효하지 않은 방정식일 때 return false")
//    public void isValidAlgebra_not_valid() {
//        boolean expected = true;
//
//        boolean actual = InputView.isValidAlgebra("1 + 2 a".split(" "));
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    @DisplayName("유효한 방정식일 때 return true")
//    public void isValidAlgebra_valid() {
//        boolean expected = true;
//
//        boolean actual = InputView.isValidAlgebra("1 + 2 / 3".split(" "));
//        assertThat(actual).isEqualTo(expected);
//    }
}
