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
        Lotto lotto = place2Lotto.get(place);
        counter.count(lotto);

        assertThat(counter.get(place)).isEqualTo(1);
    }

    @Test
    @DisplayName("카운팅한 총 개수를 반환할 수 있다")
    public void total() {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        for (Place place : Place.values()) {
            counter.count(place2Lotto.get(place));
        }

        int total = Place.values().length;
        assertThat(counter.total()).isEqualTo(total);
    }

    @Test
    @DisplayName("처음엔 모든 등수의 값이 0이어야 한다")
    public void init() {
        LottoPlaceCounter counter = new LottoPlaceCounter(CRITERIA, BONUS);

        for (Place place : Place.values()) {
            assertThat(counter.get(place)).isZero();
        }
        assertThat(counter.total()).isZero();
    }
}