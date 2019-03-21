package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void ENUM_이름_확인하기() {
        Assertions.assertThat(Prize.SECOND.name()).isEqualTo("SECOND");
    }

    @Test
    public void 최종상금_구하기() {
        int[] matchNumbers = {0, 0, 0, 0, 0, 0, 2};

        Prize prize = Prize.FIRST;
        long prizeMoney = prize.calculatePrizeMoney(matchNumbers, prize.name());

        assertThat(prizeMoney).isEqualTo(4_000_000_000L);
    }

    @Test
    public void 보너스상금_확인하기() {
        assertThat(Prize.calculateBonusMoney(1)).isEqualTo(30_000_000);
    }

    @Test
    public void matchCount_5_금액확인() {
        int[] matchNumbers = {0, 0, 0, 0, 0, 2, 0};
        Prize prize = Prize.THIRD;
        long prizeMoney = prize.calculatePrizeMoney(matchNumbers, prize.name());
        prizeMoney += Prize.calculateBonusMoney(1);
        assertThat(prizeMoney).isEqualTo(33_000_000);
    }
}