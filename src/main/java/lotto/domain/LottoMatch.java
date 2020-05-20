package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoMatch {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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

    public long getWinAmount(int matchCount) {
        return this.amount * matchCount;
    }

    public static int getMinMatchCount() {
        return THREE.count;
    }

    public static LottoMatch findByCount(int count) {
        return Arrays.stream(values())
                .filter(lottoMatch -> lottoMatch.count == count)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
