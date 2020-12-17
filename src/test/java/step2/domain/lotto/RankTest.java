package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.domain.Rank.*;

public class RankTest {

    @Test
    @DisplayName("당첨 순위 테스트")
    void rankTest() {
        assertThat(getRank(6)).isEqualTo(FIRST);
        assertThat(getRank(5)).isEqualTo(THIRD);
        assertThat(getRank(4)).isEqualTo(FOURTH);
        assertThat(getRank(3)).isEqualTo(FIFTH);
        assertThat(getRank(2)).isEqualTo(MISS);
        assertThat(getRank(1)).isEqualTo(MISS);
        assertThat(getRank(0)).isEqualTo(MISS);
    }
}
