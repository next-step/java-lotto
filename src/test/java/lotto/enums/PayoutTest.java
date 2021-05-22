package lotto.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PayoutTest {


    @Test
    void 이넘_테스트() {
        Payout matchZero = Payout.MATCH_ZERO;
        Payout matchSix = Payout.MATCH_SIX;

        assertThat(matchZero.getPayout()).isEqualTo(0);
        assertThat(matchSix.getPayout()).isEqualTo(2000000000);
    }

    @Test
    void getPayOut_테스트() {
        assertThat(Payout.getPayout(3)).isEqualTo(5000);
    }
}
