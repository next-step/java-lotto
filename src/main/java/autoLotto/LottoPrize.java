package autoLotto;

import java.util.Arrays;

public enum LottoPrize {
    MISS(-1, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchedCount;
    private final boolean hitBonusNumber;
    private final int prize;

    LottoPrize(int matchedCount, boolean hitBonusNumber, int prize) {
        this.matchedCount = matchedCount;
        this.hitBonusNumber = hitBonusNumber;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isHitBonusNumber() {
        return hitBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize valueOf(MatchedLottoCount matchedLottoCount) {
        return Arrays.stream(values())
                     .filter(it -> matchedLottoCount.validate(it))
                     .findFirst()
                     .orElse(MISS);
    }

    @Override
    public String toString() {
        String result = String.format("%d개 일치", matchedCount);
        if (hitBonusNumber) {
            result += ", 보너스 볼 일치";
        }
        return String.format("%s (%,d원)", result, prize);
    }

}
