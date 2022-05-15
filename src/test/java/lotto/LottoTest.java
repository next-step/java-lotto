package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또번호생성() {
        Lottos lottos = new Lottos(3);
        assertThat(lottos.toString().split("]\n").length).isEqualTo(3);

    }

    @Test
    void 당첨자찾기() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumber);
        Winners winners = new Winners();
        winners.addWinner(6);

        WinningNumbers winningNumbers = new WinningNumbers(lotto);
        winningNumbers.findWinners(lotto);
        assertThat(winningNumbers.isWinners(winners)).isTrue();

    }

    @Test
    void 총수익률계산() {
        int buyMoney = 10000;

        Winners winners = new Winners();
        winners.addWinner(3);

        assertThat(winners.revenue(buyMoney)).isEqualTo(0.50);
    }
}