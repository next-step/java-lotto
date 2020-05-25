package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    @DisplayName("구매금액에 따른 이익률을 반환한다")
    @Test
    void profit() {
        Map<Integer, Integer> statistics = createStatistics();
        LottoResult lottoResult = new LottoResult(statistics);

        assertAll(
                () -> assertThat(lottoResult.getRateOfProfit(60000)).isEqualTo(1),
                () -> assertThat(lottoResult.getRateOfProfit(120000)).isEqualTo(0.5)
        );
    }

    private Map<Integer, Integer> createStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, 2); // 10000
        statistics.put(4, 1); // 50000
        return statistics;
    }

}