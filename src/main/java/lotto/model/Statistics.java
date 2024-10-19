package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Statistics {

    List<Long> matchingCounts;
    Double profit;

    public Statistics(List<Long> matchingCounts, Double profit) {
        this.matchingCounts = matchingCounts;
        this.profit = profit;
    }

    public void forEachMatchingCount(BiConsumer<Integer, Long> consumer) {
        for (int i = 0 ; i < matchingCounts.size() ; i++) {
            consumer.accept(i, matchingCounts.get(i));
        }
    }

    public void applyToProfit(Consumer consumer) {
        consumer.accept(this.profit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics)) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(matchingCounts, that.matchingCounts) && Objects.equals(profit, that.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingCounts, profit);
    }

}
