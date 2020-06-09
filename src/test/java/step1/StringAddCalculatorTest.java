package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 덧셈 계산기 클래스 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열 합을 구한다")
    void 문자열_다_더하기() {
        String numbers = "1:2:3:4";
        StringAddCalculator calculator = new StringAddCalculator(numbers);
        assertThat(calculator.sum()).isEqualTo(10);
    }

    @Test
    @DisplayName("음수와 숫자 이외의 값은 RuntimeException")
    void 숫자아니면_RUNTIME_EXCEPTION() {
        String numbers = "zz:dd:-3:4";

        assertThatIllegalArgumentException().isThrownBy(() -> new StringAddCalculator(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    @DisplayName("숫자 하나 입력하면 하나 반환")
    void input1NumberReturn1Number(String number) {
        StringAddCalculator calculator = new StringAddCalculator(number);
        assertThat(calculator.sum()).isEqualTo(Integer.parseInt(number));
    }
}
