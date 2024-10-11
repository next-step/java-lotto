package lotto.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrizeMonies {
    private final List<PrizeMoney> prizeMonies;

    public PrizeMonies() {
        this.prizeMonies = Stream.of(PrizeMoney.values()).collect(Collectors.toList());
    }

    public PrizeMoney result(int collectCount) {
        return this.prizeMonies.stream().filter(i -> i.isMatch(collectCount)).findFirst().orElse(null);
    }
}
