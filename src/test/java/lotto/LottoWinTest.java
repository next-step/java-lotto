package lotto;

import lotto.domain.LottoWin;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTest {
    private static int WIN_EARNING_BY_THREE = 5000;
    private static int WIN_EARNING_BY_FOUR = 50000;
    private static int WIN_EARNING_BY_FIVE = 1500000;
    private static int WIN_EARNING_BY_SIX = 2000000000;

    private LottoWin earning;

    @Test
    void 로또가_3개의번호를_맞는다() {
        earning = new LottoWin(3);
        assertThat(earning.getEarning()).isEqualTo(WIN_EARNING_BY_THREE);
    }

    @Test
    void 로또가_4개의번호를_맞는다() {
        earning = new LottoWin(4);
        assertThat(earning.getEarning()).isEqualTo(WIN_EARNING_BY_FOUR);
    }

    @Test
    void 로또가_5개의번호를_맞는다() {
        earning = new LottoWin(5);
        assertThat(earning.getEarning()).isEqualTo(WIN_EARNING_BY_FIVE);
    }

    @Test
    void 로또가_6개의번호를_맞는다() {
        earning = new LottoWin(6);
        assertThat(earning.getEarning()).isEqualTo(WIN_EARNING_BY_SIX);
    }
}
