package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구입금액을 입력하면 금액에 해당하는 로또가 발급된다.")
    @Test
    void lottosInit() {
        //given
        final Lottos lottos = new Lottos(new Amount(14500));

        //when
        final int result = lottos.purchaseCount();

        assertThat(result).isEqualTo(14);
    }

}