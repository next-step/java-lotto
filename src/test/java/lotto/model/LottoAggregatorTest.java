package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAggregatorTest {

    @Test
    @DisplayName("일치된 번호의 수와 당첨 등수 일치")
    public void aggregate() {
        LottoAggregator lottoAggregator = new LottoAggregator();
        lottoAggregator.put(LottoRank.FIRST);
        assertThat(lottoAggregator.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률")
    public void test() {
        LottoAggregator lottoAggregator = new LottoAggregator();
        lottoAggregator.put(LottoRank.FOURTH);
        assertThat(lottoAggregator.getRateOfReturn()).isEqualTo(50);
    }
}
