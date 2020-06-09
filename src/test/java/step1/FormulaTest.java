package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력 받은 문자열 클래스 테스트")
class FormulaTest {

    @Test
    @DisplayName("음수와 숫자 이외의 값은 RuntimeException")
    void 숫자_아니면_RUNTIME_EXCEPTION() {
        String numbers = "zz:dd:-3:4";

        assertThatIllegalArgumentException().isThrownBy(() -> new Formula(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    @DisplayName("숫자 하나 입력하면 배열 사이즈 1개")
    void input1NumberReturn1Number(String number) {
        Formula formula = new Formula(number);
        assertThat(formula.getFormulaNumbers()).hasSize(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 공백을 입력받으면 0리턴")
    void 널_이나_0_입력_리턴_0(String input) {
        Formula formula = new Formula(input);
        assertThat(formula.getFormulaNumbers()).contains(0);
    }

}