package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 덧셈 계산기 클래스 테스트")
public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4>10", "3:2,3:4>12", ">0"}, delimiter = '>')
    @DisplayName("문자열 합을 구한다")
    void 문자열_다_더하기(String input, int expected) {
        StringAddCalculator calculator = new StringAddCalculator(input);
        assertThat(calculator.sum()).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스컴 문자열 합을 구한다")
    void 커스텀_문자열_더하기() {
        StringAddCalculator calculator = new StringAddCalculator("//;\n1;3;4");
        assertThat(calculator.sum()).isEqualTo(8);
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

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 공백을 입력받으면 0리턴")
    void 널_이나_0_입력_리턴_0(String input) {
        StringAddCalculator calculator = new StringAddCalculator(input);
        assertThat(calculator.sum()).isEqualTo(0);
    }
}
