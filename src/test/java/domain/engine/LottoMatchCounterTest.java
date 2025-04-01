package domain.engine;

import domain.model.LottoNumbers;
import domain.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchCounterTest {
    @DisplayName("Lotto의 list를 받아 당첨 번호와 일치하는 개수를 카운트한다.")
    @Test
    void countMatchesTest() {
        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));
        LottoNumbers lotto2 = new LottoNumbers(List.of(1, 2, 3, 4, 7, 8));
        LottoNumbers lotto3 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));
        List<LottoNumbers> lottos = List.of(lotto1, lotto2, lotto3);

        LottoMatchCounter lottoMatchCounter = new LottoMatchCounter(winNumbers);
        Map<Integer, Integer> matchCount = lottoMatchCounter.countMatches(lottos);

        assertThat(matchCount).containsEntry(3, 1);
        assertThat(matchCount).containsEntry(4, 1);
        assertThat(matchCount).doesNotContainKey(5);
        assertThat(matchCount).doesNotContainKey(6);
    }

    @DisplayName("당첨 번호와 일치하는 개수에 따라 수익률을 계산한다.")
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
