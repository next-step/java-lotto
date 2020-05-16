package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void return_0_when_empty_string() {
        long result = calculator.calculate("");
        assertThat(result).isEqualTo(0);

        result = calculator.calculate("    \n");
        assertThat(result).isEqualTo(0);

        result = calculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void return_single_val_when_input_single_val(){
        long result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);

        result = calculator.calculate("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void given_dot_when_calculate_then_split_with_dot(){
        long result = calculator.calculate("1,2", ",");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void given_semicolon_when_calculate_then_split_with_semicolon(){
        long result = calculator.calculate("1;2",";");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void given_semicolon_and_dot_when_calculate_then_split_with_semicolon_and_dot(){
        long result = calculator.calculate("1;2,3", ",|;");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void given_invalid_format_when_calculate_then_throw_exception(){
        assertThatThrownBy(() -> calculator.calculate("z")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("1+2")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void given_negative_when_calculate_then_throw_exception(){
        assertThatThrownBy(() -> calculator.calculate("-1,-2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("-1,2",",")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("-1;2",";")).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     *
     *
     * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
     * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
     *
     */
}
