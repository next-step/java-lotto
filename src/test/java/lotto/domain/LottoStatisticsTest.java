package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStatisticsTest {

    @Test
    void LottoStatistics는_earningRate없이_생성할_시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoStatistics(null, new LottoPrizes(List.of(LottoPrize.FIRST)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoStatistics는_lottoPrizes없이_생성할_시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoStatistics(new EarningRate(0.0), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoStatistics는_LottoPrizes로_생성_가능하다() {
        assertThat(LottoStatistics.from(new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH))))
                .isInstanceOf(LottoStatistics.class);
    }
}
