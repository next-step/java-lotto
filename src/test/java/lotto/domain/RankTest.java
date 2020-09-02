package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치 개수에 따른 Rank 테스트")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("rank에 따른 개수 확인 테스트")
    @Test
    void countOfMatch() {
        assertThat(Rank.countOfMatch(Rank.FIRST)).isEqualTo(6);
        assertThat(Rank.countOfMatch(Rank.SECOND)).isEqualTo(5);
        assertThat(Rank.countOfMatch(Rank.THIRD)).isEqualTo(4);
        assertThat(Rank.countOfMatch(Rank.FOURTH)).isEqualTo(3);
    }
}
