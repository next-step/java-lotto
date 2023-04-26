package lotto.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoPlaceCounter {
    private final Lotto matchCriteria;
    private final Map<Place, Integer> counter = new HashMap<>();

    public LottoPlaceCounter(Lotto matchCriteria) {
        this.matchCriteria = matchCriteria;
        init();
    }

    private void init() {
        for (Place place : Place.values()) {
            counter.put(place, 0);
        }
    }

    public void count(Lotto lotto) {
        int matches = matchCriteria.matches(lotto);
        Place place = Place.of(matches);

        counter.put(place, counter.get(place) + 1);
    }

    public void countAll(Iterable<Lotto> lottos) {
        lottos.forEach(this::count);
    }

    public int get(Place place) {
        return counter.get(place);
    }

    public int total() {
        return counter.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Set<Map.Entry<Place, Integer>> entrySet() {
        return counter.entrySet();
    }

    public Collection<Integer> values() {
        return counter.values();
    }
}
