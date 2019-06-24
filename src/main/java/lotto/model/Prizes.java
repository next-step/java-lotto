package lotto.model;

import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public int getProfits() {
        return prizes.stream().map(Prize::getPrizeMoney).reduce(0, Integer::sum);
    }
}
