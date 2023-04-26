package lotto.model.dto;

import lotto.model.Place;

public class LottoStatisticsDto {
    private final float profit;
    private final LottoPlaceCounterDto counter;

    public LottoStatisticsDto(float profit, LottoPlaceCounterDto counter) {
        this.profit = profit;
        this.counter = counter;
    }

    public int count(Place place) {
        return counter.count(place);
    }

    public float profit() {
        return profit;
    }
}
