package autolotto.machine.winning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void 매칭_개수가_3_일_경우_당첨금이_5000원임을_알려준다() {
        int matchCount = 3;

        int winnings = Winning.winningOf(matchCount).winningMoney();

        Assertions.assertThat(winnings).isEqualTo(5000);
    }

    @Test
    void 당첨금을_받을_수_없는_경우_예외를_던진다() {
        int matchCount = 2;

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Winning.winningOf(matchCount));
    }

    @Test
    void 최소_당첨금을_받을_수_있는_matchCount_를_알려준다() {
        int minimumMatchCount = Winning.minWinningMatchCount();

        Assertions.assertThat(minimumMatchCount).isEqualTo(3);
    }
}
