package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @Test
    void 수익률_구하기_한장_사서_3개_맞춤() {
        LottoStatistics lottoStatistics =
                new LottoStatistics(new BuyLotto(1000, new LottoGenerator(1, 6))
                        , new LottoWinningNumbers("1,2,3,7,8,9",10));
        assertThat(lottoStatistics.statistics()).isEqualTo(5);
    }
}