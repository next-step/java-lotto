package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("빈 문자 혹은 공백 입력 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullInputTest(String text){
        assertThatThrownBy(() -> Calculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 사칙연산 테스트")
    @Test
    void formulaTest(){
        String formula = "2 + 3 * 4 / 2";
        assertThat(Calculator.calculate(formula)).isEqualTo(10);
    }
}
