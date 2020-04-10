package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {
    @Test
    public void getTotalWinningMoney() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FIFTH));
        assertThat(ranks.getTotalWinningMoney()).isEqualTo(15_000);
    }
}
