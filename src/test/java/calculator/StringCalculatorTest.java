package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 구현 테스트")
    @CsvSource(value = {"2 + 2=4","3 - 1=2","3 * 9=27","10 / 2=5"}, delimiter = '=')
    public void 사칙연산_구현_성공_테스트(String input, String output) {
        Integer result = CalculatorService.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @DisplayName("입력값 null 처리 테스트")
    @NullSource
    @ValueSource(strings = {"", "  "})
    public void 입력값_null_공백시_예외발생_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           CalculatorService.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호 아닐 경우 테스트")
    @CsvSource(value = {"2 $ 2=4","3 ^ 1=2","3 @ 9=27","10 ! 2=5"}, delimiter = '=')
    public void 사칙연산_기호가_아닐시_예외발생_테스트(String input, String output) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorService.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @CsvSource(value = {"2 + 3 - 1 * 10 / 2=20", "27 / 3 * 3 - 3 + 3=27"}, delimiter = '=')
    public void 사칙연산_모두포함하는식_계산_성공_테스트(String input, String output) {
        Integer result = CalculatorService.calculate(input);
        assertThat(result).isEqualTo(output);
    }

}
