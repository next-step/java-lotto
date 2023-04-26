package lotto.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum Place {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, Place> match2Place = stream(Place.values())
            .collect(toMap(place -> place.matches, place -> place));
    private final int matches;
    private final int reward;

    Place(int matches, int reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public static Place of(int matches) {
        if (match2Place.containsKey(matches)) {
            return match2Place.get(matches);
        }
        return NONE;
    }

    public static List<Place> winners() {
        return stream(Place.values())
                .filter(place -> place != Place.NONE)
                .sorted(Comparator.comparingInt(p -> p.matches))
                .collect(Collectors.toList());
    }

    public int matches() {
        return matches;
    }

    public int reward() {
        return reward;
    }

}
