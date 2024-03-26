package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.domain.Calculator;
import common.view.CalculatorInputView;
import common.view.LottoInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @DisplayName("입력 값이 공백이면 IllegalArgumentException 발생")
    @Test
    void input_empty(){
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorInputView.validate(""));
    }

    @DisplayName("입력 값이 null이면 IllegalArgumentException 발생")
    @Test
    void input_null(){
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorInputView.validate(null));
    }

    @DisplayName("사칙연산이 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"#", "$", "%"})
    void invalid_사칙연산_input(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.operate(input,1,2));
    }

    @DisplayName("계산")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 * 3 - 4 / 2=1", "2 + 3 - 4 / 2=0"}, delimiter = '=')
    void input_empty(String input, int result){
        assertThat(Calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("입력 값이 숫자가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void 숫자가_아닌_input(){
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("2 + 3 * / / 2=10"));
    }

    @DisplayName("입력 값이 null 또는 공백이면 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void input_null_or_empty(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorInputView.validate(input));
    }
}
