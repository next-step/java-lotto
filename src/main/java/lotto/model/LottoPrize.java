package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, BonusBallMatch.BOTH),
    SECOND(5, 30_000_000, BonusBallMatch.YES),
    THIRD(5, 1_500_000, BonusBallMatch.NO),
    FOURTH(4, 50_000, BonusBallMatch.BOTH),
    FIFTH(3, 5_000, BonusBallMatch.BOTH),
    NONE(0, 0, BonusBallMatch.BOTH);

    private static final Map<Integer, LottoPrize> map = new HashMap<>();

    private final int matchCount;
    private final int amount;
    private final BonusBallMatch bonusBall;

    LottoPrize(int matchCount, int amount, BonusBallMatch bonusBallMatch) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.bonusBall = bonusBallMatch;
    }

    static {
        for (LottoPrize prize : LottoPrize.values()) {
            map.put(prize.matchCount, prize);
        }
    }

    public int getAmount() {
        return amount;
    }

    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        LottoPrize prize = map.getOrDefault(matchCount, NONE);
        if (prize.equals(LottoPrize.THIRD) && matchBonus) {
            prize = LottoPrize.SECOND;
        }
        return prize;
    }

    public String comment(){
        if (BonusBallMatch.YES.equals(bonusBall)) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + amount + "원)";
        }

        return matchCount + "개 일치 (" + amount + "원)";
    }
}
