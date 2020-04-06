package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RankTest {
    @Test
    public void valueOf() {
        assertAll(
                () -> assertThat(Rank.valueOf(6L)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.valueOf(5L)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.valueOf(4L)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(3L)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(2L)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(1L)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(0L)).isEqualTo(Rank.MISS)
        );
    }
}
