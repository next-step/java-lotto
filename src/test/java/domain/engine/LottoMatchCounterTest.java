package domain.engine;

import domain.model.Lotto;
import domain.model.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchCounterTest {
    @Test
    void countMatchesTest() {
        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto lotto3 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        LottoMatchCounter lottoMatchCounter = new LottoMatchCounter(winNumbers);
        Map<Integer, Integer> matchCount = lottoMatchCounter.countMatches(lottos);

        assertThat(matchCount).containsEntry(3, 1);
        assertThat(matchCount).containsEntry(4, 1);
        assertThat(matchCount).doesNotContainKey(5);
        assertThat(matchCount).doesNotContainKey(6);
    }

    @Test
    void calculateProfitTest() {
        Map<Integer, Integer> matchCount = new HashMap<>();
        matchCount.put(3, 1);
        matchCount.put(4, 1);

        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoMatchCounter lottoMatchCounter = new LottoMatchCounter(winNumbers);

        double profit = lottoMatchCounter.calculateProfit(matchCount, 1000);

        assertThat(profit).isEqualTo(55.0);
    }
}
