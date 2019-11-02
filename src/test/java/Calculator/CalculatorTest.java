package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void start() {
        calculator = new Calculator();
    }

    @Test
    void 계산기_생성() {
        assertThat(calculator).isEqualTo(new Calculator());
    }

    @Test
    void 빈문자열_또는_null_입력() {
        assertThat(calculator.calculateText("")).isEqualTo(0);
        assertThat(calculator.calculateText(null)).isEqualTo(0);
    }

    @Test
    void 단독_또는_콤마포함_계산() {
        assertThat(calculator.calculateText("6")).isEqualTo(6);
        assertThat(calculator.calculateText("6,7")).isEqualTo(13);
    }

    @Test
    void 콤마와_콜론포함_계산() {
        assertThat(calculator.calculateText("6,7:3")).isEqualTo(16);
    }

    @Test
    void 커스텀_구분자_계산() {
        assertThat(calculator.calculateText("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_계산(){
        assertThatThrownBy(() -> {
            calculator.calculateText("//;\n-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_이외의_문자_계산(){
        assertThatThrownBy(() -> {
            calculator.calculateText("//;\n-1&2;3");
        }).isInstanceOf(RuntimeException.class);
    }


}
