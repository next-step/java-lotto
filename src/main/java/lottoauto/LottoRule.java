package lottoauto;

public enum LottoRule {
    THREE_HIT(new HitCount(3), new Money(5_000)),
    FOUR_HIT(new HitCount(4), new Money(50_000)),
    FIVE_HIT(new HitCount(5), new Money(1_500_000)),
    FIVE_HIT_WITH_BONUS(new HitCount(5), new Money(30_000_000)),
    SIX_HIT(new HitCount(6), new Money(2_000_000_000));

    private HitCount hitCount;
    private Money winningMoney;

    LottoRule(HitCount hitCount, Money winningMoney) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
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
