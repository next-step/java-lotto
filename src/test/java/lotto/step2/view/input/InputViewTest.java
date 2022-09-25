package lotto.step2.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    @DisplayName("로또 구입 금액 입력 값 반환")
    void input() {
        int lottoPaymentInput = InputView.lottoPaymentInput("14000");
        assertThat(lottoPaymentInput).isEqualTo(14000);
    }
}
