package Calculator;

import Util.CheckInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestUtilCheckInput {
    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean actual = CheckInput.isNumeric("abc");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean actual = CheckInput.isNumeric("1");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("oprator가 아닐 때 IllegalArgumentException")
    public void isOperator_not_opreator() {
        assertThatThrownBy(() -> CheckInput.isOperator("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("oprator일 때 return true")
    public void isOperator_opreator() {
        boolean actual = CheckInput.isOperator("+");
        assertThat(actual).isEqualTo(true);
    }

}
