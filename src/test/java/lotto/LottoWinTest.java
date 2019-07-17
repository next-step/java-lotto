package lotto;

import lotto.domain.LottoWin;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class LottoWinTest {
    private static int WIN_EARNING_BY_THREE             = 5_000;
    private static int WIN_EARNING_BY_FOUR              = 50_000;
    private static int WIN_EARNING_BY_FIVE              = 150_0000;
    private static int  WIN_EARNING_BY_FIVE_WITH_BONUS  = 3_000_0000;
    private static int WIN_EARNING_BY_SIX               = 2_000_000_000;

    private LottoWin win;

    @Test
    void 로또가_3개의번호를_맞는다() {
        win = LottoWin.valueOf(3, false);
        assertThat(win.getEarning()).isEqualTo(WIN_EARNING_BY_THREE);
    }

    @Test
    void 로또가_4개의번호를_맞는다() {
        win = LottoWin.valueOf(4, false);
        assertThat(win.getEarning()).isEqualTo(WIN_EARNING_BY_FOUR);
    }

    @Test
    void 로또가_5개의번호를_맞는다() {
        win = LottoWin.valueOf(5, false);
        assertThat(win.getEarning()).isEqualTo(WIN_EARNING_BY_FIVE);
    }

    @Test
    void 로또가_5개의번호와_보너스번호를_맞는다() {
        win = LottoWin.valueOf(5, true);
        assertThat(win.getEarning()).isEqualTo(WIN_EARNING_BY_FIVE_WITH_BONUS);
    }

    @Test
    void 로또가_6개의번호를_맞는다() {
        win = LottoWin.valueOf(6, false);
        assertThat(win.getEarning()).isEqualTo(WIN_EARNING_BY_SIX);
    }
}
