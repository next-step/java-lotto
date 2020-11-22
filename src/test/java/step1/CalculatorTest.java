package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자 테스트")
    void defaultCalculateTest() {
        String testInput = "1,2,3;4;5,6";
        int expectAnswer = 21;
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.calculate(testInput)).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("변경 구분자 테스트")
    void changedSplitValueTest() {
        String changeValue = "~";

        String testInput = "//" + changeValue +"\n1~2~3~4";
        int expectAnswer = 10;

        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.calculate(testInput)).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("빈값 테스트")
    void blankInputTest() {
        String testInput = "";
        int expectAnswer = 0;
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.calculate(testInput)).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("싱글 텍스트 테스트")
    void SingleValueTest() {
        String testInput = "6";
        int expectAnswer = 6;
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.calculate(testInput)).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("계산 로직 기본 테스트")
    void calculateFunctionTest() {
        String[] inputValue = {"1", "2", "3", "4"};

        Calculator calculator = new Calculator();

        assertThat(calculator.calculateFunction(inputValue)).isEqualTo(10);
    }

    @Test
    @DisplayName("계산 로직 음수 테스트")
    void validateTest() {
        String[] inputValue = {"1", "-2", "3", "4", "5"};

        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculateFunction(inputValue))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("계산 로직 문자 입력 테스트")
    void textCalculateTest() {
        String[] inputValue = {"a", "B", "2", "d"};

        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculateFunction(inputValue))
                .isInstanceOf(RuntimeException.class);
    }
}
