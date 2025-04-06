package autoLotto;

public class MatchedLottoCount {
    private int matchedMainCount;
    private boolean matchedBonus;

    public MatchedLottoCount(int matchedMainCount, boolean matchedBonus) {
        this.matchedMainCount = matchedMainCount;
        this.matchedBonus = matchedBonus;
    }

    public int getMatchedMainCount() {
        return matchedMainCount;
    }

    public boolean validate(LottoPrize lottoPrize) {
        return this.matchedMainCount == lottoPrize.getMatchedCount() &&
               this.matchedBonus == lottoPrize.isHitBonusNumber();
    }
}
