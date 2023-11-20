package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {


    @DisplayName("일등 테스트")
    @Test
    public void 일등() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("이등 테스트")
    @Test
    public void 이등() {
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("삼등 테스트")
    @Test
    public void 삼등() {
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("사등 테스트")
    @Test
    public void 사등() {
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
    }

}
