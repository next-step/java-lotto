package src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Place {
    FIRST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(5, 1_500_000, false),
    FOURTH_PLACE(4, 50_000, false),
    FIFTH_PLACE(3, 5_000, false),
    OTHER(2, 0, false);

    private final int matchCount;

    private final double amount;

    private final boolean bonus;

    Place(int matchCount, double amount, boolean bonus) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.bonus = bonus;
    }

    private boolean match(int matchCount, boolean matchBonus) {
        return this.matchCount == matchCount && this.bonus == matchBonus;
    }

    public static Place byMatchCount(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(value -> value.match(matchCount, matchBonus))
                .findFirst()
                .orElse(Place.OTHER);
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
