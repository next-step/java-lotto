package lotto;

import java.util.Arrays;


/**
 * 선언된 순서대로 출력하기 때문에 순서를 유지하면서 추가하거나 삭제해야 한다.
 */
public enum LottoResult {
    NONE(0, BonusMatch.ANY, 0),
    FIFTH(3, BonusMatch.ANY, 5_000),
    FOURTH(4, BonusMatch.ANY, 50_000),
    THIRD(5, BonusMatch.NO, 1_500_000),
    SECOND(5, BonusMatch.YES, 30_000_000),
    FIRST(6, BonusMatch.ANY, 2_000_000_000),
    ;

    private final int matchCount;
    private final BonusMatch requiresBonusMatch;
    private final int prize;

    LottoResult(int matchCount, BonusMatch requiresBonusMatch, int prize) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public static LottoResult getResult(Lotto winningLotto, Lotto lotto, LottoNumber bonusLottoNumber) {
        int matchCount = lotto.getMatchCount(winningLotto);
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> {
                    boolean isCountMatched = lottoResult.matchCount == matchCount;
                    if (lottoResult.requiresBonusMatch == BonusMatch.ANY) {
                        return isCountMatched;
                    }
                    boolean isBonusMatched = lotto.contains(bonusLottoNumber);
                    if (lottoResult.requiresBonusMatch == BonusMatch.NO) {
                        return isCountMatched && !isBonusMatched;
                    }
                    return isCountMatched && isBonusMatched;
                })
                .findFirst()
                .orElse(LottoResult.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    private enum BonusMatch {
        YES,
        NO,
        ANY
    }
}
