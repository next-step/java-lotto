package lotto.model.dto;

import lotto.model.LottoPlaceCounter;
import lotto.model.Place;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

public class LottoPlaceCounterDto {
    private final Map<Place, Integer> counter;

    private LottoPlaceCounterDto(Map<Place, Integer> counter) {
        this.counter = unmodifiableMap(counter);
    }

    public static LottoPlaceCounterDto from(LottoPlaceCounter counter) {
        return from(counter.entrySet());
    }

    public static LottoPlaceCounterDto from(Iterable<Map.Entry<Place, Integer>> items) {
        Map<Place, Integer> copiedCounter = new HashMap<>();

        for (var item : items) {
            copiedCounter.put(item.getKey(), item.getValue());
        }
        return new LottoPlaceCounterDto(copiedCounter);
    }

    public int count(Place place) {
        return counter.get(place);
    }
}
