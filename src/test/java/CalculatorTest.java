import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Calculator;
import calculator.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"8,4"})
    public void 사칙연산_테스트(int input1, int input2) {
        assertThat(Calculator.add(input1, input2)).isEqualTo(12);
        assertThat(Calculator.minus(input1, input2)).isEqualTo(4);
        assertThat(Calculator.multiply(input1, input2)).isEqualTo(32);
        assertThat(Calculator.divide(input1, input2)).isEqualTo(2);
    }

    @Test
    public void 입력값_null_또는_공백인_경우_예외_발생_테스트() {
        Service service = new Service();
        assertThatThrownBy(() -> {
            service.start("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 또는 빈 문자열은 입력할 수 없습니다.");
        assertThatThrownBy(() -> {
            service.start(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 또는 빈 문자열은 입력할 수 없습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 6 -- 7 $ 9", "5 ** 5 / 3"})
    public void 사칙연산_기호가_아닌_경우_예외_발생_테스트(String input) {
        Service service = new Service();
        assertThatThrownBy(() -> {
            service.start(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 기호입니다.");
    }

    @Test
    public void 사칙연산_우선순위_고려하지_않고_순서대로_실행_테스트() {
        Service service = new Service();
        assertThat(service.start("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
