package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("일치 개수로 등수를 찾는다 (6개=1등, 5개=3등, 4개=4등, 3개=5등)")
    void rankOfMatchCount() {
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨이 아닌 개수는 MISS로 반환한다")
    void nonWinningIsMiss() {
        assertThat(Rank.of(2)).isEqualTo(Rank.MISS);
        assertThat(Rank.of(0)).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("winningRanks는 MISS를 제외한 당첨 등수만 반환한다")
    void winningRanksExcludesMiss() {
        assertThat(Rank.winningRanks()).doesNotContain(Rank.MISS);
    }
}
