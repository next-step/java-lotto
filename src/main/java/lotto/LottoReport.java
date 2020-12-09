package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoReport {

    private static final int DEFAULT_COUNT = 0;

    private static final int ADD_COUNT = 1;

    private final Map<Rank, Integer> value;

    private LottoReport(final Map<Rank, Integer> value) {
        this.value = Collections.unmodifiableMap(new EnumMap<>(value));
    }

    public static LottoReport of(final Rank... ranks) {
        return of(Arrays.stream(ranks)
                .collect(Collectors.toList()));
    }

    public static LottoReport of(final List<Rank> ranks) {
        Map<Rank, Integer> rankMap = new HashMap<>();
        ranks.forEach(rank -> {
            Integer count = rankMap.getOrDefault(rank, DEFAULT_COUNT);
            rankMap.put(rank, count + ADD_COUNT);
        });
        return new LottoReport(rankMap);
    }

    public int count(final Rank rank) {
        return value.getOrDefault(rank, DEFAULT_COUNT);
    }

    public double profitRate() {
        Money totalReward = totalReward();
        Money purchase = LottoTicket.PRICE.multiply(ticketCount());
        return totalReward.profitRate(purchase);
    }

    private int ticketCount() {
        return value.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(DEFAULT_COUNT);
    }

    private Money totalReward() {
        return value.entrySet()
                .stream()
                .map(entry -> entry.getKey().getReward().multiply(entry.getValue()))
                .reduce(Money::plus)
                .orElse(Money.zero());
    }
}
