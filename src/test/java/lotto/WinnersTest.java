package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    void 당첨자찾기() {

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);
        Winners winners = new Winners(winningNumbers, 7);
        winners.addWinner(lotto, 6);
        Winners compareWinners = new Winners(winningNumbers, 7);
        compareWinners.findWinners(lotto);
        assertThat(winners).isEqualTo(compareWinners);
    }

    @Test
    void 총수익률계산() {
        int buyMoney = 10000;

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);
        Winners winners = new Winners(winningNumbers, 7);
        winners.addWinner(lotto, 3);

        assertThat(winners.revenue(buyMoney)).isEqualTo(0.50);
    }
}
