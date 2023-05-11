package domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningMoney;

    LottoResult(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static List<LottoResult> findByWinning() {
        return Arrays.stream(LottoResult.values())
            .filter(e -> e != NONE)
            .sorted(Comparator.comparingInt(LottoResult::winningMoney))
            .collect(Collectors.toList());
    }

}
