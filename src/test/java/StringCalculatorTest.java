import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("두 문자열을 더한다")
    void plus_test(){
        assertThat(calculator.calculate("2 + 3"))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("두 문자열을 뺀다")
    void minus_test(){
        assertThat(calculator.calculate("2 - 3"))
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("두 문자열을 곱한다")
    void multiple_test(){
        assertThat(calculator.calculate("2 * 3"))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("두 문자열을 나눈다")
    void divide_test(){
        assertThat(calculator.calculate("4 / 2"))
                .isEqualTo(2);
    }


    @Test
    @DisplayName("입력값이 null일 경우 IllegalArgumentException 처리")
    void when_input_value_is_null_expected_exception(){
        assertThatThrownBy( () ->{
            calculator.calculate(null);
        })
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 공백 문자일 경우 IllegalArgumentException 처리")
    void when_input_value_is_empty_expected_exception(){
        assertThatThrownBy( () ->{
            calculator.calculate("");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력값은 null 또는 빈공백 값이 될수 없습니다. 확인해주세요.");
    }

    @Test
    @DisplayName("사측연산 기호가 아닌 문자가 있을 경우 IllegalArgumentException 처리")
    void when_input_value_contain_not_func_sign_expected_exception(){
        assertThatThrownBy( () ->{
            calculator.calculate("3 = 1");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자, 공백, 사측연산 기호 외의 문자가 포함되어있습니다.");
    }
}
