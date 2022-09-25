package lotto.step2.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
}
