package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMoneyCalculatorTest {

    @Test
    void getTotalWinningMoney_1등4등당첨_2000050000() {
        Lotto lotto1 = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 7, 8, 9})
                .collect(Collectors.toList()));
        Lottos lottos = new Lottos();
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));

        int totalWinningMoney = WinningMoneyCalculator.getTotalWinningMoney(winningLotto, lottos);

        assertThat(totalWinningMoney).isEqualTo(WinningMoneyCalculator.FIRST_RANK_MONEY + WinningMoneyCalculator.FOURTH_RANK_MONEY);
    }

}
