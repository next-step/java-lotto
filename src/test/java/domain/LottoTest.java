package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

    public LottoTest() throws Exception {
    }

    @Test
    void checkWhetherToWinTest() throws Exception {
        Lotto winningLotto = Lotto.of(Arrays.asList(1,2,3,4,5,7));

        assertThat(lotto.checkWhetherToWin(winningLotto,6)).isEqualTo(LottoPrize.SECOND_PRIZE);
    }
}
