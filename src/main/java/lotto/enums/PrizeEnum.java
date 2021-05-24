package lotto.enums;

import lotto.lotto.LottoResult;

public enum PrizeEnum {
    FOURTH(3, 5000),
    THIRD(4,50000),
    SECOND(5,1500000),
    FIRST(6, 2000000000);

    int matchingCount;
    int prize;

    PrizeEnum(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prize() {
        return prize;
    }

    public int income(LottoResult lottoResult) {
        return prize * lottoResult.count(matchingCount);
    }
}