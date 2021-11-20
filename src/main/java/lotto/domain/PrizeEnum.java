package lotto.domain;

import java.util.List;

public enum PrizeEnum {
    first(6,2_000_000_000),
    second(5, 1_500_000);

    private final int matching;
    private final int prize;

    PrizeEnum(Integer matching,Integer prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public static PrizeEnum findPrize() {

    }

}
