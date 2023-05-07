package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @Test
    @DisplayName("보상")
    void checkReward() {
        assertThat(Rank.of(3)).isEqualTo(5_000);
        assertThat(Rank.of(4)).isEqualTo(50_000);
        assertThat(Rank.of(5)).isEqualTo(1_500_000);
        assertThat(Rank.of(6)).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("count 목록")
    void countList() {
        assertThat(Rank.getCountList()).containsExactly(3, 4, 5, 6);
    }
}
