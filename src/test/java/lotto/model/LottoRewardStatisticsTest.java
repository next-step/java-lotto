package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static lotto.model.Place.*;
import static lotto.model.sample.LottoSample.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardStatisticsTest {

    private List<Lotto> getCountOfLottos(Place place, int count) {
        return Collections.nCopies(count, place2Lotto.get(place));
    }

    @ParameterizedTest
    @CsvSource(value = {"5=1.00", "10=0.50", "100=0.05"}, delimiter = '=')
    @DisplayName("수익률을 올바르게 계산해야 한다")
    public void profit(int totalLottos, float expected) {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        List<Lotto> noneLottos = getCountOfLottos(NONE, totalLottos - 1);
        counter.countAll(noneLottos);
        counter.count(place2Lotto.get(FIFTH));

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);

        assertThat(statistics.profit()).isEqualTo(expected);

    }

    @Test
    @DisplayName("총 상금 금액을 알 수 있다")
    public void winnerRewards() {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        for (Place place : winners()) {
            Lotto winLotto = place2Lotto.get(place);
            counter.count(winLotto);
        }

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);
        int sum = winners().stream()
                .mapToInt(Place::reward)
                .sum();

        assertThat(statistics.winnerRewards()).isEqualTo(sum);

    }
}