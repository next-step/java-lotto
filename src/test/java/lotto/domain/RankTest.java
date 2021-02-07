package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("번호 맞춘 카운트, 보너스 맞춤 여부를 통한 랭크 결과 테스트")
    @Test
    void getRankTest() {
        assertThat(Rank.getRank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isNotEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRank(2, true)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.getRank(1, false)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.getRank(0, true)).isEqualTo(Rank.NOTHING);

    }
}