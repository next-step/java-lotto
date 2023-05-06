package lotto.domian;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000)
    ;

    private int matchingCount;
    private int money;

    Rank(int matchingCount, int money) {
        this.matchingCount = matchingCount;
        this.money = money;
    }

    public static Rank find(int matchingCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("맞힌 갯수에 해당하는 당첨금이 없습니다.");
                });
    }


}
