package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static lotto.model.sample.LottoSample.*;
import static org.assertj.core.api.Assertions.assertThat;


class LottoPlaceCounterTest {

    @ParameterizedTest
    @EnumSource(value = Place.class)
    @DisplayName("모든 순위의 카운팅이 제대로 되어야 한다")
    public void countExceptSecond(Place place) {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);
        Lotto lotto = lottos.get(place);
        counter.count(lotto);

        assertThat(counter.get(place)).isEqualTo(1);
    }

    @Test
    @DisplayName("카운팅한 총 개수를 반환할 수 있다")
    public void total() {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        assertThat(counter.total()).isZero();
        Lotto sample = lottos.get(Place.FIRST);

        counter.count(sample);
        counter.count(sample);

        assertThat(counter.total()).isEqualTo(2);
    }
}