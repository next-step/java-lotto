package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"5, 10, 15", "0, 10, 10", "0, 0, 0"})
    @DisplayName("입력받은 숫자들의 합을 구한다.")
    void sum_test(int left, int right, int expectedAnswer) {
        //when
        int sum = Calculator.sum(left, right);

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("사용자에게 쉼표이 포함된 숫자를 입력받아 숫자를 더한다.")
    void inputAndSum_test() {
        //given
        String input = "5,10";
        Calculator calculator = new Calculator(input);

        //when
        int sum = calculator.sum2();

        //then
        assertThat(sum).isEqualTo(15);
    }

}
