package step1.calculator.controller;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorAppTest {

    @Test
    @DisplayName("CalculatorApp 테스트 #1 - 연산1번")
    void run() {
        // given
        String input = "2 + 3";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #2 - 연산3번")
    void run2() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #3 - 음수연산")
    void run3() {
        // given
        String input = "-1 + -2 * -4 / -2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(-6);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #4 - 잘못된 연산자")
    void run4() {
        // given
        String input = "1 ? 2 > 3 < 4 * 5";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #5 - 빈 문자열")
    void run5() {
        // given
        String input = "";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #6 - 공백 문자열")
    void run6() {
        // given
        String input = "    ";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #7 - 연산자로 끝나는 유효하지 않은 문자열")
    void run7() {
        // given
        String input = "1 + 2 +";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #8 - 연산자로 시작하는 유효하지 않은 문자열")
    void run8() {
        // given
        String input = "+ 1 + 2";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #9 - 연산자로 시작하고 연산자로 끝나는 유효하지 않은 문자열")
    void run9() {
        // given
        String input = "+ 1 + 2 +";

        // when
        // then
        CalculatorApp calculator = new CalculatorApp();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculates(input));
    }

}
