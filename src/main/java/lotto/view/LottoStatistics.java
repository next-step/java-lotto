package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.type.MatchType;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final int quantity;
    private final List<MatchType> store;

    public LottoStatistics(List<MatchType> types) {
        this.quantity = types.size();
        store = types.stream()
                .filter(type -> !type.equals(MatchType.ZERO))
                .collect(Collectors.toList());
    }

    public String benefit() {
        long prize = getAllPrize();
        if (prize == 0) {
            return "0";
        }

        return String.format("%.2f", prize / (Lotto.PRICE * (double) quantity));
    }

    private long getAllPrize() {
        long sum = 0;
        for (MatchType matchType : store) {
            sum += matchType.reward();
        }

        return sum;
    }

    public int getMatchCount(MatchType type) {
        return (int) store.stream().
                filter(t -> t.name().equals(type.name()))
                .count();
    }
}
