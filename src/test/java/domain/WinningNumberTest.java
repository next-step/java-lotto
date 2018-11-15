package domain;

import domain.winningStatus.WinningStatus;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 로또_1등() {
        Lotto lotto = TestUtil.makeLotto(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 4, 5, 6);

        WinningStatus status = TestUtil.makeLottoGames(lotto).match(winningNumber);

        assertThat(status.getPrizeCount(Prize.FIRST_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_2등() {
        Lotto lotto = TestUtil.makeLotto(1, 2, 3, 4, 5, 10);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 4, 5, 7);

        WinningStatus status = TestUtil.makeLottoGames(lotto).match(winningNumber);

        assertThat(status.getPrizeCount(Prize.SECOND_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_3등() {
        Lotto lotto = TestUtil.makeLotto(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 4, 5, 7);

        WinningStatus status = TestUtil.makeLottoGames(lotto).match(winningNumber);

        assertThat(status.getPrizeCount(Prize.THIRD_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_4등() {
        Lotto lotto = TestUtil.makeLotto(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 4, 7, 8);

        WinningStatus status = TestUtil.makeLottoGames(lotto).match(winningNumber);

        assertThat(status.getPrizeCount(Prize.FOURTH_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_5등() {
        Lotto lotto = TestUtil.makeLotto(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = TestUtil.makeWinningNumber(10, 1, 2, 3, 7, 8, 9);

        WinningStatus status = TestUtil.makeLottoGames(lotto).match(winningNumber);

        assertThat(status.getPrizeCount(Prize.FIFTH_PRIZE)).isEqualTo(1);
    }
}
