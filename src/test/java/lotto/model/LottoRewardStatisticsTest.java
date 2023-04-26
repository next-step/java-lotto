package lotto.model;

import lotto.model.sample.LottoSample;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardStatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    @DisplayName("수익률을 올바르게 계산해야 한다")
    public void profit(int noneCounts) {
        LottoPlaceCounter counter = new LottoPlaceCounter(LottoSample.CRITERIA);
        counter.count(LottoSample.THIRD);

        for (int count = 0; count < noneCounts; count++) {
            counter.count(LottoSample.NONE);
        }

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);
        int spent = counter.total() * Lotto.PRICE;
        int reward = statistics.winnerRewards();
        float expected = reward / (float) spent;


        float profit = statistics.profit();
        assertThat(profit).isEqualTo(expected);

    }

    @Test
    @DisplayName("총 상금 금액을 알 수 있다")
    public void winnerRewards() {
        LottoPlaceCounter counter = new LottoPlaceCounter(LottoSample.CRITERIA);
        counter.count(LottoSample.FIRST);
        counter.count(LottoSample.SECOND);
        counter.count(LottoSample.THIRD);
        counter.count(LottoSample.FOURTH);

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);
        int sum = Place.winners().stream()
                .mapToInt(Place::reward)
                .sum();

        assertThat(statistics.winnerRewards()).isEqualTo(sum);

    }
}