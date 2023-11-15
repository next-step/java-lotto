package src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Place {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    OTHER(2, 0);

    private final int matchCount;

    private final double amount;

    Place(int matchCount, double amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Place byMatchCount(int matchCount, boolean matchBonus) {
        Place place = Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(Place.OTHER);
        if (place.matchCount == 5 && !matchBonus) {
            return THIRD_PLACE;
        }

        return place;
    }



    public int matchCount() {
        return matchCount;
    }

    public double amount() {
        return amount;
    }

    public static List<Place> winningPlaces() {
        return Arrays.stream(values())
                .filter(place -> place.amount > 0)
                .collect(Collectors.toList());
    }
}
