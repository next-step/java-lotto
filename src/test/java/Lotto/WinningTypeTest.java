package Lotto;

import Lotto.domain.WinningType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTypeTest {
    @Test
    void getWinningTypeWithCountOfMatch() {
        final int countOfMatch = 3;
        assertThat(WinningType.valueOf(countOfMatch)).isEqualTo(WinningType.FIFTH);
    }
}
