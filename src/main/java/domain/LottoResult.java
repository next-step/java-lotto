package domain;

import java.util.Arrays;

public enum LottoResult {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningMoney;

    LottoResult(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoResult findBy(Lotto winningLotto, Lotto lotto) {
        return LottoResult.findByMatchCount(winningLotto.matchCount(lotto));
    }

    public static LottoResult findByMatchCount(int matchCount) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResultType -> lottoResultType.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }
}
