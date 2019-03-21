package lotto;

import lotto.domain.MatchLotto;

public class LottoResult {

    private MatchLotto matchLotto;

    public LottoResult() {
        this.matchLotto = new MatchLotto();
    }

    public void addMatchCount(int matchCount) {
        this.matchLotto.addMatchCount(matchCount);
    }

    public MatchLotto checkResult() {
        return matchLotto;
    }

    public double calculateRate(int money) {
        long prizeMoney = matchLotto.sumPrizeMoney();
        return (double) prizeMoney / money;
    }

    public void addBonusCount(boolean matchBonus) {
        if (matchBonus) {
            this.matchLotto.addBonusCount();
        }
    }
}
