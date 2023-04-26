package calculcator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 계산하기() {
       int result = Calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void split() {
        String[] result = Calculator.split("2 + 33 * 4 / 2");
        assertThat(result).contains("2","+","33","*","4","/","2");
    }

    @DisplayName("계산식이 null일 경우 exception 체크")
    @Test
    void split_null() {
        assertThatThrownBy(()->Calculator.split(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산식이 공백일 경우 exception 체크")
    @Test
    void split_empty() {
        assertThatThrownBy(()->Calculator.split(" ")).isInstanceOf(IllegalArgumentException.class);
    }


}
