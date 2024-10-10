package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PrizeMoniesTest {


    @Test
    void 맞히지_못함() {
        PrizeMonies prizeMonies = new PrizeMonies();
        PrizeMoney result = prizeMonies.result(2);

        assertThat(result).isEqualTo(PrizeMoney.LOSE);
    }

    @Test
    void 당첨() {
        PrizeMonies prizeMonies = new PrizeMonies();

        assertAll(
                () -> assertThat(prizeMonies.result(3)).isEqualTo(PrizeMoney.THREE),
                () -> assertThat(prizeMonies.result(4)).isEqualTo(PrizeMoney.FOUR),
                () -> assertThat(prizeMonies.result(5)).isEqualTo(PrizeMoney.FIVE),
                () -> assertThat(prizeMonies.result(6)).isEqualTo(PrizeMoney.SIX)
        );

    }

}
