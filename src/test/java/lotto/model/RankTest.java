package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    public void 당첨() {
        assertThat(Rank.MISS).isEqualTo(Rank.valueOf(2, false));
    }

    @Test
    public void 미당첨() {
        assertThat(Rank.FIRST).isEqualTo(Rank.valueOf(6, false));
        assertThat(Rank.SECOND).isEqualTo(Rank.valueOf(5, true));
        assertThat(Rank.FIFTH).isEqualTo(Rank.valueOf(3, false));
    }

    @Test
    public void 일등_당첨금() {
        assertThat(Rank.FIRST.getWinningMoney())
                .isEqualTo(Rank.valueOf(6, false).getWinningMoney());
    }

    @Test
    public void 이등_당첨금() {
        assertThat(Rank.SECOND.getWinningMoney())
                .isEqualTo(Rank.valueOf(5, true).getWinningMoney());
    }
}