package lottogame.domain.lotto;

import lottogame.domain.strategy.PredefinedLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("총 상금 계산")
    @Test
    void calculateTotalPrizeAmount() {
        List<Lotto> predefinedLottos = Arrays.asList(
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,7")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,8"))
        );
        Lottos lottos = new Lottos(predefinedLottos);
        Lotto winingLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningResult winningResult = lottos.calculateWinningStatistics(new WinningLotto(winingLotto, bonusNumber));
        double actual = winningResult.calculateTotalPrizeAmount();
        double expected = Rank.FIRST.getPrizeMoney() + Rank.SECOND.getPrizeMoney() + Rank.THIRD.getPrizeMoney();

        assertEquals(expected, actual);
    }
}
