package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

    @Test
    @DisplayName("15000원을 입력 시 15개의 로또를 반환한다.")
    void createLottos() {
        LottoBuyer lottoBuyer = new LottoBuyer(15000);
        lottoBuyer.buyLottos();

        assertThat(lottoBuyer.lottos().count()).isEqualTo(15);
    }
}