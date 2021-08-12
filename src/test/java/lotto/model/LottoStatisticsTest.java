package lotto.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {
    @Test
    @DisplayName("입력받은 LottoResults 로 각 등수 당첨 횟수를 반환한다")
    public void count() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.FIRST, LottoResult.FIRST, LottoResult.THIRD, LottoResult.FOURTH));
        LottoStatistics statistics = new LottoStatistics(lottoResults, new Money(10000));

        assertThat(statistics.count(LottoResult.FIRST)).isEqualTo(2);
        assertThat(statistics.count(LottoResult.SECOND)).isEqualTo(0);
        assertThat(statistics.count(LottoResult.THIRD)).isEqualTo(1);
        assertThat(statistics.count(LottoResult.FOURTH)).isEqualTo(1);
        assertThat(statistics.count(LottoResult.LOSE)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 LottoResults 와 Money 로 수익률을 반환한다")
    public void profitRate() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.FOURTH));
        LottoStatistics statistics = new LottoStatistics(lottoResults, new Money(20000));

        assertThat(statistics.calculateProfitRate()).isCloseTo(0.25, Offset.offset(0.01));
    }
}