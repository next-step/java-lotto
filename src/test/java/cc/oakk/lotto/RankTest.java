package cc.oakk.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RankTest {
    @Test
    public void getRankByMatchingCount() {
        assertThat(Rank.getRankByMatchingCount(0)).isEqualTo(Rank.SEVENTH);
        assertThat(Rank.getRankByMatchingCount(1)).isEqualTo(Rank.SIXTH);
        assertThat(Rank.getRankByMatchingCount(2)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRankByMatchingCount(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRankByMatchingCount(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRankByMatchingCount(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRankByMatchingCount(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void getRankByMatchingCount_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.getRankByMatchingCount(Integer.MAX_VALUE));
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.getRankByMatchingCount(7));
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.getRankByMatchingCount(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.getRankByMatchingCount(Integer.MIN_VALUE));
    }
}
