package lotto.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum LottoRank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int count;
    private int money;

    LottoRank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static Optional<LottoRank> getRank(int count) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.count == count)
                .findFirst();
    }
}
