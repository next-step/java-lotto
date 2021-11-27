package lotto.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("6개가 일치할때 1등과 일치한다.")
    @Test
    void match1st() {
        assertThat(Rank.matchRankOf(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개가 일치할때 2등과 일치한다.")
    @Test
    void match2st() {
        assertThat(Rank.matchRankOf(5)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("4개가 일치할때 3등과 일치한다.")
    @Test
    void match3st() {
        assertThat(Rank.matchRankOf(4)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("3개가 일치할때 4등과 일치한다.")
    @Test
    void match4st() {
        assertThat(Rank.matchRankOf(3)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 개수가 3개 이하일 경우 Rank.OUT이 반환된다.")
    @Test
    void matchOut() {
        assertThat(Rank.matchRankOf(2)).isEqualTo(Rank.OUT);
    }
}
