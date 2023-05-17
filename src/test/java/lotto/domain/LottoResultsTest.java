package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {

    @Test
    void 당첨금_총합_조회() {
        Map<Rank, Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.FIFTH, 100);
        winningStats.put(Rank.THIRD, 1);
        winningStats.put(Rank.FOURTH, 1);
        LottoResults lottoResults = new LottoResults(winningStats);

        Money reward = lottoResults.totalReward();
        int expect = Rank.THIRD.reward() + Rank.FOURTH.reward();
        assertThat(reward).isEqualTo(new Money(expect));
    }
}
