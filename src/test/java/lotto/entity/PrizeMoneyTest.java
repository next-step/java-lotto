package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PrizeMoneyTest {

    @Test
    void 맞히지_못함() {
        PrizeMoney result = PrizeMoney.findByCount(2);

        assertThat(result).isEqualTo(PrizeMoney.LOSE);
    }

    @Test
    void 당첨() {
        assertAll(
                () -> assertThat(PrizeMoney.findByCount(3)).isEqualTo(PrizeMoney.THREE),
                () -> assertThat(PrizeMoney.findByCount(4)).isEqualTo(PrizeMoney.FOUR),
                () -> assertThat(PrizeMoney.findByCount(5)).isEqualTo(PrizeMoney.FIVE),
                () -> assertThat(PrizeMoney.findByCount(6)).isEqualTo(PrizeMoney.SIX)
        );
    }
}
