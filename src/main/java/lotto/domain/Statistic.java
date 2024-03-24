package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Statistic {

    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6),
    NONE(0, 0, 1, 2);

    Statistic(int price, int... matcher) {
        this.price = price;
        this.matchers = Arrays
                .stream(matcher)
                .boxed()
                .collect(Collectors.toList());
    }

    private int price;
    private List<Integer> matchers;

    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return this != NONE;
    }

    public Integer getMatcher() {
        if(isValid()) {
            return matchers.get(0);
        }
        return 0;
    }

    public boolean isMatch(int featNumberCount) {
        return this.matchers.stream()
                .anyMatch(matcher -> matcher == featNumberCount);
    }

    public static Statistic valueOfMatchNumber(int featNumberCount) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.isMatch(featNumberCount))
                .findFirst()
                .orElseThrow();
    }
}
