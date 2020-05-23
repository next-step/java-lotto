package lotto.domain;

import java.util.Arrays;

public enum LottoMatch {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private int count;
    private long amount;

    LottoMatch(int count, long amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return this.count;
    }

    public long getAmount() {
        return this.amount;
    }

    public long calculateWinAmount(int matchCount) {
        return this.amount * matchCount;
    }

    public String getBonusContext() {
        return name().endsWith("_BONUS") ? ", 보너스 볼 일치" : " ";
    }

    public static int getMinMatchCount() {
        return THREE.count;
    }

    public static LottoMatch findByCount(int count, boolean isMatchBonus) {
        if (count == 5 && isMatchBonus) {
            return FIVE_BONUS;
        }

        return Arrays.stream(values())
                .filter(lottoMatch -> lottoMatch.count == count)
                .findFirst()
                .orElse(null);
    }
}
