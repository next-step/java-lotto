package src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Place {
    FIRST_PLACE(6, 2_000_000_000, (matchCount, bonusMatch) ->
            matchCount == 6 && bonusMatch == Boolean.FALSE),
    SECOND_PLACE(5, 30_000_000, (matchCount, bonusMatch) ->
            matchCount == 5 && bonusMatch == Boolean.TRUE),

    THIRD_PLACE(5,1_500_000, (matchCount, bonusMatch) ->
            matchCount == 5 && bonusMatch == Boolean.FALSE),

    FOURTH_PLACE(4,50_000, (matchCount, bonusMatch) ->
            matchCount == 4 && bonusMatch == Boolean.FALSE),

    FIFTH_PLACE(3,5_000, (matchCount, bonusMatch) ->
            matchCount == 3 && bonusMatch == Boolean.FALSE),

    OTHER(2,0, (matchCount, bonusMatch) ->
            matchCount == 2 && bonusMatch == Boolean.FALSE);

    private final int matchCount;

    private final double amount;

    private final BiPredicate<Integer, Boolean> match;

    Place(int matchCount, double amount, BiPredicate<Integer, Boolean> match) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.match = match;
    }

    public static Place byMatchCount(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(value -> value.match.test(matchCount, matchBonus))
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
