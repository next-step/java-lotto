package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

    public LottoTest() throws Exception {
    }

    @Test
    void checkWhetherToWinTest_1등() throws Exception {
        Lotto winningLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

        assertThat(lotto.checkWhetherToWin(winningLotto,7)).isEqualTo(LottoPrize.FIRST_PRIZE);
    }

    @Test
    void checkWhetherToWinTest_2등() throws Exception {
        Lotto winningLotto = Lotto.of(Arrays.asList(1,2,3,4,5,7));

        assertThat(lotto.checkWhetherToWin(winningLotto,6)).isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @Test
    void checkWhetherToWinTest_3등() throws Exception {
        Lotto winningLotto = Lotto.of(Arrays.asList(1,2,3,4,5,7));

        assertThat(lotto.checkWhetherToWin(winningLotto,9)).isEqualTo(LottoPrize.THIRD_PRIZE);
    }
}
