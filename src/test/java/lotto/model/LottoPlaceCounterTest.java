package lotto.model;

import lotto.model.sample.LottoSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoPlaceCounterTest {

    @Test
    @DisplayName("카운팅이 제대로 되어야 한다")
    public void count() {
        LottoPlaceCounter counter = new LottoPlaceCounter(LottoSample.CRITERIA);

        assertThat(Place.values()).allMatch(place -> counter.get(place) == 0);

        counter.count(LottoSample.FIRST);
        counter.count(LottoSample.NONE);

        assertThat(counter.get(Place.FIRST)).isEqualTo(1);
        assertThat(counter.get(Place.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("카운팅한 총 개수를 반환할 수 있다")
    public void total() {
        LottoPlaceCounter counter = new LottoPlaceCounter(LottoSample.CRITERIA);

        assertThat(counter.total()).isZero();

        counter.count(LottoSample.FIRST);
        assertThat(counter.total()).isEqualTo(1);
    }
}