package lotto;

import org.junit.jupiter.api.Test;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    void FIRST() {
        assertThat(valueOf(6, true)).isEqualTo(FIRST);
    }

    @Test
    void SECOND() {
        assertThat(valueOf(5, true)).isEqualTo(SECOND);
    }

    @Test
    void THIRD() {
        assertThat(valueOf(5, false)).isEqualTo(THIRD);
    }

    @Test
    void FOURTH() {
        assertThat(valueOf(4, false)).isEqualTo(FOURTH);
    }

    @Test
    void FIFTH() {
        assertThat(valueOf(3, false)).isEqualTo(FIFTH);
    }

    @Test
    void MISS() {
        assertThat(valueOf(2, false)).isEqualTo(MISS);
    }
}
