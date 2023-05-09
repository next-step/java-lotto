package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {

    @Test
    void 사융금액_대비_당첨금_비율계산() {
        Money spentMoney = new Money(100000);
        Map<Rank, Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.THIRD, 1);
        winningStats.put(Rank.FOURTH, 2);
        LottoResults lottoResults = new LottoResults(spentMoney, winningStats);

        Double actual = lottoResults.winningRatio();
        assertThat(actual).isEqualTo(0.6);
    }
}
