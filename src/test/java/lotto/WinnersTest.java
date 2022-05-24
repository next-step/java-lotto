package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 당첨자찾기() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, 7);
        Winners winners = new Winners();
        winners.findWinners(lotto, winningNumbers);

        Winners compareWinners = new Winners();
        compareWinners.addWinner(WinningsType.일등);
        assertThat(winners).isEqualTo(compareWinners);
    }

    @Test
    void 총수익률계산() {
        int buyMoney = 10000;
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumber);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10);
        Winners winners = new Winners();
        winners.findWinners(lotto, winningNumbers);
        assertThat(winners.revenue(buyMoney)).isEqualTo(0.50);
    }
}
