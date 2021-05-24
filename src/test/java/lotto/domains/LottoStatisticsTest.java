package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    @Test
    void 생성자_테스트() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        assertThat(lottoStatistics.count(1)).isEqualTo(0);
    }

    @Test
    void add_테스트() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.add(3);
        lottoStatistics.add(3);
        assertThat(lottoStatistics.count(3)).isEqualTo(2);
        assertThat(lottoStatistics.totalPayout()).isEqualTo(10000);
    }

    @Test
    void 수익률_테스트() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.add(3);
        lottoStatistics.add(3);
        assertThat(lottoStatistics.rateOfReturn(100000)).isEqualTo(0.10);
    }
}
