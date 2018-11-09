package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatusTest {

    @Test
    public void 로또_1등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningStatus status = new WinningStatus(Collections.singletonList(lotto), winningNumber);

        assertThat(status.getPrizeCount(Prize.FIRST_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7));

        WinningStatus status = new WinningStatus(Collections.singletonList(lotto), winningNumber);

        assertThat(status.getPrizeCount(Prize.SECOND_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_3등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 7, 8));

        WinningStatus status = new WinningStatus(Collections.singletonList(lotto), winningNumber);

        assertThat(status.getPrizeCount(Prize.THIRD_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 로또_4등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 7, 8, 9));

        WinningStatus status = new WinningStatus(Collections.singletonList(lotto), winningNumber);

        assertThat(status.getPrizeCount(Prize.FOURTH_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 수익률_계산() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningStatus status = new WinningStatus(Arrays.asList(lotto1, lotto2), winningNumber);

        assertThat(status.getProfit()).isEqualTo(0.5);
    }
}
