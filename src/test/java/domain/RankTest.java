package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("일치 개수에 따라 올바른 Rank를 반환한다")
    void Rank_매치() {
        assertThat(Rank.of(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(2)).isNull();
    }

    @Test
    @DisplayName("Rank 별 상금을 반환한다")
    void 상금_반환() {
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(50_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
    }
}