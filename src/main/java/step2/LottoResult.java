package step2;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult getResult(Lotto lotto, Lotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}
