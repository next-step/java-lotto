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
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(4);
        assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(3);
    }
}
