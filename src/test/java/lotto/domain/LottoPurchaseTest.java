package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPurchaseTest {
    @DisplayName("로또 판매 금액을 잘못 입력한 경우")
    @Test
    void buyAllAuto() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoPurchase.buyAllAuto(-1000))
            .withMessage(LottoPurchase.ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);
    }

    @DisplayName("로또 판매 금액 정상, 수동 등록 횟수를 잘 못 입력한 경우")
    @Test
    void buyManualOrAuto() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoPurchase.buyAutoOrManual(14_000, -1))
            .withMessage(LottoPurchase.ERROR_MESSAGE_MANUAL_LOTTO_COUNT);
    }

    @DisplayName("모든 로똔 관련 설정 정보가 정상 적인 경우")
    @Test
    void success() {
        assertThat(LottoPurchase.buyAutoOrManual(14_000, 4))
            .isEqualTo(new LottoPurchase(14_000, 10, 4));
    }
}