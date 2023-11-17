package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    void inputSplit() {
        String input = "2 + 3";
        assertThat(input.split(" ")).contains("2","+","3");
    }

    @Test
    void input_nullOrBlank_Exception() {
        String nullInput = null;
        String blankInput = " ";
        String emptyInput = "";
        assertThatThrownBy(()->Calculator.execute(nullInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->Calculator.execute(blankInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->Calculator.execute(emptyInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_Array_Exception() {
        String input = "1 + 2 + ";
        assertThatThrownBy(()->Calculator.execute(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add() {
        String input = "2 + 3";
        assertThat(Calculator.execute(input)).isEqualTo(5);
    }

    @Test
    void subtract() {
        String input = "2 - 3";
        assertThat(Calculator.execute(input)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        String input = "2 * 3";
        assertThat(Calculator.execute(input)).isEqualTo(6);
    }

    @Test
    void divide() {
        String input = "2 / 3";
        assertThat(Calculator.execute(input)).isZero();
    }

    @Test
    void advancedOperate() {
        String input = "2 + 3 * 4 / 2";
        assertThat(Calculator.execute(input)).isEqualTo(10);
    }
}
