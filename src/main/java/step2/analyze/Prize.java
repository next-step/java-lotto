package step2.analyze;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    KRW_0_000(0, 0),
    KRW_5_000(3, 5_000),
    KRW_50_000(4, 50_000),
    KRW_1_500_000(5, 1_5000_000),
    KRW_2_000_000_000(6, 2_000_000_000);

    private final int matchCount;
    private final int earningMoney;

    Prize(int matchCount, int earningMoney) {
        this.matchCount = matchCount;
        this.earningMoney = earningMoney;
    }

    public static int calculateEarningMoney(int matchCount, int lottoGameCount) {
        return getPrice(matchCount) * lottoGameCount;
    }

    public static int getPrice(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(Optional.of(KRW_0_000).get())
                .earningMoney;
    }
}
