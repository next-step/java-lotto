package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    public void 당첨1등() throws Exception {
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 당첨2등() throws Exception {
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 당첨3등() throws Exception {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
    }
}

