package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(LottoMatch.of(0, Boolean.FALSE), 0),
    FIFTH(LottoMatch.of(3, Boolean.FALSE), 5_000),
    FOURTH(LottoMatch.of(4, Boolean.FALSE), 50_000),
    THIRD(LottoMatch.of(5, Boolean.FALSE), 1_500_000),
    SECOND(LottoMatch.of(5, Boolean.TRUE), 30_000_000),
    FIRST(LottoMatch.of(6, Boolean.FALSE), 2_000_000_000);

    private final LottoMatch lottoMatch;
    private final int money;

    Rank(LottoMatch lottoMatch, int money) {
        this.lottoMatch = lottoMatch;
        this.money = money;
    }

    public static Rank from(LottoMatch match) {
        return Arrays.stream(values())
                .filter(rank -> rank.lottoMatch.equals(match))
                .findFirst()
                .orElse(NOTHING);
    }

    public int matchCount() {
        return lottoMatch.matchCount();
    }

    public int price() {
        return this.money;
    }

    public long calcTotalPrice(int count) {
        return (long) this.money * count;
    }

}
