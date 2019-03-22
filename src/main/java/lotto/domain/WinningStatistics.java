package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final Map<WinningOrder, Long> values;

    public WinningStatistics(final Map<WinningOrder, Long> values) {
        this.values = initialize();
        this.values.putAll(values);
    }

    public Map<WinningOrder, Long> get() {
        return new HashMap<>(values);
    }

    public double getRoi() {
        return getTotalAmount().divide(getDivisor());
    }

    private Map<WinningOrder, Long> initialize() {
        return Arrays.stream(WinningOrder.values())
                .collect(Collectors.toMap(Function.identity(), l -> 0L))
                ;
    }

    private Money getTotalAmount() {
        return Money.from(
                this.values
                        .entrySet()
                        .stream()
                        .mapToLong(value -> value.getKey().getAmount().get() * value.getValue())
                        .sum()
        );
    }

    private Money getDivisor() {
        final Money amount = Lotto.PRICE.multiply(getCount());
        if (Money.ZERO.equals(amount)) {
            return Money.ONE;
        }
        return amount;
    }

    private long getCount() {
        return this.values
                .values()
                .stream()
                .mapToLong(Long::valueOf)
                .sum()
                ;
    }
}
