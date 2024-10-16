package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Statistics {

    private static final List<String> MATCH_STATIC_MESSAGES = List.of("3개 일치 (5000원)- %d개", "4개 일치 (50000원)- %d개", "5개 일치 (1500000원)- %d개", "6개 일치 (2000000000원)- %d개");
    public static final String PROFIT_STATIC_MESSAGE = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    List<Long> matchingCounts;
    Double profit;

    public Statistics(List<Long> matchingCounts, Double profit) {
        this.matchingCounts = matchingCounts;
        this.profit = profit;
    }

    public void foreach(Consumer consumer) {
        for (int i = 0 ; i < matchingCounts.size() ; i++) {
            consumer.accept(String.format(MATCH_STATIC_MESSAGES.get(i), matchingCounts.get(i)));
        }
        consumer.accept(String.format(PROFIT_STATIC_MESSAGE, this.profit));
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
