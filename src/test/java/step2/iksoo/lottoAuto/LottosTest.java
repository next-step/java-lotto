package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final int PRIZE_AMT = 1505000;
    private final List<Integer> WINNER_NUMBERS = Arrays.asList(new Integer[]{4, 5, 6, 7, 8, 9});

    private Lottos custom_lottos;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottoCustom = new ArrayList<>();
        lottoCustom.add(new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        lottoCustom.add(new Lotto(Arrays.asList(new Integer[]{4, 5, 6, 7, 8, 9})));
        lottoCustom.add(new Lotto(Arrays.asList(new Integer[]{6, 7, 8, 9, 10, 11})));
        custom_lottos = new Lottos(lottoCustom);
    }

    @Test
    public void 로또결과_1등_한명_당첨() {
        assertThat(custom_lottos.checkLotteryWin(WINNER_NUMBERS).get(6)).isEqualTo(1);
    }

    @Test
    public void 로또수익률() {
        assertThat(custom_lottos.calculateRateProfit(PRIZE_AMT)).isEqualTo(501.67);
    }
}
