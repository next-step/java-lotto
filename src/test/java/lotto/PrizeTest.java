package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void ENUM_이름_확인하기() {
        assertThat(Prize.SECOND.name()).isEqualTo("SECOND");
    }

    @Test
    public void 최종상금_구하기() {
        int[] matchNumbers = {0, 0, 0, 0, 0, 0, 2};

        Prize prize = Prize.FIRST;
        long prizeMoney = prize.calculatePrizeMoney(matchNumbers);

        assertThat(prizeMoney).isEqualTo(4_000_000_000L);
    }
}