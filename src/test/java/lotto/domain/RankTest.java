package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    @DisplayName("맞춘 로또 번호 수에 따라 등수 출력")
    @Test
    void valueOf() {
        assertAll(
                () -> assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND),
                () -> assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS)
        );
    }
}