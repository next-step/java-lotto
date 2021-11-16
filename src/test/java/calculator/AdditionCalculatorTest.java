package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdditionCalculatorTest {

    @ParameterizedTest
    @DisplayName("디폴트구분자로 덧셈 계산하기")
    @CsvSource(value = {"1:2:3=6", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void sumDefaultDelimiter(String s, Integer result) {
        AdditionCalculator calculator = AdditionCalculator.from(s);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 덧셈 계산하기")
    @CsvSource(value = {"//;\\n1;2;3=6", "//a\\n1a2a3a4=10", "//+\\n1+2+3+5=11"}, delimiter = '=')
    void sumCustomDelimiter(String s, Integer result) {
        AdditionCalculator calculator = AdditionCalculator.from(s);
        assertThat(calculator.result()).isEqualTo(result);
    }

    void 구분자_숫자_외_값있을시_예외처리() {

    }

    void 음수있을시_예외처리() {

    }

}
