package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private static final Map<String, LottoPrize> PRIZE_MAP = Arrays.stream(values())
                                                                   .collect(Collectors.toMap(LottoPrize::getLottoPrizeId, Function.identity()));


    LottoPrize(int matchedCount, boolean hitBonusNumber, int prize) {
        this.matchedCount = matchedCount;
        this.hitBonusNumber = hitBonusNumber;
        this.prize = prize;
    }

    String getLottoPrizeId() {
        return String.valueOf(matchedCount) + hitBonusNumber;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize valueOf(long matched, boolean hitBonusNumber) {
        if (matched < FIFTH.matchedCount || matched > FIRST.matchedCount) {
            matched = -1;
        }
        return PRIZE_MAP.get(String.valueOf(matched) + hitBonusNumber);
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
