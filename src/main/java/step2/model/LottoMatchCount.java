package step2.model;

import java.util.Objects;

public class LottoMatchCount {

    private final Integer matchCount;
    private final LottoBonusResult lottoBonusResult;

    private LottoMatchCount(Integer matchCount, LottoBonusResult lottoBonusResult) {
        this.matchCount = matchCount;
        this.lottoBonusResult = lottoBonusResult;
    }

    public static LottoMatchCount of(Integer matchCount, boolean isMatchLottoBonusNumber) {
        return new LottoMatchCount(matchCount, LottoBonusResult.of(matchCount, isMatchLottoBonusNumber));
    }

    public static LottoMatchCount newInstance(Integer matchCount, LottoBonusResult lottoBonusResult) {
        return new LottoMatchCount(matchCount, lottoBonusResult);
    }

    public Integer toInt() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoMatchCount)) {
            return false;
        }
        LottoMatchCount that = (LottoMatchCount) o;
        return Objects.equals(matchCount, that.matchCount) &&
            lottoBonusResult == that.lottoBonusResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusResult);
    }
}
