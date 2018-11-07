package raffle.lotto.win;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WinLottoTest {

    @Test
    public void 상금_금액_개수_확인(){
        WinLotto winLotto = WinLotto.search(4);
        assertThat(winLotto.price).isEqualByComparingTo(WinLotto.FOUR_WIN_LOTTO.price);
        assertThat(winLotto.winCount).isEqualByComparingTo(WinLotto.FOUR_WIN_LOTTO.winCount);
    }
}