package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {
    private final int PRIZE_AMT = 1505000;

    private Lottoes custom_lottoes;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottoCustom = new ArrayList<>();
        lottoCustom.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoCustom.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        lottoCustom.add(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
        custom_lottoes = new Lottoes(lottoCustom);
    }

    @Test
    public void 로또결과_1등_한명_당첨() {
        List<Integer> WINNER_NUMBERS = Arrays.asList(4, 5, 6, 7, 8, 9);
        int bonusBall = 5;
        assertThat(custom_lottoes.checkLotteryWin(WINNER_NUMBERS, bonusBall).get(6)).isEqualTo(1);
    }

    @Test
    public void 로또수익률() {
        assertThat(custom_lottoes.calculateRateProfit(PRIZE_AMT, 3_000)).isEqualTo((double)PRIZE_AMT/3000);
    }
}