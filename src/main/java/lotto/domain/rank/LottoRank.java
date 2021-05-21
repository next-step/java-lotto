package lotto.domain.rank;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatched;
    private long amount;

    LottoRank(int countOfMatched, long amount) {
        this.countOfMatched = countOfMatched;
        this.amount = amount;
    }

    public static LottoRank valueOf(int countOfMatched) {
        return Arrays.stream(values())
                .filter(item -> item.getCountOfMatched() == countOfMatched)
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatched() {
        return countOfMatched;
    }

    public long getAmount() {
        return amount;
    }
}
