package raffle.lotto.win;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WinLottoTest {

    @Test
    public void 상금_금액_개수_확인(){
        WinLotto winLotto = WinLotto.search(4, false);
        assertThat(winLotto.getPrice()).isEqualByComparingTo(WinLotto.FOUR_WIN_LOTTO.getPrice());
        assertThat(winLotto.getWinCount()).isEqualByComparingTo(WinLotto.FOUR_WIN_LOTTO.getWinCount());
    }
}