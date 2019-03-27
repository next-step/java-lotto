package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCountTest {

    @Test
    public void 당첨결과_동등비교() {
        RankCount rankCount = new RankCount(Rank.FIRST, 1);

        assertThat(rankCount).isEqualTo(new RankCount(Rank.FIRST, 1));
    }
}