package domain.winningStatus;

import domain.Lotto;
import domain.TestUtil;
import domain.WinningNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralWinningStatusTest {

    @Test
    public void 수익률_계산() {
        Lotto lotto1 = TestUtil.makeLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = TestUtil.makeLotto(8, 9, 10, 11, 12, 13);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 4, 5, 6);

        WinningStatus status = TestUtil.makeLottoGames(lotto1, lotto2).match(winningNumber);

        assertThat(status.getProfit()).isEqualTo(0.5);
    }
}
