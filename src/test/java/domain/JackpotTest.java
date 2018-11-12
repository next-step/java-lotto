package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JackpotTest {

    @Test
    public void 맞춘개수_0개_금액_0원() {
        Jackpot jackpot1 = Jackpot.valueOf(1);
        assertThat(jackpot1.getPrizeMoney()).isEqualTo(0);
    }

    @Test
    public void 맞춘개수_6개_금액_0원() {
        Jackpot jackpot1 = Jackpot.valueOf(6);
        assertThat(jackpot1.getPrizeMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    public void 오등이_3번된_경우_금액_15000원() {
        int totalPrize = Jackpot.SAME_3_NUMBERS.getTotalPrizeMoney(3);
        assertThat(totalPrize).isEqualTo(15_000);
    }
}
