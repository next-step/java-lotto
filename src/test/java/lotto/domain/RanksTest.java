package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {
    @Test
    void calculate_prize() {
        assertThat(new Ranks(List.of(Rank.FIRST, Rank.SECOND)).calculateRateOfReturn(new Price(2000)))
                .isEqualTo((Rank.FIRST.getPrize() + Rank.SECOND.getPrize()) / 2000);
    }
}
