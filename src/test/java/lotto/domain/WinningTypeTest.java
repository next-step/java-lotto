package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningTypeTest {
    @Test
    void matchTest() {
        Assertions.assertThat(WinningType.match(1, false)).isEqualTo(WinningType.NONE);
        Assertions.assertThat(WinningType.match(2, false)).isEqualTo(WinningType.NONE);
        Assertions.assertThat(WinningType.match(3, false)).isEqualTo(WinningType.THREE);
        Assertions.assertThat(WinningType.match(4, false)).isEqualTo(WinningType.FOUR);
        Assertions.assertThat(WinningType.match(5, true)).isEqualTo(WinningType.FIVE_BONUS);
        Assertions.assertThat(WinningType.match(6, false)).isEqualTo(WinningType.SIX);
        Assertions.assertThat(WinningType.match(6, true)).isEqualTo(WinningType.SIX);
    }
}
