package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void addCalculate(){
        int calculate = StringCalculator.calculate("11 + 4");
        assertThat(calculate).isEqualTo(15);
    }

    @Test
    void minusCalculate(){
        int calculate = StringCalculator.calculate("11 - 4");
        assertThat(calculate).isEqualTo(7);
    }

    @Test
    void multiplyCalculate(){
        int calculate = StringCalculator.calculate("11 * 4");
        assertThat(calculate).isEqualTo(44);
    }

    @Test
    void divideCalculate(){
        int calculate = StringCalculator.calculate("11 / 4");
        assertThat(calculate).isEqualTo(2);
    }

    @Test
    @DisplayName("복합 사칙연산을 공백 구분자로 처리한다.")
    void complexCalculate(){
        int calculate = StringCalculator.calculate("11 + 3 - 4 / 5");
        int calculate2 = StringCalculator.calculate("2 + 5 / 7");
        int calculate3 = StringCalculator.calculate("5 - 2 * 10");

        Assertions.assertAll(
                () -> assertThat(calculate).isEqualTo(2),
                () -> assertThat(calculate2).isEqualTo(1),
                () -> assertThat(calculate3).isEqualTo(30)
        );
    }

    @Test
    @DisplayName("사칙연산 이외의 기호가 들어가면 IllegalArgumentException 을 던진다.")
    void operator_exception(){
        assertThatThrownBy(() ->
            StringCalculator.calculate("11 % 4"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 혹은 공백 문자열이 들어가면 IllegalArgumentException 을 던진다.")
    void operand_exception(){
        assertThatThrownBy(() ->
            StringCalculator.calculate(" + 4"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
