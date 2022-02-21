package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoBuyTest {

    @Test
    void 로또_가격보다_낮은_금액() {
        assertThatThrownBy(() -> new LottoBuy(new Money("1")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_티켓_구입() {
        LottoBuy lottoBuy = new LottoBuy(new Money("10000"));

        assertThat(lottoBuy.buyAutoLottos(lottoBuy.getCount()).getLottoTicket().size())
            .isEqualTo(10);
    }
}