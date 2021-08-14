package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(new LottoMatch(6, false), 2_000_000_000),
    SECOND(new LottoMatch(5, true), 1_500_000),
    SECOND_BONUS(new LottoMatch(5, false), 1_500_000),
    THIRD(new LottoMatch(4, false), 50_000),
    FOURTH(new LottoMatch(3, false), 5000),
    NO_RANK(new LottoMatch(0, false), 0);

    private final LottoMatch lottoMatch;
    private final int prizeMoney;

    Rank(LottoMatch lottoMatch, int prizeMoney) {
        this.lottoMatch = lottoMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank fromLottoMatch(LottoMatch lottoMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.lottoMatch.equals(lottoMatch))
                .findFirst()
                .orElse(Rank.NO_RANK);
    }

    public LottoMatch getLottoMatch() {
        return lottoMatch;
    }
}
