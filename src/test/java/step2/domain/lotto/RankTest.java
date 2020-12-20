package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.domain.Rank.*;

public class RankTest {

    @Test
    @DisplayName("당첨 순위 테스트")
    void rankTest() {
        assertThat(getRank(6, false)).isEqualTo(FIRST);
        assertThat(getRank(5, true)).isEqualTo(SECOND);
        assertThat(getRank(5, false)).isEqualTo(THIRD);
        assertThat(getRank(4, true)).isEqualTo(FOURTH);
        assertThat(getRank(3, false)).isEqualTo(FIFTH);
        assertThat(getRank(2, true)).isEqualTo(MISS);
        assertThat(getRank(1, false)).isEqualTo(MISS);
        assertThat(getRank(0, true)).isEqualTo(MISS);
    }
}
