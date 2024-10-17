package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Integer> winNumbers;

    public Winners(String text) {
        this.winNumbers = parse(text);
    }

    public Statistics match(Orders orders) {
        Statistics statistics = new Statistics();

        orders.getOrders().stream()
                .map(this::match)
                .filter(n -> n >= 3)
                .forEach(n -> statistics.put(n, statistics.get(n) + 1));

        return statistics;
    }

    private int match(Lotto lotto) {
        return (int) this.winNumbers.stream().filter(lotto::contains).count();
    }

    private List<Integer> parse(String text) {
        if (isEmpty(text)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(text.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
