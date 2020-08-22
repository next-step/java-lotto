package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
    }

    @Test
    @DisplayName("당첨된 순위 확인")
    void winningResult() {
        winningResult.putRank(Rank.FIRST);
        winningResult.putRank(Rank.FIRST);
        winningResult.putRank(Rank.FIRST);
        assertThat(winningResult.getWinningResult(Rank.FIRST)).isEqualTo(3);

        winningResult.putRank(Rank.LOSING);
        assertThat(winningResult.getWinningResult(Rank.LOSING)).isEqualTo(1);
    }

}
