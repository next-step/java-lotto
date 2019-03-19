package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 타입구하기() {
        Prize prize = Prize.typeOf(3);
        assertThat(prize.name()).isEqualTo("FORTH");
    }

    @Test
    public void first_금액구하기() {
        Prize prize = Prize.typeOf(6);
        long prizeMoney = prize.calculatePrizeMoney(1);

        assertThat(prizeMoney).isEqualTo(2_000_000_000);
    }
}