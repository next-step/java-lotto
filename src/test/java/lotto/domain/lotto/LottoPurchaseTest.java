package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    @Test
    void 구매금액이_1000원_이하면_로또를_구매할_수_없다() {
        assertThatThrownBy(() -> new LottoPurchase(900, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }

    @Test
    void 구매금액으로_입력한_수동_로또를_살_수_없다면_예외처리한다() {
        assertThatThrownBy(() -> new LottoPurchase(3000, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액이 모자라 수동 로또를 살 수 없습니다.");
    }

    @Test
    void 자동로또의_개수를_객체_생성_시에_계산한다() {
        LottoPurchase lottoPurchase = new LottoPurchase(14000, 3);
        assertThat(lottoPurchase.getAutomaticLottoQuantity().intValue()).isEqualTo(11);
    }
}