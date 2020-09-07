package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치 개수에 따른 Rank 테스트")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4,false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);

    }

    @DisplayName("rank에 따른 개수 확인 테스트")
    @Test
    void countOfMatch() {
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
        assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
    }

    @DisplayName("rank의 countOfMatch와 count가 동일한지 테스트")
    @Test
    void equalsCountOfMatch() {
        assertThat(Rank.equalsCountOfMatch(Rank.FIFTH, 3)).isTrue();
        assertThat(Rank.equalsCountOfMatch(Rank.SECOND, 5)).isTrue();
        assertThat(Rank.equalsCountOfMatch(Rank.THIRD, 4)).isFalse();
    }
}
