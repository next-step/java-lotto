package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdditionCalculatorTest {

    @ParameterizedTest
    @DisplayName("디폴트구분자로 덧셈계산하기")
    @CsvSource(value = {"1:2:3=6", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void 디폴트구분자로_덧셈계산하기(String s, Integer result) {
        AdditionCalculator calculator = AdditionCalculator.from(s);
        assertThat(calculator.result()).isEqualTo(result);
    }

    void 커스텀구분자로_덧셈계산하기() {

    }

    void 구분자_숫자_외_값있을시_예외처리() {

    }

    void 음수있을시_예외처리() {

    }

}
