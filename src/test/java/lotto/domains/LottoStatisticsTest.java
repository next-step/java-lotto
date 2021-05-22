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
        lottoStatistics.add(1);
        lottoStatistics.add(1);
        assertThat(lottoStatistics.count(1)).isEqualTo(2);
        assertThat(lottoStatistics.totalPayout()).isEqualTo(10000);
    }
}
