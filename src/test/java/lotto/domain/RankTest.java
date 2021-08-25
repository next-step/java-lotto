package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RankTest {

    @DisplayName("로또 맞춘 갯수에 따라 등수 찾기 - 보너스 볼 추가")
    @Test
    void findRank() {
        assertThat(Rank.findRank(2, true)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.findRank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST);
    }

}