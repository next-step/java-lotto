package calculator.domain;

import calculator.Main;
import calculator.domain.calculator.NegativeInputException;
import calculator.domain.calculator.NonNumericValuesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Main 클래스 테스트")
public class MainTest {

    @DisplayName("null 또는 빈문자")
    @Test
    public void calculate_null_empty() {
        int result = Main.calculate(null);
        assertThat(result).isEqualTo(0);

        result = Main.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나")
    @Test
    public void calculate_one_number() {
        int result = Main.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자")
    @Test
    public void calculate_comma() {
        int result = Main.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("콜론 구분자")
    @Test
    public void calculate_colon() {
        int result = Main.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자")
    @Test
    public void calculate_comma_or_colon() {
        int result = Main.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자")
    @Test
    public void calculate_custom() {
        int result = Main.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수 예외")
    @Test
    public void calculate_negative() {
        assertThatThrownBy(() -> Main.calculate("-1,2,3"))
                .isInstanceOf(NegativeInputException.class);
    }

    @DisplayName("숫자 아닌 값 예외")
    @Test
    public void calculate_non_numeric() {
        assertThatThrownBy(() -> Main.calculate("-,2,3"))
                .isInstanceOf(NonNumericValuesException.class);
    }
}
