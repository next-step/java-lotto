package lotto.step2.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @Test
    @DisplayName("로또 구입 금액 입력 값 반환")
    void input() {
        int lottoPaymentInput = InputView.lottoPaymentInput("14000");
        assertThat(lottoPaymentInput).isEqualTo(14000);
    }
    
    @NullAndEmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("null 또는 \"\" 입력 시 예외 던지기")
    void null_or_empty_input_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentInput(input))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"abcde", "!@#$%", "14000a"})
    void number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentInput(input))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("입력 값이 1000원 단위가 아닐 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1400", "1001", "1234", "1100"})
    void different_unit_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentInput(input))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("0원 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "0000"})
    void zero_input_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentInput(input))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @Test
    @DisplayName("음수 입력 시")
    void negative_input_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentInput("-1"))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
}
