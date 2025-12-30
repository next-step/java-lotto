package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("일치 개수로 당첨 등수를 찾는다")
    void findRankByMatchCount() {
        assertThat(Rank.from(3)).isEqualTo(Rank.THREE);
        assertThat(Rank.from(6)).isEqualTo(Rank.SIX);
    }

    @Test
    @DisplayName("당첨이 아닌 개수로 조회하면 예외가 발생한다")
    void invalidMatchCountThrowsException() {
        assertThatThrownBy(() -> Rank.from(2))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 여부는 3~6개만 true다")
    void winningCheck() {
        assertThat(Rank.isWinning(2)).isFalse();
        assertThat(Rank.isWinning(3)).isTrue();
        assertThat(Rank.isWinning(6)).isTrue();
    }
}
