package lotto.domain.rank;

import lotto.domain.lotto.LottoMatchCount;

public class MatchCondition {
    private final LottoMatchCount matchCount;
    private final BonusMatch needBonusMatch;

    public MatchCondition(int matchCount, boolean needBonusMatch) {
        this(new LottoMatchCount(matchCount), new BonusMatch(needBonusMatch));
    }

    public MatchCondition(LottoMatchCount matchCount, BonusMatch needBonusMatch) {
        this.matchCount = matchCount;
        this.needBonusMatch = needBonusMatch;
    }

    public boolean smallerMatchCountThan(LottoMatchCount target) {
        return matchCount.smallerThan(target);
    }

    public int matchCount() {
        return this.matchCount.value();
    }

    public boolean needBonusMatch() {
        return this.needBonusMatch.value();
    }

    public boolean match(LottoMatchCount matchCount, boolean bonusMatch) {
        if (needBonusMatch()) {
            return countMatch(matchCount) && bonusMatch(bonusMatch);
        }
        return countMatch(matchCount);
    }

    private boolean countMatch(LottoMatchCount matchCount) {
        return this.matchCount.equals(matchCount);
    }

    private boolean bonusMatch(boolean bonusMatch) {
        return this.needBonusMatch.value() && bonusMatch;
    }


    private static class BonusMatch {
        private final boolean value;

        public BonusMatch(boolean value) {
            this.value = value;
        }

        public boolean value() {
            return this.value;
        }
    }
}
