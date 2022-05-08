package lottoauto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RatingStatics {
    private Map<Rating, Integer> statics;

    private RatingStatics(Map<Rating, Integer> statics) {
        this.statics = statics;
    }

    public static RatingStatics create() {
        Map<Rating, Integer> ratingStatics = new EnumMap<>(Rating.class);
        Arrays.stream(Rating.values()).forEach(rating -> ratingStatics.put(rating, 0));
        return new RatingStatics(ratingStatics);
    }

    public void put(Rating rating) {
        statics.put(rating, statics.get(rating) + 1);
    }

    public String rateOfReturn(int totalPrice) {
        int sum = statics.entrySet().stream()
                .mapToInt(e -> e.getKey().rewardAmount(e.getValue()))
                .sum();
        return String.valueOf(floorToTwoDecimalPlaces(sum * 1.0 / totalPrice));
    }

    private double floorToTwoDecimalPlaces(double number) {
        return Math.floor(number * 100) / 100.0;
    }

    @Override
    public String toString() {
        return statics.entrySet().stream()
                .filter(set -> !set.getKey().equals(Rating.LOSING))
                .map(set -> set.getKey() + "- " + set.getValue() + "개\n")
                .collect(Collectors.joining());
    }
}
