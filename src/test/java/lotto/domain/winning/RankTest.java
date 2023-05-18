package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @Test
    @DisplayName("보상 - 2등 추가")
    void checkReward() {
        assertThat(Rank.of(WinningCount.THREE)).isEqualTo(5_000);
        assertThat(Rank.of(WinningCount.FOUR)).isEqualTo(50_000);
        assertThat(Rank.of(WinningCount.FIVE)).isEqualTo(1_500_000);
        assertThat(Rank.of(WinningCount.FIVE_WITH_BONUS_BALL)).isEqualTo(3_000_000);
        assertThat(Rank.of(WinningCount.SIX)).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("WinningCount 목록")
    void countList() {
        assertThat(Rank.getWinningCounts()).containsExactly(WinningCount.THREE
                , WinningCount.FOUR, WinningCount.FIVE, WinningCount.FIVE_WITH_BONUS_BALL, WinningCount.SIX);
    }
}
