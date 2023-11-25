package lotto.domain;

public class MatchCount {
    private int originMatchCount;
    private int bonusMatchCount;

    public MatchCount() {
        this.originMatchCount = 0;
        this.bonusMatchCount = 0;
    }

    public void increaseOriginMatchNumber() {
        this.originMatchCount++;
    }

    public void increaseBonusMatchNumber() {
        this.bonusMatchCount++;
    }

    public int getLottoOriginMatchNumber() {
        return this.originMatchCount;
    }

    public int getLottoBonusMatchNumber() {
        return this.bonusMatchCount;
    }
}
