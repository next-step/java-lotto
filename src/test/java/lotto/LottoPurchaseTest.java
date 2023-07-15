package lotto;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoPurchaseTest {

    @DisplayName("구입금액이 충분할 경우 예외가 발생하지 않는다")
    @Test
    void 로또_수동_구매_성공() {
        int payment = 5000;
        int manualCount = 3;

        assertDoesNotThrow(() -> new LottoPurchase(payment, manualCount));
    }

    @DisplayName("구입금액이 부족할 경우 예외가 발생한다")
    @Test
    void 로또_수동_구매_실패() {
        int payment = 5000;
        int manualCount = 7;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPurchase(payment, manualCount))
                .withMessage(
                        MessageFormat.format("금액이 부족합니다. 현재 금액 : {0}원", payment)
                );
    }
}
