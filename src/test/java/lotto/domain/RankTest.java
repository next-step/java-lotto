package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RankTest {
    private static final boolean MATCH_BONUS = true;
    private static final boolean MISMATCH_BONUS = false;

    @Test
    public void valueOf() {
        assertAll(
                () -> assertThat(Rank.valueOf(6, MISMATCH_BONUS)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.valueOf(5, MATCH_BONUS)).isEqualTo(Rank.SECOND),
                () -> assertThat(Rank.valueOf(5, MISMATCH_BONUS)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.valueOf(4, MATCH_BONUS)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(4, MISMATCH_BONUS)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(3, MATCH_BONUS)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(3, MISMATCH_BONUS)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(2, MATCH_BONUS)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(0, MATCH_BONUS)).isEqualTo(Rank.MISS)
        );
    }
}
