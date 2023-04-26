package lotto.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.model.Place.NONE;
import static lotto.model.Place.THIRD;
import static lotto.model.sample.LottoSample.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardStatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    @DisplayName("수익률을 올바르게 계산해야 한다")
    public void profit(int noneCounts) {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);
        Lotto third = lottos.get(THIRD);
        Lotto none = lottos.get(NONE);

        counter.count(third);

        for (int count = 0; count < noneCounts; count++) {
            counter.count(none);
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
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        for (Place place : Place.winners()) {
            Lotto winLotto = lottos.get(place);
            counter.count(winLotto);
        }

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);
        int sum = Place.winners().stream()
                .mapToInt(Place::reward)
                .sum();

        assertThat(statistics.winnerRewards()).isEqualTo(sum);

    }
}