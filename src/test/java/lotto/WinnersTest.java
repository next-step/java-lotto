package lotto;

import lotto.domain.Lotto;
import lotto.domain.Winners;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 당첨자찾기() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumber);
        Winners winners = new Winners(lotto);
        winners.findWinners(lotto);

        Winners answerWinners = new Winners(lotto);
        answerWinners.addWinner(6);

        assertThat(winners).isEqualTo(answerWinners);
    }

    @Test
    void 총수익률계산() {
        int buyMoney = 10000;
        Lotto lotto = new Lotto();
        Winners winners = new Winners(lotto);
        winners.addWinner(3);

        assertThat(winners.revenue(buyMoney)).isEqualTo(0.50);
    }
}
