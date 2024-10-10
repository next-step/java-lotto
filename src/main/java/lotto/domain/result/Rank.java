package lotto.domain.result;

import lotto.domain.money.Money;

import java.util.Arrays;

public enum Rank {

    NONE(0, Money.of(0)),
    FOURTH(3, Money.of(5_000)),
    THIRD(4, Money.of(50_000)),
    SECOND(5, Money.of(1_500_000)),
    FIRST(6, Money.of(2_000_000_000))
    ;

    private final long matchCount;
    private final Money money;

    Rank(long matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank of(long matchCount) {
        return getRank(matchCount);
    }

    public long getPrize() {
        return money.getAmount();
    }

    public static Rank getRank(long matchCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public String getResultForRow(int matchedLottoCount) {
        return String.format("%s개 일치 (%s원)- %s개", matchCount, money.getAmount(), matchedLottoCount);
    }
}
