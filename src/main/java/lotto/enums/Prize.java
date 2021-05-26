package lotto.enums;

import java.util.Arrays;

import lotto.error.ErrorMessage;
import lotto.lotto.LottoResult;


public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6, 2000000000);

    int matchingCount;
    int money;

    Prize(int matchingCount, int money) {
        this.matchingCount = matchingCount;
        this.money = money;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int money() {
        return money;
    }

    public int income(LottoResult lottoResult) {
        return money * lottoResult.count(this);
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        Prize prize = Arrays.stream(values())
                .filter(v -> v.matchingCount == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRIZE_ENUM));

        if (prize.matchingCount == THIRD.matchingCount && matchBonus) {
            return SECOND;
        }

        return prize;
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }
}