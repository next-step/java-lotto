package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.Calculator;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @DisplayName("입력 값이 공백이면 IllegalArgumentException 발생")
    @Test
    void input_empty(){
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.validate(""));
    }

    @DisplayName("입력 값이 null이면 IllegalArgumentException 발생")
    @Test
    void input_null(){
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.validate(null));
    }

    @DisplayName("사칙연산이 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"#", "$", "%"})
    void input_empty(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.operate(input,1,2));
    }

    @DisplayName("계산")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 * 3 - 4 / 2=1", "2 + 3 - 4 / 2=0"}, delimiter = '=')
    void input_empty(String input, int result){
        assertThat(Calculator.calculate(input)).isEqualTo(result);
    }
}
