package lotto;

import java.util.Arrays;

/**
 * 선언된 순서대로 출력하기 때문에 순서를 유지하면서 추가하거나 삭제해야 한다.
 */
public enum LottoResult {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult getResult(Lotto winningLotto, Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.matchCount == matchCount)
                .findFirst()
                .orElse(LottoResult.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
