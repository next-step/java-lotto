package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @Test
    @DisplayName("수익률 통계")
    void rateOfReturn() {
        assertThat(lottoStatistics.rateOfReturn(5000,14000)).isEqualTo(0.35);
    }
}