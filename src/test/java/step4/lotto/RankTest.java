package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void rank_1등() {
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2등() {
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3등() {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank_4등() {
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
    }
}
