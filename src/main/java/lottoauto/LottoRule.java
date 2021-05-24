package lottoauto;

public enum LottoRule {
    THREE_HIT(new HitCount(3), new Money(5000)),
    FOUR_HIT(new HitCount(4), new Money(50000)),
    FIVE_HIT(new HitCount(5), new Money(1500000)),
    SIX_HIT(new HitCount(6), new Money(2000000000));

    private HitCount hitCount;
    private Money winningMoney;

    LottoRule(HitCount hitCount, Money winningMoney) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
    }

    public Money winningMoney() {
        return winningMoney;
    }

    public boolean isEqualsHitCount(HitCount hitCount) {
        return this.hitCount.equals(hitCount);
    }

    @Override
    public String toString() {
        return hitCount.toString() + "개" + "일치 (" + winningMoney.toString() + ")-";
    }

    public int calcProceed(int count) {
        return winningMoney.calcProceed(count);
    }
}
