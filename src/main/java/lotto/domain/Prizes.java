package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Map<Prize, Integer> calculateMatchCounts() {
        return prizes.stream()
                .collect(Collectors.groupingBy(prize -> prize, Collectors.summingInt(prize -> 1)));
    }

}
