package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTypeTest {

    @Test
    void validValueOfBonusType() {
        int matchCount = 5;
        boolean isBonusNumber = true;
        WinningLottoType winningLottoType = WinningLottoType.valueOf(matchCount, isBonusNumber);
        assertThat(winningLottoType).isEqualTo(WinningLottoType.MATCH_FIVE_BONUS);
    }

    @Test
    void validValueOfWinningType() {
        int matchCount = 4;
        boolean isBonusNumber = false;
        WinningLottoType winningLottoType = WinningLottoType.valueOf(matchCount, isBonusNumber);
        assertThat(winningLottoType).isEqualTo(WinningLottoType.MATCH_FOUR);
    }
}