package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void calculate() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 11, 12, 13), 14);
        Lottos lottos = makeLottos();

        RankCount rankCount = new RankCount();
        for (Lotto lotto : lottos.getLottos()) {
            rankCount.countRank(lotto, winningNumbers);
        }

        assertThat(Calculator.calculate(lottos, rankCount)).isEqualTo(5.0);
    }

    private Lottos makeLottos() {
        Lottos lottos = new Lottos(2000, 2);
        Lotto lotto1 = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        lottos.saveLotto(Arrays.asList(lotto1, lotto2));
        return lottos;
    }
}
