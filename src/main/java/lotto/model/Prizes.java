package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public int total() {
        return prizes.stream().map(Prize::getPrizeMoney).reduce(0, Integer::sum);
    }
}
