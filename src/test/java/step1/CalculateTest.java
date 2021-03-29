package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculateTest {

    @DisplayName("1,2,3이 6이 잘 나오는지 테스트")
    @Test
    void commaSplitTest() {
        Calculator calculator = new Calculator(new Splitter());
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
    }

    @DisplayName("1,2:3이 6이 잘 나오는지 테스트")
    @Test
    void commaColonSplitTest() {
        Calculator calculator = new Calculator(new Splitter());
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @DisplayName("//;\\n1;2;3이 6이 잘 나오는지 테스트")
    @Test
    void customSplit() {
        Calculator calculator = new Calculator(new Splitter());
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수가 껴있을 때 예외가 잘 발생하는지 테스트")
    @Test
    void minusIsException() {
        Calculator calculator = new Calculator(new Splitter());
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자만 있을 때 숫자가 반환되는지 테스트")
    @Test
    void numberReturnTest() {
        Calculator calculator = new Calculator(new Splitter());
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @DisplayName("공백 문자 null은 0으로 잘 반환되는지 테스트")
    @Test
    void emptyStringAndNullIsZero() {
        Calculator calculator = new Calculator(new Splitter());
        assertThat(calculator.calculate("0")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }
}
