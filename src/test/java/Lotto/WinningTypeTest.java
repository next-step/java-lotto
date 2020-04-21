package Lotto;

import Lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTypeTest {
    @Test
    @DisplayName("5등 테스트")
    void getWinningTypeWithCountOfMatch() {
        final int countOfMatch = 3;
        final boolean hasBonusNumber = false;
        assertThat(WinningType.valueOf(countOfMatch, hasBonusNumber)).isEqualTo(WinningType.FIFTH);
    }

    @Test
    @DisplayName("2등 테스트")
    void getSecondWinning() {
        final int countOfMatch = 5;
        final boolean hasBonusNumber = true;
        assertThat(WinningType.valueOf(countOfMatch, hasBonusNumber)).isEqualTo(WinningType.SECOND);
    }
}
