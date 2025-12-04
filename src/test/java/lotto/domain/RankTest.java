package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void 당첨_1등() {
        Rank rank = Rank.of(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);

        rank = Rank.of(6, true);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 당첨_2등() {
        Rank rank = Rank.of(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 당첨_3등() {
        Rank rank = Rank.of(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 당첨_45등() {
        Rank rank = Rank.of(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
        rank = Rank.of(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);

        rank = Rank.of(3, true);
        assertThat(rank).isEqualTo(Rank.FIFTH);
        rank = Rank.of(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 없는_상금_검증() {
        Rank rank = Rank.of(2, false);
        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }

    @Test
    public void 당첨금_합계_검증() {
        int totalMoney = 50000;
        assertThat(Rank.THIRD.sumMoney(totalMoney))
                .isEqualTo(totalMoney + Rank.THIRD.getMoney());
    }
}
