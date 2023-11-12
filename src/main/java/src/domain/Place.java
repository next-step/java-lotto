package src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Place {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    OTHER(2, 0);

    final int matchedCount;

    final double amount;

    Place(int matchedCount, double amount) {
        this.matchedCount = matchedCount;
        this.amount = amount;
    }

    public static Place byMatchedCount(int matchedCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchedCount == matchedCount)
                .findFirst()
                .orElse(Place.OTHER);
    }

    public int matchedCount() {
        return matchedCount;
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
