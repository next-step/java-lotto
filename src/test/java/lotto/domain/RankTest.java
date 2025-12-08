package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void 당첨_from_1등_to_5등() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 없는_상금_검증() {
        assertThat(Rank.from(2, false)).isEqualTo(Rank.NO_MATCH);
    }

    @Test
    public void 당첨금_합계_검증() {
        assertThat(Rank.FIFTH.addMoney(50_000)).isEqualTo(new Money(55_000));
        assertThat(Rank.FIFTH.addMoney(new Money(50_000))).isEqualTo(new Money(55_000));
    }

    @Test
    void 당첨수당_당첨금() {

    }
}
